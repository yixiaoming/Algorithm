
class Solution1 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var p = head
        for (i in 1..k) {
            if (p == null) return head
            p = p.next
        }
        var newHead = reverseKGroup(p, k)

        var temp = reverseList(head, p)
        p = temp
        while (p?.next != null) p = p.next
        p!!.next = newHead
        return temp
    }

    fun reverseList(head: ListNode?, tail: ListNode?): ListNode? {
        if (head?.next == null) return head
        var pre: ListNode? = null
        var cur = head
        var next = cur.next
        while (cur != tail) {
            cur!!.next = pre
            pre = cur
            cur = next
            if (next != null) {
                next = next!!.next
            }
        }
        return pre
    }
}

fun main() {
    val solution = Solution1()
    var head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(6)
                    }
                }
            }
        }
    }
    var result = solution.reverseKGroup(head, 4)
    var p = result
    while (p!=null){
        print("${p.`val`},")
        p = p.next
    }
    println()
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}