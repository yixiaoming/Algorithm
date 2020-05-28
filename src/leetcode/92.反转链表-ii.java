/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode a = newHead;
        ListNode c = newHead;
        while(--m>0){a = a.next;}
        while(--n>=0){c = c.next;}
        ListNode b = a.next;
        ListNode d = c.next;

        ListNode p = b;
        ListNode q = p.next;
        while(q != d){
            ListNode o = q.next;
            q.next = p;
            p = q;
            q = o;
        }

        a.next = c;
        b.next = d;
        return newHead.next;
    }
}
// @lc code=end

