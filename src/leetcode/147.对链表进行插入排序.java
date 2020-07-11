import sun.jvm.hotspot.gc.g1.HeapRegion;

/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode headPre = new ListNode(0);
        headPre.next = head;

        ListNode pre = headPre;

        while(pre.next !=null){
            ListNode next = pre.next.next;
            ListNode pi = headPre;
            for(; pi != pre; pi = pi.next){
                if(pi.next.val > pre.next.val){
                    ListNode pj = pi.next;
                    pi.next = pre.next;
                    pre.next.next = pj;
                    pre.next = next;
                    break;
                }
            }
            if(pi == pre) pre = pre.next;
        }

        return headPre.next;
    }
}
// @lc code=end

