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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0, head);
        ListNode targetNode = result, curNode = head;

        while (n-- > 0) {
            curNode = curNode.next;
        }

        while (curNode != null) {
            targetNode = targetNode.next;
            curNode = curNode.next;
        }

        targetNode.next = targetNode.next.next;

        return result.next;
    }
}