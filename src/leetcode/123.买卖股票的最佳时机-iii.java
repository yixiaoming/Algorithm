/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 找到两次最大的波峰
        int i=0; 
        int volley = 0;
        int peek = 0;

        int[] profits = new int[]{0,0};

        while(i < prices.length - 1){
            while(i+1 < prices.length && prices[i] >= prices[i+1]) {
                i++;
            }
            System.out.println("start:"+i);
            volley = prices[i];

            while(i+1<prices.length && prices[i] <= prices[i+1]) {
                i++;
            }
            System.out.println("end:"+i);
            peek = prices[i];
            
            int profit = peek-volley;

            System.out.println("profit:"+profit);

            int minProfitIndex = profits[0]>profits[1] ? 1:0;
            if(profit>profits[minProfitIndex]){
                profits[minProfitIndex] = profit;
            }
        }
        return profits[0]+profits[1];
    }
}
// @lc code=end

