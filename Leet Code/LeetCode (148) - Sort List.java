/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    private ListNode findMiddle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode sort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode middle = findMiddle(node);
        ListNode nextMiddle = middle.next;
        middle.next = null;

        ListNode left = sort(node);
        ListNode right = sort(nextMiddle);


        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode mergedNode = new ListNode(), cur = mergedNode;

        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }

            cur = cur.next;
        }

        cur.next = left == null ? right : left;

        return mergedNode.next;
    }

    public ListNode sortList(ListNode head) {

        return sort(head);
    }
}
