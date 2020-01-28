package leetcode;/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int Ra = a.length() - 1;
        int Rb = b.length() - 1;
        int plus = 0;
        while (Ra >= 0 || Rb >= 0 || plus != 0) {
            int ia = Ra >= 0 ? a.charAt(Ra) - '0' : 0;
            int ib = Rb >= 0 ? b.charAt(Rb) - '0' : 0;
            sb.append((char) ('0' + (ia + ib + plus) % 2));
            plus = (plus + ia + ib) / 2;
            Ra--;
            Rb--;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

