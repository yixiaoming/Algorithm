package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    // dp解法
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[1] = 1;
        G[2] = 2;
        for(int i=3; i<=n; i++){
            for(int j=1; j<=i; j++){
               G[i] = G[j-1] * G[i-j];
            }
        }
        return G[n];
    }

    // 递归解法
    public int process(int start, int end){
        if(end < start) return 1;
        if(end == start) return 1;
        int all = 0;
        for(int i=start; i<=end; i++){
            int left = process(start, i-1);
            int right = process(i+1, end);
            all += left*right;
        }
        return all;
    }
}
// @lc code=end

