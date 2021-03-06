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

  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }

    /*
                 p         c
    [initial] -> 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
    */

    ListNode prev = new ListNode(0);
    ListNode initial = prev;
    ListNode current = head;
    prev.next = current;

    while(current != null) {
      if (current.val == val) {
        prev.next = current.next;
      } else {
        prev = current;
      }

      current = prev.next;
    }

    return initial.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(6);
    ListNode n4 = new ListNode(3);
    ListNode n5 = new ListNode(4);
    ListNode n6 = new ListNode(5);
    ListNode n7 = new ListNode(6);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;

    ListNode newNode = s.removeElements(n1, 6);

    while(newNode != null) {
      System.out.println(newNode.val);
      newNode = newNode.next;
    }
  }
}
