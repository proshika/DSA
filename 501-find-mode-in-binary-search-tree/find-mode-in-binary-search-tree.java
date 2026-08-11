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
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        List<Integer> modes = new ArrayList<>();
        int maxCount = 0;
        int currentCount = 0;
        Integer prev = null;
        
        for (int num : list) {
            if (prev != null && num == prev) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            
            if (currentCount > maxCount) {
                maxCount = currentCount;
                modes.clear();
                modes.add(num);
            } else if (currentCount == maxCount) {
                modes.add(num);
            }
            
            prev = num;
        }
        int[] ans = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            ans[i] = modes.get(i);
        }
        
        return ans;
    }
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        inorder(root.left, list);
        list.add(root.val); 
        inorder(root.right, list);
    }
}