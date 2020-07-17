import jdk.internal.org.jline.utils.Curses;
import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int maxResult = nums[0];
        int[][] matrix = new int[nums.length][2];
        if(nums[0] > 0) {
            matrix[0][0] = nums[0];
        } else{
            matrix[0][1] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            int a = matrix[i - 1][0] == 0 ? 1 : matrix[i - 1][0];
            int b = matrix[i - 1][1] == 0 ? 1 : matrix[i - 1][1];

            matrix[i][0] = Math.max(a * nums[i], b * nums[i]);
            matrix[i][1] = Math.min(a * nums[i], b * nums[i]);
            if(matrix[i][0] < 0) matrix[i][0] = 0;
            if(matrix[i][1] > 0) matrix[i][1] = 0;

            maxResult = Math.max(matrix[i][0], maxResult);

        }
        return maxResult;
    }
}
// @lc code=end

