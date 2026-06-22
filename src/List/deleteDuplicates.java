package List;


/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class deleteDuplicates {
    public ListNode2 deleteDuplicates(ListNode2 head){
        ListNode2 dummy = new ListNode2(0, head);
        ListNode2 cur = dummy;

        while (cur.next != null && cur.next.next != null){
            int val = cur.next.val;
            if (cur.next.next.val == val){
                while (cur.next != null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public ListNode2 delete(ListNode2 head){
        ListNode2 dummy = new ListNode2(0, head);
        ListNode2 cur = dummy;

        //条件判断
        while (cur.next != null && cur.next.next != null){
            //拿到下一个节点的值
            int val = cur.next.val;

            if (cur.next.next.val == val){
                //如果下一个节点的值与下下个节点的值相等
                //要一直删除不相等的,此时要判断next是不是null
                while (cur.next != null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
            }else {
                //不相等的话,直接next
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
