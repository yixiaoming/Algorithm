package leetcode;/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;

        String maxStr = "";
        for(int i=0; i<s.length()-1; i++){
            String oddStr = plaindrome(s, i, i);
            String evenStr = plaindrome(s, i, i+1);
            String tempMax = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if(tempMax.length()> maxStr.length()){
                maxStr = tempMax;
            }
        }    
        return maxStr;
    }

    public String plaindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }

    // 动态规划
    // public String longestPalindrome(String s) {
    //     int len = s.length();
    //     if(len < 2) return s;

    //     int maxLen = 1;
    //     int start = 0;

    //     boolean[][] dp = new boolean[len][len];
    //     for(int i=0; i<len; i++) dp[i][i] = true;
    //     for(int j=1; j<len; j++){
    //         for(int i=0; i<j; i++){
    //             if(s.charAt(i) != s.charAt(j)) {
    //                 dp[i][j] = false;
    //             } else {
    //                 if( j-i < 3){
    //                     dp[i][j] = true;
    //                 } else{
    //                     dp[i][j] = dp[i+1][j-1];
    //                 }
    //             }

    //             if(dp[i][j]){
    //                 int tempLen = j-i+1;
    //                 if(tempLen>maxLen){
    //                     maxLen = tempLen;
    //                     start = i;
    //                 }
    //             }
    //         }
    //     }
    //     return s.substring(start, start+maxLen);
    // }
}
// @lc code=end
