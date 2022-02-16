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
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode();

        result.next = head;
        ListNode before = result, cur = head;

        while (cur != null && cur.next != null) {
            before.next = cur.next;
            cur.next = cur.next.next;
            before.next.next = cur;


            before = cur;
            cur = cur.next;
        }

        return result.next;
    }
}