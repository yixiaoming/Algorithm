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
        int len = 0, L = 0, R = L;
        HashSet<Character> set = new HashSet<>();
        while(R < s.length()){
            if(!set.contains(s.charAt(R))) {
                set.add(s.charAt(R++));
            } else {
                set.remove(s.charAt(L++));
            }
            if(set.size() > len) len = set.size();
        }
        return len;
    }
}
// @lc code=end

