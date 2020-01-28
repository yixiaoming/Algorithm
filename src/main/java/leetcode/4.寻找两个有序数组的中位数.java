package leetcode;/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */

 /**
  * 4.寻找两个有序数组的中位数
  */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int allLen = nums1.length + nums2.length;
        int[] nums = new int[allLen/2 + 1];

        int i = 0;
        int a = 0;
        int b = 0;
        while(i<nums.length){
            if(a<nums1.length && b<nums2.length){
                nums[i++] = nums1[a] <= nums2[b] ? nums1[a++] : nums2[b++];
            } else if(a<nums1.length){
                nums[i++] = nums1[a++];
            } else if(b<nums2.length){
                nums[i++] = nums2[b++];
            }
        }

        if(allLen%2==0){
            return (nums[i-1]+nums[i-2])/2.0F;
        }else{
            return nums[i-1];
        }
    }
}
// @lc code=end
