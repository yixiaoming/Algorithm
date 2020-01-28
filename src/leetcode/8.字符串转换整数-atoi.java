package leetcode;/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        
        int i=0;
        int sign = 1;
        while(i < str.length() && str.charAt(i) == ' ') i++;
        if(i == str.length()) return 0;
        if( str.charAt(i) == '-') sign = -1;
        if( str.charAt(i) == '-' || str.charAt(i) == '+' ) i++;
        int num = 0;
        while (i < str.length()){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                if(num > Integer.MAX_VALUE/10 || 
                    (num==Integer.MAX_VALUE/10 && str.charAt(i)-'0' > Integer.MAX_VALUE%10)){
                        return sign>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
                    }
                num = num*10 + str.charAt(i)-'0';
            } else {
                break;
            }
            i++;
        }
        return sign*num;
    }
}

// @lc code=end