package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {

    Map<String, String> map = new HashMap<>();
    List<String> results = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return results;
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        process("", digits);
        return results;
    }

    private void process(String nowStr, String digits) {
        if (digits.length() == 0) {
            results.add(nowStr);
            return;
        }
        String digit = digits.substring(0, 1);
        String chars =  map.get(digit);
        for (int i = 0; i < chars.length(); i++) {
            process(nowStr+chars.charAt(i), digits.substring(1));
        }
    }
}
// @lc code=end
