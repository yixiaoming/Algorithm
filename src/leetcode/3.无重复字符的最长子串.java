package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution{

    public int lengthOfLongestSubstring(String s) {
        int L = 0;
        int R = 0;
        int max = Integer.MIN_VALUE;
        Set<Character> charSet = new HashSet<>();
        if( s.length() == 0 ){
            return 0;
        }
        while(R < s.length()){
            if(!charSet.contains(s.charAt(R))){
                charSet.add(s.charAt(R));
                R++;
            }else{
                charSet.remove(s.charAt(L));
                L++;
            }
            max = Math.max(max, R-L);
        }
        return max;
    }
    
    // public int lengthOfLongestSubstring(String s) {
    //     if(s.length() == 0){
    //         return 0;
    //     }
    //     int max = Integer.MIN_VALUE;
    //     for(int i=0; i<s.length(); i++){
    //         int count = 0;
    //         HashSet<Integer> charSet = new HashSet<>();
    //         for(int j=i; j<s.length(); j++){
    //             int c = s.charAt(j);
    //             if(charSet.contains(c)){
    //                 break;
    //             }
    //             charSet.add(c);
    //             count++;
    //         }
    //         max = Math.max(max, count);
    //     }
    //     return max;
    // }
}
// @lc code=end

