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
       int max=0;
    public int longestZigZag(TreeNode root) {
        helper(root.left,false,1);
        helper(root.right,true,1);
        return max;
    }

    private void helper(TreeNode node, boolean isLeft, int length) {
        if (node == null)
            return;
         max = Math.max(max, length);
        if (isLeft) {
            helper(node.left, false, length + 1);
            helper(node.right, true, 1);
        } else {
            helper(node.right, true, length + 1);
            helper(node.left, false, 1);
        }
    }
}