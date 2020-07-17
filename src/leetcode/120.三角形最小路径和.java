import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-1; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){
                int val =  triangle.get(i).get(j);
                if(i < triangle.size()-1){
                    val += Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                }
                triangle.get(i).set(j, val);
            }
        }

        return triangle.get(0).get(0);
    }
}
// @lc code=end

