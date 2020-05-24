/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode q = new ListNode(-1);
        ListNode p = head;
        head = q;

        while (p != null) {
            int val = p.val;
            int count = 0;
            while (p != null && p.val == val) {
                count++;
                p = p.next;
            }
            if (count == 1) {
                q.next = new ListNode(val);
                q = q.next;
            }
        }
        return head.next;
    }
}
// @lc code=end

