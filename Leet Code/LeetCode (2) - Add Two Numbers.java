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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, total; // l1.val과 l2.val의 합이 10 이상인 경우 next node.val에 값을 더해주어야 함
        ListNode head = new ListNode(), cur = head; // return을 위해 head값을 지정

        while (l1 != null || l2 != null || carry > 0) {
            total = 0;
            cur.next = new ListNode(); // next node 생성
            cur = cur.next; // cur = next node

            // l1
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            // l2
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            total += carry;
            carry = total / 10;
            cur.val = total % 10;
        }

        return head.next; // head (비어있음) -> next (실제 시작)
    }
}