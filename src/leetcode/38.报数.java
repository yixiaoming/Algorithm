package leetcode;/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String result = "1";
        while (n-- > 1) {
            int count = 1;
            StringBuffer temp = new StringBuffer();
            for (int i = 0; i < result.length(); i++) {
                if (i == result.length() - 1 || result.charAt(i) != result.charAt(i + 1)) {
                    temp.append((char)('0' + count));
                    temp.append(result.charAt(i));
                    count = 1;
                } else {
                    count++;
                }
            }
            result = temp.toString();
        }
        return result;
    }
}
// @lc code=end
