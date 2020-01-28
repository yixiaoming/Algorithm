package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c=='{'){
                stack.push(c);
            } else {
                if(stack.size() == 0) return false;
                char matchC = stack.pop();
                if (c == ')' && matchC != '(') return false;
                if (c == ']' && matchC != '[') return false;
                if (c == '}' && matchC != '{') return false;
            }
        }
        if(stack.size()>0) return false;
        return true;
    }
}
// @lc code=end

