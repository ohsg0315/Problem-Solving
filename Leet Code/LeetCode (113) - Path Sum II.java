import java.util.ArrayList;
import java.util.LinkedList;
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
    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();

        search(root, targetSum, 0, new LinkedList<>());

        return result;
    }

    private void search(TreeNode node, int targetSum, int total, LinkedList<Integer> list) {
        if (node == null) {
            return;
        }

        int value = node.val;
        total += value;
        list.addLast(value);


        if (node.left == null && node.right == null) {
            if (total == targetSum) {
                result.add(new ArrayList<>(list));
            }

            list.removeLast();
            return;
        }

        search(node.left, targetSum, total, list);
        search(node.right, targetSum, total, list);
        list.removeLast();
    }
}