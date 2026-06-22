package List;


/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class removeNode {
    public ListNode2 removeNthFromEnd(ListNode2 head, int n){
        ListNode2 dummy = new ListNode2(0, head);
        ListNode2 left = dummy;
        ListNode2 right = dummy;

        while (n > 0){
            right = right.next;
            n--;
        }

        while (right.next != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;

        return dummy.next;
    }
}
