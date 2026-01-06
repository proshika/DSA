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
    public int maxLevelSum(TreeNode root) {
        int maxsum = Integer.MIN_VALUE;
        int currlevel = 1;
        int maxlevel = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
           int size =q.size();
           int levelsum=0;
           for(int i=0;i<size;i++){
            TreeNode currNode=q.remove();
            levelsum+=currNode.val;
            if (currNode.left != null) {
                q.add(currNode.left);
            }
            if (currNode.right != null) {
                q.add(currNode.right);
            }
           }
            if(levelsum>maxsum){
                maxsum=levelsum;
                maxlevel=currlevel;
            }
            currlevel++;
        }
        return maxlevel;
    }
}