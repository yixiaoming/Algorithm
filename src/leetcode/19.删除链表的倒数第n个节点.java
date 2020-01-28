package leetcode;/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode p = null;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            p = slow;
            slow = slow.next;
        }
        if (p == null ){
            head = head.next;
        } else{
            p.next = p.next.next;
        }
        return head;        
    }
}
// @lc code=end

