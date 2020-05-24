/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        k = k % count;

        if(k == 0) return head;

        System.out.println("count:"+count);
        System.out.println("k:"+k);
        
        p = head;
        while(k>0){
            k--;
            p = p.next;
        }
        ListNode q = head;
        while(p.next!=null){
            p = p.next;
            q = q.next;
        }
        ListNode newHead = q.next;
        q.next = null;
        p.next = head;
        return newHead;
    }
}
// @lc code=end

