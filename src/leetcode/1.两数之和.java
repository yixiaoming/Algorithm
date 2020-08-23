package leetcode;
/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }

    public static void printMap(Map<Integer, Integer> map){
        for(Integer i : map.keySet()) {
            System.out.printf("[key:"+i+",value:"+map.get(i)+"],");
        }
        System.out.println();
    }
}
// @lc code=end

