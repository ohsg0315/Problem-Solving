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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode result = new ListNode(head.val - 1, head);
        ListNode beforeNode = result, curNode = head, afterNode = head.next;

        while (curNode != null && curNode.next != null) {
            afterNode = curNode.next;

            //duplicate
            if (curNode.val == afterNode.val) {
                while (afterNode != null && curNode.val == afterNode.val) {
                    afterNode = afterNode.next;
                    beforeNode.next = afterNode;
                }

                curNode = afterNode;
            }
            //distinct
            else {
                curNode = curNode.next;
                beforeNode = beforeNode.next;
            }
        }

        return result.next;
    }
}