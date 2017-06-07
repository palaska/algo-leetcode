import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class LRUCache {
  // good implementation with doubly linked list
  public class DNode {
    int key;
    int val;
    DNode next;
    DNode prev;

    public DNode() {}

    public DNode(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  HashMap<Integer, DNode> cache;
  int capacity;
  int count;
  DNode head;
  DNode tail;

  public LRUCache(int capacity) {
    // initialization
    this.capacity = capacity;
    this.count = 0;
    this.cache = new HashMap<Integer, DNode>();

    // (empty head) ... (empty tail)
    this.head = new DNode();
    this.tail = new DNode();
    this.head.next = tail;
    this.tail.prev = head;
  }

  private void removeDNode(DNode n) {
    DNode prev = n.prev;
    DNode next = n.next;

    prev.next = next;
    next.prev = prev;
  }

  private void moveToHead(DNode n) { // move to the first spot after head
    removeDNode(n);
    n.next = this.head.next;
    n.prev = this.head;

    this.head.next.prev = n;
    this.head.next = n;
  }

  private void addNode(DNode n) { // always add to head (after dummy head)
    n.prev = this.head;
    n.next = this.head.next;

    this.head.next.prev = n;
    this.head.next = n;
  }

  private DNode popTail() {
    DNode t = this.tail.prev;
    removeDNode(this.tail.prev);
    return t;
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      DNode n = cache.get(key);
      moveToHead(n);
      return n.val;
    }

    return -1;
  }

  public void put(int key, int value) {
    DNode node = cache.get(key);
    if (node != null) {
      node.val = value;
      moveToHead(node);
    } else {
      DNode newNode = new DNode(key, value);
      cache.put(key, newNode);
      addNode(newNode);
      count++;

      if (count > capacity) {
        DNode t = popTail();
        cache.remove(t.key);
        count--;
      }
    }
  }

  /*
  slow implementation
  int capacity;
  HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
  Queue<Integer> activityQueue = new LinkedList<Integer>();

  public String toString() {
    return "store: " + this.store + "\n" + "activity queue: " + this.activityQueue;
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (store.containsKey(key)) {
      activityQueue.remove(key);
      activityQueue.add(key);
      return store.get(key);
    }

    return -1;
  }

  public void put(int key, int value) {
    if (store.containsKey(key) || store.size() < this.capacity) {
      store.put(key, value);
    } else {
      int last = activityQueue.remove();
      while(!store.containsKey(last) && activityQueue.size() > 0) {
        last = activityQueue.remove();
      }

      store.remove(last);
      store.put(key, value);
    }

    activityQueue.remove(key);
    activityQueue.add(key);
  }
  */

  public static void main(String[] args) {
    LRUCache cache = new LRUCache( 2 /* capacity */ );
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));       // returns 1
    cache.put(3, 3);    // evicts key 2
    System.out.println(cache.get(2));       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    System.out.println(cache.get(1));       // returns -1 (not found)
    System.out.println(cache.get(3));       // returns 3
    System.out.println(cache.get(4));       // returns 4
  }
}
