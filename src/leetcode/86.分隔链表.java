/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * 输入: head = 1->4->3->2->5->2, x = 3
   输出:        1->2->2->4->3->5
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode pSmall = small;
        ListNode big = new ListNode(0);
        ListNode pBig = big;
        while(head != null){
            if(head.val < x){
                pSmall.next = new ListNode(head.val);
                pSmall = pSmall.next;
            } else{
                pBig.next = new ListNode(head.val);
                pBig = pBig.next;
            }
            head = head.next;
        }
        pSmall.next = big.next;
        return small.next;
    }
}
// @lc code=end

