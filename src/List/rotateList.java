package List;


/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class rotateList {
    public ListNode2 rotateRight(ListNode2 head, int k){
        if (head == null || k == 0){
            return head;
        }

        int count = 0;
        for (ListNode2 cur = head; cur != null; cur = cur.next){
            count++;
        }
        k %= count;
        if (k == 0){
            return head;
        }

        //对整个链表进行翻转
        head = reverse(head, 1, count);

        //对前k个节点进行翻转
        head = reverse(head, 1, k);

        //对后续节点进行翻转
        ListNode2 tail = head;
        for (int i = 0; i < k - 1; i++){
            tail = tail.next;
        }
        tail.next = reverse(tail.next, 1, count - k);

        return head;
    }

    private ListNode2 reverse(ListNode2 head, int left, int right){
        ListNode2 dummy = new ListNode2(0, head);
        ListNode2 p = dummy;
        for (int i = 0; i < left - 1; i++){
            p = p.next;
        }

        //对应的left节点
        ListNode2 cur = p.next;
        ListNode2 pre = null;
        for (int i = 0; i < right - left + 1; i++){
            ListNode2 nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        p.next.next = cur;
        p.next = pre;

        return pre;
    }
}
