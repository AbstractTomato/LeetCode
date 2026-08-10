package FenZhi;


/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class mergeKList {
    public ListNode mergeKLists(ListNode[] lists){
        //将链表串起来
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode head : lists) {
            if (head == null) continue;

            tail.next = head;
            while (tail.next != null){
                tail = tail.next;
            }
        }

        return sort(dummy.next);
    }

    private ListNode sort(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sort(head);
        ListNode right = sort(tmp);


        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (left != null && right != null){
            if (left.val < right.val){
                p.next = left;
                left = left.next;
            }else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }

        p.next = left == null ? right : left;

        return dummy.next;
    }
}
