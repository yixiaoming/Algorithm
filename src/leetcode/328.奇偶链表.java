/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode even = new ListNode(0);
        ListNode p2 = even;
        ListNode p1 = head;

        while(p1.next != null){
            p2.next = p1.next;
            p2 = p2.next;
            p1.next = p2.next;
            p2.next = null;
            if(p1.next != null){
                p1 = p1.next;
            }
        }
        p1.next = even.next;
        return head;
    }
}
// @lc code=end

