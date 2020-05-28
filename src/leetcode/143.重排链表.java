import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return ;
        }
        List<ListNode> arr = new ArrayList<>();
        ListNode p = head;
        while(p != null){
            arr.add(p);
            p = p.next;
        }

        int i=0;
        int j=arr.size()-1;
        while( i < j) {
            arr.get(i).next = arr.get(j);
            i++;
            if(i==j) break;
            arr.get(j).next = arr.get(i);
            j--;
        }
        arr.get(i).next = null;
    }
}
// @lc code=end

