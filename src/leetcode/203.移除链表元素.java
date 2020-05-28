/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        head = prev;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            } else{
                prev = prev.next;
            }
        }
        return head.next;
    }
}
// @lc code=end

