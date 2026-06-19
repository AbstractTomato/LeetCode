package List;


/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class addTwoNumbers {
    //采用迭代的方法
    public ListNode2 addTwoNumbers1(ListNode2 l1, ListNode2 l2){
        //初始化哨兵节点,形成空链表,返回结果的时候,返回dummy.next即可
        ListNode2 dummy = new ListNode2();
        ListNode2 cur = dummy;

        //进位
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            int sum = carry;

            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            //新的节点保存的数据
            cur = cur.next = new ListNode2(sum % 10);

            carry = sum / 10;
        }

        return dummy.next;
    }

    //采用递归的方法
    public ListNode2 addTwoNumbers2(ListNode2 l1, ListNode2 l2){
        return addTwo(l1, l2, 0);
    }

    private ListNode2 addTwo(ListNode2 l1, ListNode2 l2, int carry){
        //递归的边界条件
        if (l1 == null && l2 == null && carry == 0){
            return null;
        }

        int sum = carry;
        if (l1 != null){
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null){
            sum += l2.val;
            l2 = l2.next;
        }
        carry = sum / 10;

        return new ListNode2(sum % 10, addTwo(l1, l2, carry));

    }
}


