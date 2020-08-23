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
        ListNode p = l1, q = l2, head = new ListNode(0), cur = head;
        while(p != null || q!=null){
            int a = p == null ? 0 : p.val;
            int b = q == null ? 0 : q.val;
            int sum = a+b+jinwei;
            cur.next = new ListNode(sum % 10);
            jinwei = sum / 10;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
            cur = cur.next;
        }
        if(jinwei>0) cur.next = new ListNode(jinwei);
        return head.next;
    }
}
// @lc code=end

