import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      public String toString() {
        String str = "val: " + this.val;
        if (this.next != null) {
          str += " | next: " + this.next;
        }

        return str;
      }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    ListNode dummy = new ListNode(0);
    ListNode head = dummy;

    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
      }
    });

    for (ListNode l: lists) {
      if (l != null) {
        pq.add(l);
      }
    }

    while(pq.size() > 0) {
      ListNode l = pq.poll();

      if (l.next != null) {
        pq.add(l.next);
      }

      head.next = l;
      head = head.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode n1 = new ListNode(0);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(5);

    n1.next = n2;
    n2.next = n3;

    ListNode[] lists = new ListNode[] { n1 };

    System.out.println(s.mergeKLists(lists));
    // s.mergeKLists(lists);
    // System.out.println();
  }
}

/*
1 2 5 8
2 4 6 7
3 4 5 6
*/
