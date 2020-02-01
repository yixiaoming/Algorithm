/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (39.93%)
 * Likes:    269
 * Dislikes: 0
 * Total Accepted:    48.7K
 * Total Submissions: 121.8K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> results = new LinkedList<>();
        if (intervals.length == 0) return results.toArray(new int[results.size()][]);
        sort(intervals);
        int index = 0;
        int p = index + 1;
        while (p < intervals.length) {
            int[] interval = intervals[index];
            int[] next = intervals[p];
            if (((interval[0] >= next[0] && interval[0] <= next[1]) || (interval[1] >= next[0] && interval[1] <= next[1])) ||
                    (next[0] >= interval[0] && next[0] <= interval[1]) || (next[1] >= interval[0] && next[1] <= interval[1])) {
                intervals[index][0] = Math.min(next[0], interval[0]);
                intervals[index][1] = Math.max(next[1], interval[1]);
            } else {
                results.add(new int[]{interval[0], interval[1]});
                index = p;
            }
            p++;
        }
        results.add(new int[]{intervals[index][0], intervals[index][1]});
        return results.toArray(new int[results.size()][]);
    }

    void sort(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
    }
}
// @lc code=end
