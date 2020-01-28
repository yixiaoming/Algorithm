package leetcode;/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!isCharOrNumber(s.charAt(left)) && left < right)
                left++;
            while (!isCharOrNumber(s.charAt(right)) && right > left)
                right--;
            if (left >= right)
                break;
            if (!isEqualsIgnore(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isEqualsIgnore(char c1, char c2) {
        if (c1 == c2 
            || (isChar(c1) && isChar(c2) && c1 - 32 == c2)
            || (isChar(c1) && isChar(c2) && c2 - 32 == c1)
            ) {
            return true;
        }
        return false;
    }

    public boolean isCharOrNumber(char c) {
        return isChar(c) || isNumber(c);
    }

    public boolean isChar(char c){
        return c >= 'A' && c <= 'Z'
            || c >= 'a' && c <= 'z';
    }

    public boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
}
// @lc code=end

