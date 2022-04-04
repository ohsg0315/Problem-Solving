/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int target = k - 1;
        ListNode result = new ListNode();
        result.next = head;

        ListNode beforeFirst = result, first = head;
        for (int i = 0; i < target; i++) {
            beforeFirst = beforeFirst.next;
            first = first.next;
        }

        ListNode beforeSecond = result, second = head, buf = first;
        while (buf.next != null) {
            buf = buf.next;
            beforeSecond = beforeSecond.next;
            second = second.next;
        }

        if (first.next == second) {
            beforeFirst.next = second;
            first.next = second.next;
            second.next = first;
        } else if (second.next == first) {
            beforeSecond.next = first;
            second.next = first.next;
            first.next = second;
        } else {
            buf = first.next;
            beforeFirst.next = second;
            beforeSecond.next = first;
            first.next = second.next;
            second.next = buf;
        }
        return result.next;
    }
}