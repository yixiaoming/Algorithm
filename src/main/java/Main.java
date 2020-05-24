public class Main {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        deleteDuplicates(n1);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newp = newHead;
        ListNode p = head.next;
        ListNode q = head;
        boolean hasSame = false;
        while(p != null){
            if(p.val == q.val){
                p = p.next;
                hasSame = true;
                continue;
            }
            if(!hasSame){
                newp.next = q;
                newp = newp.next;
            }
            q = p;
            p = p.next;
            hasSame = false;
            newp.next = null;
        }
        return newHead.next;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }
}

