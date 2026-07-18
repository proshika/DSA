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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        int left=0,right=list.size()-1;
        while(left<right){
            if(list.get(left)+list.get(right)==k){
                return true;
            }
            else if(list.get(left)+list.get(right)<k){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
    private void inorder(TreeNode root,List<Integer> list){
        if(root==null) return;

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}