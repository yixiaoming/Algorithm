package leetcode;
/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode head = null;
        ListNode pHead = null;
        ListNode p = null;
        while (l1 != null || l2!=null || jinwei>0) {
            int sum = 0;
            if(l1 != null && l2!=null){
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 != null){
                sum = l1.val;
                l1 = l1.next;
            } else if(l2 != null){
                sum = l2.val;
                l2 = l2.next;
            }
            sum += jinwei;
            p = new ListNode(sum%10);
            jinwei = sum/10;
            if(head == null){
                head = p;
                pHead = p;
            }else{
                pHead.next = p;
                pHead = pHead.next;
            }
        }
        return head;
    }
}
// @lc code=end

