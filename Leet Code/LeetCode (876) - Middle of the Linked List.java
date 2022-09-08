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
    public ListNode middleNode(ListNode head) {
        ListNode middle = head, tail = head;

        while (middle.next != null && tail.next != null) {
            middle = middle.next;

            if (tail.next.next == null) {
                return middle;
            }

            tail = tail.next.next;
        }

        return middle;
    }
}