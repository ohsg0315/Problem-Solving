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
    private class Node{
        TreeNode treeNode;
        int depth;
        int cnt;

        public Node(TreeNode treeNode, int depth, int cnt) {
            this.treeNode = treeNode;
            this.depth = depth;
            this.cnt = cnt;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0, 0));

        int curDepth = 0, left = 0, right = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.depth != curDepth) {
                result = Math.max(result, right - left + 1);
                curDepth = node.depth;
                left = node.cnt;
            }

            right = node.cnt;

            if (node.treeNode.left != null) {
                queue.add(new Node(node.treeNode.left, node.depth + 1, node.cnt * 2));
            }

            if (node.treeNode.right != null) {
                queue.add(new Node(node.treeNode.right, node.depth + 1, node.cnt * 2 + 1));
            }
        }
        return Math.max(result, right - left + 1);
    }
}