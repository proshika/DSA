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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newroot=new TreeNode(0);
        TreeNode curr=newroot;
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        for(int val:list){
            curr.right=new TreeNode(val);
            curr=curr.right;
        }
        return newroot.right;
    }
    private void inorder(TreeNode root,List<Integer> list){
        if(root==null) return;

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}