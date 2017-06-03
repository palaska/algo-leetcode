/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    /// This part is unnecessary. Better implementation: create a dummy node for initializing,
     // start iterating from there. At the end, return dummy.next

    if (l1 == null && l2 == null) {
      return null;
    }

    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    int minVal = l1.val;
    if (l2.val < l1.val) {
      minVal = l2.val;
      l2 = l2.next;
    } else {
      l1 = l1.next;
    }

    ListNode head = new ListNode(minVal);
    ListNode current = head;
    ///

    while(l1 != null || l2 != null) {
      if (l1 == null) {
        current.next = l2;
        return head;
      }

      if (l2 == null) {
        current.next = l1;
        return head;
      }

      if (l2.val < l1.val) {
        current.next = new ListNode(l2.val);
        l2 = l2.next;
      } else {
        current.next = new ListNode(l1.val);
        l1 = l1.next;
      }

      current = current.next;
    }

    return head;
  }

  public static void main(String[] args) {
  }
}
