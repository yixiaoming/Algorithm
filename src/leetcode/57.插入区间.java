import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        if(intervals.length == 0){
            result.add(newInterval);
            return result.toArray(new int[1][2]);
        }

        int start = 0;
        int end = intervals.length - 1;

        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        
        while (start < intervals.length && intervals[start][1] < newStart) {
            result.add(intervals[start]);
            start++;
        }
        while (end >= 0 && newEnd < intervals[end][0]) {
            result.add(intervals[end]);
            end--;
        }
        if (start == intervals.length || end == -1) {
            result.add(newInterval);
        }


        if (start < intervals.length && end >= 0) {
            if (newStart >= intervals[start][0]) {
                newStart = intervals[start][0];
            }
            if (newEnd <= intervals[end][1]) {
                newEnd = intervals[end][1];
            }
            result.add(new int[]{newStart, newEnd});
        }
       
        int[][] realResult = result.toArray(new int[result.size()][2]);
        Arrays.sort(realResult, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        return realResult;
    }
}
// @lc code=end

