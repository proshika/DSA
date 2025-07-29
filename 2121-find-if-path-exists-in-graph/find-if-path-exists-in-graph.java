class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean vis[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        if(source==destination){
            return true;
        }
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);

        }
        q.add(source);
        vis[source]=true;
        while(!q.isEmpty()){
            int curr=q.remove();
            if(curr==destination){
                return true;
            }
            for(int neighbor:adj[curr]){
                if(!vis[neighbor]){
                    vis[neighbor]=true;
                    q.add(neighbor);
                }
            } 
        }
        return false;
    }
}