package List;


/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class partition {
    public ListNode2 partition(ListNode2 head, int x){
        ListNode2 smallDummy = new ListNode2();
        ListNode2 bigDummy = new ListNode2();

        ListNode2 small = smallDummy;
        ListNode2 big = bigDummy;

        while (head != null){
            int val = head.val;
            if (val < x){
                small.next = head;
                small = small.next;
            }else {
                big.next = head;
                big = big.next;
            }

            head = head.next;
        }

        small.next = bigDummy.next;
        big.next = null;

        return smallDummy.next;
    }
}
