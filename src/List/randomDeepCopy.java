package List;


import java.awt.*;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 */
public class randomDeepCopy {
    public Node copyRandomList(Node head){
        //遍历原链表,将复制的节点copy放在原节点之后
        for (Node cur = head; cur != null; cur = cur.next.next){
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
        }

        //复制random
        for (Node cur = head; cur != null; cur = cur.next.next){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
        }

        //分开两个链表
        Node dummy = new Node(0);
        Node tail = dummy;
        for (Node cur = head; cur != null; cur = cur.next, tail = tail.next){
            Node copy = cur.next;
            tail.next = copy;
            cur.next = copy.next;
        }

        return dummy.next;
    }
}
