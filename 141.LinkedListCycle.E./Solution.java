public class Solution {
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }


    ListNode p1 = head;
    ListNode p2 = head.next;

    while(p1 != null && p2 != null) {
      if (p1 == p2) {
        return true;
      }

      if (p2.next == null) {
        return false;
      }

      p1 = p1.next;
      p2 = p2.next.next;
    }

    return false;
  }

  public static void main(String[] args) {
    // TODO
  }
}
