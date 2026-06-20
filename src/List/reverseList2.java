package List;


/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，
 * 其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class reverseList2 {
    public ListNode2 reverseBetween(ListNode2 head, int left, int right){
        ListNode2 dummy = new ListNode2(0, head);
        ListNode2 p0 = dummy;

        for (int i = 0; i < left - 1; i++){
            p0 = p0.next;
        }
        //循环结束时,p0是left前一个

        ListNode2 pre = null;
        //指向left对应的节点
        ListNode2 cur = p0.next;
        for (int i = 0; i < right - left + 1; i++){ //完成指定部分链表的反转
            ListNode2 nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        //此时cur是原先right节点的next节点
        //pre是原先的right节点
        p0.next.next = cur;
        p0.next = pre;

        return dummy.next;
    }

    //链表的反转
    private ListNode2 reverse(ListNode2 head){
        ListNode2 pre = null;
        ListNode2 cur = head;

        while (cur != null){
            //首先要将cur.next记录下来
            ListNode2 nxt = cur.next;
            //反转链表,顾名思义,原链表第一个节点应该是反转链表最后一个节点,那么最后一个节点的next就是null
            cur.next = pre;
            //pre记录的是反转链表的下一个节点
            pre = cur;
            //此时指针移动,移向正向链表的下一个节点
            cur = nxt;
        }
        return pre;
    }
}
