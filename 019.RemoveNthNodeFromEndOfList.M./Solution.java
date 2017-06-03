import java.util.LinkedList;

public class Solution {
  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      public String toString() {
        return this.val + ":" + this.next;
      }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    LinkedList<ListNode> que = new LinkedList<ListNode>();
    ListNode result = head;
    que.add(head);
    head = head.next;

    while(head != null) {
      if (que.size() == n + 1) {
        que.poll();
      }

      que.add(head);
      head = head.next;
    }

    if (que.size() == n) {
      return result.next;
    }

    ListNode beforeSkip = que.poll();
    beforeSkip.next = beforeSkip.next.next;

    return result;
  }

  // - - -

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    n1.next = n2;
    System.out.println(s.removeNthFromEnd(n1, 1));
  }
}
