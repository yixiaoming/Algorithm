import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (76.08%)
 * Likes:    455
 * Dislikes: 0
 * Total Accepted:    57K
 * Total Submissions: 74.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;

        results.add(new LinkedList<>());
        int i = 0;
        while (i < nums.length) {
            int j = results.size() - 1;
            while (j >= 0) {
                LinkedList<Integer> newItem = new LinkedList<>(results.get(j));
                newItem.add(nums[i]);
                results.add(newItem);
                j--;
            }
            i++;
        }
        return results;
    }
}
// @lc code=end

