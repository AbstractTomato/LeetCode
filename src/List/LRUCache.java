package List;


import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCache {

    public static class Node{
        int key, value;
        Node prev, next;

        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }

    private final int capacity;
    //哨兵节点
    private final Node dummy = new Node(0,0);
    private final Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public int get(int key) {
        //getNode会把移到头部
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null){
            node.value = value;
            return;
        }
        //如果没有
        node = new Node(key, value);
        keyToNode.put(key, node);
        pushFront(node);

        //如果超出
        if (keyToNode.size() > capacity){
            //拿掉最后一个节点
            Node prev = dummy.prev;
            keyToNode.remove(prev.key);
            delete(prev);
        }

    }


    //获取key对应的节点,并且把该节点移到最前端
    private Node getNode(int key){
        //如果没有
        if (!keyToNode.containsKey(key)){
            return null;
        }

        Node node = keyToNode.get(key);
        //先移除,然后再添加到头部
        delete(node);
        pushFront(node);
        return node;
    }

    //删除一个节点
    private void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //把一个节点放在链表最前面
    private void pushFront(Node node){
        node.prev = dummy;
        node.next = dummy.next;
        node.prev.next = node;
        node.next.prev = node;
    }
}
