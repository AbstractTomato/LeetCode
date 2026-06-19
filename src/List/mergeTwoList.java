package List;


/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class mergeTwoList {
    public ListNode2 mergeTwoLists1(ListNode2 list1, ListNode2 list2){
        ListNode2 dummy = new ListNode2();
        ListNode2 cur = dummy;
        
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
        }

        if (list1 != null){
            cur.next = list1;
        }else {
            cur.next = list2;
        }

        return dummy.next;

    }

}
