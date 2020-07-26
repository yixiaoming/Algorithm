import java.util.ArrayList;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for(int i=0, j=0; j<nums.length; j++){
            i = j;
            while(j+1<nums.length && nums[j+1] == nums[j] + 1){
                j++;
            }
            if(i==j){
                result.add(""+nums[i]);
            } else{
                result.add(nums[i]+"->"+nums[j]);
            }
        }
        return result;
    }

    // public List<String> summaryRanges(int[] nums) {
    //     List<String> result = new ArrayList<>();
    //     if (nums.length == 0)
    //         return result;
    //     Integer first = null;
    //     Integer second = null;
    //     for (int i = 0; i <= nums.length; i++) {
    //         if (i == nums.length) {
    //             result.add(contact(first, second));
    //             break;
    //         }
    //         if (i != 0 && nums[i] != nums[i - 1] + 1) {
    //             result.add(contact(first, second));
    //             first = null;
    //             second = null;
    //         }
    //         if (first == null) {
    //             first = nums[i];
    //         }
    //         else {
    //             second = nums[i];
    //         }
    //     }
    //     return result;
    // }

    // private String contact(Integer first, Integer second) {
    //     if (second == null)
    //         return first.toString();
    //     return first + "->" + second;
    // }
}
// @lc code=end
