public class Solution {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int remainder = 0;
    ListNode prevNode = new ListNode(0); // dummy listnode
    ListNode beforeHead = prevNode;
    int cycleCnt = 0;

    while(l1 != null || l2 != null) {
      cycleCnt += 1;
      int total = remainder;
      if (l1 != null) {
        total += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        total += l2.val;
        l2 = l2.next;
      }

      if (total > 9) {
        remainder = total / 10;
        total = total % 10;
      } else {
        remainder = 0;
      }

      ListNode l = new ListNode(total);
      prevNode.next = l;
      prevNode = prevNode.next;
    }

    if (remainder > 0) {
      prevNode.next = new ListNode(remainder);
    }

    return beforeHead.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

  }
}
