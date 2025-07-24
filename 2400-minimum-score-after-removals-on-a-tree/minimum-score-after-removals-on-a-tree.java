class Solution {
        private List<Integer>[] tree;
        private int[] subtreexor;
        private int[] tin,tout;
        private int timer=0;
        private int totalxor;
    public int minimumScore(int[] nums, int[][] edges) {
       int n=nums.length;
       tree=new ArrayList[n];
       for(int i=0;i<n;i++) tree[i]=new ArrayList<>();
       for(int[] edge:edges){
        tree[edge[0]].add(edge[1]);
        tree[edge[1]].add(edge[0]);
       }
       subtreexor=new int[n];
       tin=new int[n];
       tout=new int[n];

       dfs(0,-1,nums);

       totalxor=subtreexor[0];
       int minscore=Integer.MAX_VALUE;

       for(int i=1;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(isAncestor(i,j)){
               int x=subtreexor[j];
               int y=subtreexor[i]^subtreexor[j];
               int z=totalxor^subtreexor[i];
               minscore=Math.min(minscore,getscore(x,y,z));
            }else if(isAncestor(j,i)){
               int x=subtreexor[i];
               int y=subtreexor[j]^subtreexor[i];
               int z=totalxor^subtreexor[j];
               minscore=Math.min(minscore,getscore(x,y,z));
            }else{
               int x=subtreexor[i];
               int y=subtreexor[j];
               int z=totalxor^x^y;
               minscore=Math.min(minscore,getscore(x,y,z));
            }
        }  
       }
       return minscore;
    }
    private void dfs(int node,int parent,int[] nums){
        tin[node]=timer++;
        subtreexor[node]=nums[node];
        for(int neighbor:tree[node]){
            if(neighbor!=parent){
                dfs(neighbor,node,nums);
                subtreexor[node]^=subtreexor[neighbor];
            }
        }
        tout[node]=timer++;
    }

    private boolean isAncestor(int u,int v){
        return tin[u]<=tin[v] && tout[v]<=tout[u];
    }
    private int getscore(int a,int b,int c){
        int max=Math.max(a,Math.max(b,c));
        int min=Math.min(a,Math.min(b,c));
        return max-min;
    }
}