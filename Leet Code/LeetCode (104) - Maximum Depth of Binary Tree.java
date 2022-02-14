import java.util.LinkedList;
import java.util.Queue;

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
    private class Node {
        TreeNode treeNode;
        int depth;

        public Node(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {
        int result = 0;
        Queue<Node> queue = new LinkedList<>();

        if (root == null) {
            return 0;
        }

        queue.add(new Node(root, 1));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result = Math.max(result, node.depth);

            if (node.treeNode.left != null) {
                queue.add(new Node(node.treeNode.left, node.depth + 1));
            }

            if (node.treeNode.right != null) {
                queue.add(new Node(node.treeNode.right, node.depth + 1));
            }

        }

        return result;
    }
}