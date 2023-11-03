import json
import re
import time

import scrapy

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

from selenium.webdriver.common.by import By



class ListSpiderSpider(scrapy.Spider):
    name = "list_spider"
    allowed_domains = ["jd.com"]
    start_urls = ["https://list.jd.com/list.html?cat=1318,12099,9756"]
    # start_urls = ["https://item.jd.com/100018065807.html"]

    driver = None

    def __init__(self):
        #   local chrome版本太高
        service = Service(ChromeDriverManager().install())
        #   设置 selenium
        options = webdriver.ChromeOptions()
        options.add_experimental_option('useAutomationExtension', False)

        #   设置 ua
        options.add_argument("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, "
                             "like Gecko) Chrome/119.0.0.0 Safari/537.36")
        options.add_argument('Sec-Ch-Ua-Platform: "macOS"')
        options.add_argument('Host: www.jd.com')
        options.add_argument("Referer: https://passport.jd.com/")

        self.driver = webdriver.Chrome(service=service, options=options)

        self.driver.get("https://home.jd.com/")
        time.sleep(30)

    def parse(self, response):
        result = re.search("item.jd.com",response.url)
        #   如果为列表页列表爬去，否则详情页
        if result is None:
            node_list = response.xpath('//li[@class="gl-item"]')
            for node in node_list:
                url = "https:" + node.xpath('./div/div[4]/a/@href').extract_first()
                yield scrapy.Request(url)
        else:
            item = {}
            item['title'] = response.xpath('//div[@class="sku-name"]/text()').extract_first()
            #   选择框
            color_nodes = response.xpath('//div[@id="choose-attr-1"]/div[2]/div')
            size_nodes = response.xpath('//div[@id="choose-attr-2"]/div[2]/div')

            #   颜色选择
            colors = []
            for color_node in color_nodes:
                color = color_node.xpath("./@data-value").extract_first()
                colors.append(color)
            item['colors'] = colors
            #   size 选择
            sizes = []
            for size_node in size_nodes:
                size = {}
                size['size'] = size_node.xpath("./@data-value").extract_first()
                size['sku'] = size_node.xpath("./@data-sku").extract_first()
                sizes.append(size)
            item['sizes'] = sizes

            self.driver.get(response.url)

            price = self.driver.find_element(By.XPATH,'//span[@class="p-price"]/span[2]').text
            time.sleep(5)

            item['price'] = price
            js = json.dumps(item, ensure_ascii=False)
            #   保存js文件
            with open("data.json", "a+") as file:
                file.write(js + "\n")


