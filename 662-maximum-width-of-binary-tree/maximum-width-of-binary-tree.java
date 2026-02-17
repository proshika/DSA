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
import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 0;
        Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new AbstractMap.SimpleEntry<>(root, 0));
        
        while (!q.isEmpty()) {
            int size = q.size();
            int minIdx = q.peek().getValue();
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Map.Entry<TreeNode, Integer> entry = q.poll();
                TreeNode node = entry.getKey();
                int idx = entry.getValue() - minIdx; // prevent overflow
                if (i == 0) first = idx;
                if (i == size - 1) last = idx;
                if (node.left != null)
                    q.offer(new AbstractMap.SimpleEntry<>(node.left, 2 * idx));
                if (node.right != null)
                    q.offer(new AbstractMap.SimpleEntry<>(node.right, 2 * idx + 1));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}