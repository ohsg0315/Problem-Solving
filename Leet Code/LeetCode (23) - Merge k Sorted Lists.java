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
    public ListNode mergeKLists(ListNode[] lists) {
        int listLength = lists.length, valid;
        ListNode result = new ListNode(), cur = result;

        while (true) {
            valid = 0;
            int index = 0, value = Integer.MAX_VALUE;

            for (int i = 0; i < listLength; i++) {
                if (lists[i] != null) {
                    valid++;

                    if (lists[i].val <= value) {
                        index = i;
                        value = lists[i].val;
                    }
                }
            }

            if (valid > 0) {
                cur.next = lists[index];
                cur = cur.next;
                lists[index] = lists[index].next;
            } else {
                break;
            }
        }

        return result.next;
    }
}