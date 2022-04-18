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
    private List<Integer> numbers;

    private void search(TreeNode node) {
        if (node == null) {
            return;
        }

        search(node.left);

        numbers.add(node.val);

        search(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        numbers = new ArrayList<>();

        search(root);

        return numbers.get(k - 1);
    }
}