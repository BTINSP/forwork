use core::num;





//  第一题
fn sums(nums: Vec<i32>, target: i32){
        for x in nums.clone() {
            for y in nums.clone() {
                if ( x + y ) == target {
                    let result = vec![x,y];
                    println!("result: {:?}", result);
                    break;
                }
            }
        }
}

fn median (nums1: Vec<i32>, nums2: Vec<i32>) {
    let mut nums = Vec::new();
    //  添加后进行排序
    nums.extend(nums1);
    nums.extend(nums2);
    nums.sort();

    //  取模
    if nums.len() % 2 == 0 {
        let mid = nums[nums.len() / 2];
        println!("Mid: {}", mid)
    } else {
       let mid1 = nums[nums.len() / 2 - 1];
       let mid2 = nums[nums.len() / 2];
       let mid = mid1 as f32 + mid2 as f32 / 2.0;
       println!("Mid: {}", mid)
    }

}
// 运行结果:
// result: [2, 7]
// result: [7, 2]
// Mid: 2

fn main() {
    let nums = vec![2,7,11,15];
    let target = 9;
    sums(nums, target);


    let nums1 = vec![1, 3];
    let nums2 = vec![2];
    median(nums1,nums2);
}


