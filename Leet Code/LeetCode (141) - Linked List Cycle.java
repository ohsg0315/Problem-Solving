/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        int cnt = 100001;

        while (head != null) {
            if (head.val > 100_000) {
                return true;
            }

            head.val = cnt++;
            head = head.next;
        }

        return false;
    }
}