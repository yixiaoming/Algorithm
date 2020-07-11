/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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

    private ListNode h;
    private boolean result = true;

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        h = head;
        process(head);
        return result;
    }

    private void process(ListNode head) {
        if(head.next != null){
            process(head.next);
        }

        result &= (head.val == h.val);
        h = h.next;
    }
}
// @lc code=end

