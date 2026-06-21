package List;


import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class reverseKGroup {
    public ListNode2 reverseKGroup(ListNode2 head, int k){
        //统计节点个数
        int count = 0;
        for (ListNode2 cur = head; cur != null; cur = cur.next){
            count++;
        }

        ListNode2 dummy = new ListNode2(0, head);
        ListNode2 p = dummy;
        ListNode2 pre = null;
        ListNode2 cur = head;

        //难点在于p的处理,p代表当前要反转这一组的前一个节点
        for (; count >= k; count -= k){
            //k个为一组进行反转
            for (int i = 0; i < k; i++){
                ListNode2 nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }

            //处理p
            ListNode2 nxt = p.next;
            p.next.next = cur;
            p.next = pre;
            p = nxt;
        }

        return dummy.next;
    }

}
