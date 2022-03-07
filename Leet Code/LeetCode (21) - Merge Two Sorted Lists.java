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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(), cur = result;

        while (true) {
            if (list1 == null) {
                cur.next = list2;
                return result.next;
            } else if (list2 == null) {
                cur.next = list1;
                return result.next;
            }

            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }else {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }
        }
    }
}