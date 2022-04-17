/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> list;

    private void search(TreeNode origin) {
        if (origin == null) {
            return;
        }

        search(origin.left);
        list.add(origin.val);
        search(origin.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        TreeNode head = new TreeNode(), cur = head;

        search(root);

        for (int num : list) {
            cur.right = new TreeNode(num);
            cur = cur.right;
        }

        return head.right;
    }
}