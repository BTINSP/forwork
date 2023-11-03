import datetime
import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager



def run():
    url = "https://www.163.com/"

    #   local chrome版本太高
    service = Service(ChromeDriverManager().install())
    #   设置 selenium
    options = webdriver.ChromeOptions()
    options.add_experimental_option('useAutomationExtension', False)

    #   设置 ua
    options.add_argument("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, "
                         "like Gecko) Chrome/119.0.0.0 Safari/537.36")

    driver = webdriver.Chrome(service=service, options=options)



    driver.get(url)



    while True:
        driver.save_screenshot(str(int(time.time())) + ".png")
        time.sleep(60 * 5)




# 按装订区域中的绿色按钮以运行脚本。
if __name__ == '__main__':
    run()



# 访问 https://www.jetbrains.com/help/pycharm/ 获取 PyCharm 帮助
