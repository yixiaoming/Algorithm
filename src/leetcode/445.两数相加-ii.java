import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> q = new Stack<Integer>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int jinwei = 0;
        int temp = 0;
        while(!s1.isEmpty() && !s2.isEmpty()){
            temp = s1.pop()+s2.pop()+jinwei;
            q.push( temp%10 );
            jinwei = temp/10;
        }
        while(!s1.isEmpty()){
            temp = s1.pop() + jinwei;
            q.push( temp%10 );
            jinwei = temp/10;
        }
        while(!s2.isEmpty()){
            temp = s2.pop() + jinwei;
            q.push( temp%10 );
            jinwei = temp/10;
        }
        if(jinwei>0) q.push(jinwei);

        ListNode result = new ListNode(0);
        ListNode p = result;
        while(!q.isEmpty()){
            ListNode item = new ListNode(q.pop());
            p.next = item;
            p = p.next;
        }
        return result.next;
    }
}
// @lc code=end

