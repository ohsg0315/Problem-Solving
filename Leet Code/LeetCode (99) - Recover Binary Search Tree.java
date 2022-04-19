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
    private PriorityQueue<Integer> queue;

    private void search(TreeNode root) {
        if (root == null) {
            return;
        }

        search(root.left);

        queue.add(root.val);

        search(root.right);
    }

    private void adjust(TreeNode root) {
        if (root == null) {
            return;
        }

        adjust(root.left);

        root.val = queue.poll();

        adjust(root.right);
    }

    public void recoverTree(TreeNode root) {
        TreeNode head = root;
        queue = new PriorityQueue<>();

        search(root);

        adjust(root);
    }
}