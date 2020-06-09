/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        if(N <= 1) return N;
        if(N == 2) return 1;

        int num1 = 0;
        int num2 = 1;
        int num3 = 0;
        while(N > 1){
            num3 = num1+num2;
            num1 = num2;
            num2 = num3;
            N--;
        }
        return num3;
    }

    // public int fib(int N) {
    //     if(N <= 1) return N;
    //     return fib(N-1) + fib(N-2);
    // }
}
// @lc code=end

