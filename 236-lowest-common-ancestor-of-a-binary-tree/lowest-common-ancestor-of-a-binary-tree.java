/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   /* public static boolean getpath(TreeNode root,TreeNode n,ArrayList<TreeNode> path){
        if(root==null){
            return true;
        }
        path.add(root);

        if(root.val== n){
            return true;
        }

        boolean findleft=getpath(root.left,n,path);
        boolean findright=getpath(root.right,n,path);
        
        if(findleft || findright){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1=new ArrayList<>();
        ArrayList<TreeNode> path2=new ArrayList<>();

        getpath(root,p,path1);
        getpath(root,q,path2);

        int i=0;
        for(; i<path1.size() && i<path2.size() ;i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }

        TreeNode lca=path1.get(i-1);
        return lca;

    } OR*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val){
            return root;
        }

        TreeNode findleft=lowestCommonAncestor(root.left,p,q);
        TreeNode findright=lowestCommonAncestor(root.right,p,q);

        if(findleft==null){
            return findright;
        }

        if(findright==null){
            return findleft;
        }
        return root;
    }
}