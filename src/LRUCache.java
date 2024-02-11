import java.util.HashMap;
import java.util.Map;

class DoublyListNode {
    int val;
    int key;
    DoublyListNode next;
    DoublyListNode previous;
    DoublyListNode() {}
    DoublyListNode(int key, int val) {
        this.val = val;
        this.key = key;
    }
    DoublyListNode(int key, int val, DoublyListNode next, DoublyListNode previous) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.previous = previous;
    }
}

public class LRUCache {

    public void deleteNodeFromDLL(DoublyListNode node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public void deleteFrontNodeFromDLL() {
        head.next.next.previous = head;
        head.next = head.next.next;
    }

    public void insertNodeAtEndInDLL(DoublyListNode node) {
        node.previous = tail.previous;
        node.next = tail;
        node.previous.next = node;
        tail.previous = node;
    }

    public Map<Integer, DoublyListNode> doublyListNodeMap;
    int capacity;
    DoublyListNode head;
    DoublyListNode tail;

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 10);
        System.out.print(lruCache.get(1));
        System.out.print(lruCache.get(2));
        lruCache.print();
        lruCache.put(3, 30);
        System.out.print(lruCache.get(1));
        lruCache.print();
        lruCache.put(2, 20);
        System.out.print(lruCache.get(3));
        lruCache.print();
        lruCache.put(4, 40);
        lruCache.print();
        lruCache.put(2, 20);
        lruCache.print();
        lruCache.put(3, 301);
        lruCache.print();
    }

    public void print() {
        System.out.println("\n");
        DoublyListNode temp = head;
        while(temp != null) {
            System.out.print("[" + temp + ", " + temp.val + "], ");
            temp = temp.next;
        }
        System.out.println("");
        temp = tail;
        while(temp != null) {
            System.out.print("[" + temp + ", " + temp.val + "], ");
            temp = temp.previous;
        }

        System.out.println("\nMap: " + doublyListNodeMap);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.doublyListNodeMap = new HashMap<>();
        this.head = new DoublyListNode();
        this.tail = new DoublyListNode();
        this.head.next = this.tail;
        this.tail.previous = this.head;
    }

    public int get(int key) {
        if(doublyListNodeMap.containsKey(key)) {
            DoublyListNode doublyListNode = doublyListNodeMap.get(key);
            int val = doublyListNode.val;
            deleteNodeFromDLL(doublyListNode);
            insertNodeAtEndInDLL(doublyListNode);
            return val;
        } else {
            return -1;
        }
    }
//
    public void put(int key, int value) {
        if(doublyListNodeMap.containsKey(key)) {
            DoublyListNode doublyListNode = doublyListNodeMap.get(key);
            deleteNodeFromDLL(doublyListNode);
            doublyListNode.val = value;
            insertNodeAtEndInDLL(doublyListNode);
        } else if(capacity == doublyListNodeMap.size()){
            doublyListNodeMap.remove(head.next.key);
            deleteFrontNodeFromDLL();
            DoublyListNode doublyListNode = new DoublyListNode(key, value);
            insertNodeAtEndInDLL(doublyListNode);
            doublyListNodeMap.put(key, doublyListNode);
        } else {
            DoublyListNode doublyListNode = new DoublyListNode(key, value);
            insertNodeAtEndInDLL(doublyListNode);
            doublyListNodeMap.put(key, doublyListNode);
        }
    }
}
