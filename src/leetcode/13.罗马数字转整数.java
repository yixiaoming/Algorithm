package leetcode;/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I': //1
                    result += 1;
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'V') {
                            result += (4 - 1);
                            i++;
                        } else if (s.charAt(i + 1) == 'X') {
                            result += (9 - 1);
                            i++;
                        }
                    }
                    break;
                case 'V': // 5
                    result += 5;
                    break;
                case 'X': //10
                    result += 10;
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'L') {
                            result += (40 - 10);
                            i++;
                        } else if (s.charAt(i + 1) == 'C') {
                            result += (90 - 10);
                            i++;
                        }
                    }
                    break;
                case 'L': // 50
                    result += 50;
                    break;
                case 'C': // 100
                    result += 100;
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'D') {
                            result += (400 - 100);
                            i++;
                        } else if (s.charAt(i + 1) == 'M') {
                            result += (900 - 100);
                            i++;
                        }
                    }
                    break;
                case 'D': // 500
                    result += 500;
                    break;
                case 'M': // 1000
                    result += 1000;
                    break;
            }
        }
        return result;
    }
}
// @lc code=end

