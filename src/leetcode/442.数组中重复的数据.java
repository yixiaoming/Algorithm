import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList();
        for(int item : nums){
            Integer count = map.get(item);
            if(count == null){
                count = 0;
            }
            map.put(item, ++count);
            if(count == 2){
                result.add(item);
            }
        }
        return result;
    }
}
// @lc code=end

