package leetcode;/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        char[] arr = insertS(s);
        String huiwen = "";
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int len = 0;
            int k = 0;
            while (i - k >= 0 && i + k < arr.length && arr[i - k] == arr[i + k]) {
                len++;
                k++;
            }
            if (len > max) {
                max = len;
                StringBuilder sb = new StringBuilder();
                k = i - k < 0 ? i : k;
                k = i + k >= arr.length ? arr.length-1 - i : k;
                if(arr[i - k] != arr[i + k]){
                    k--;
                }
                for (int j = i - k; j <= i + k; j++) {
                    if (arr[j] != '_') {
                        sb.append(arr[j]);
                    }
                }
                huiwen = sb.toString();
            }
        }
        return huiwen;
    }

    public char[] insertS(String s) {
        char[] arr = new char[s.length() * 2 + 1];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[k++] = '_';
            arr[k++] = s.charAt(i);
        }
        arr[k++] = '_';
        return arr;
    }
}
// @lc code=end
