package FenZhi;


/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class sortList {
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        //首先确定链表中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //此时slow的位置就是中点的位置
        ListNode tmp = slow.next;
        //将链表从中间断开
        slow.next = null;


        //递归调用切割链表
        ListNode node = head;
        ListNode left = sortList(node);
        ListNode right = sortList(tmp);

        //哑节点
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
