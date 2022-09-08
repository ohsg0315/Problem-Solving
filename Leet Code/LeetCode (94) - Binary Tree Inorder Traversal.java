import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            searchInorder(root, result);
        }

        return result;
    }

    private void searchInorder(TreeNode node, List<Integer> result) {
        if (node.left != null) {
            searchInorder(node.left, result);
        }

        result.add(node.val);

        if (node.right != null) {
            searchInorder(node.right, result);
        }
    }
}