class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] prereq:prerequisites){
            adj.get(prereq[0]).add(prereq[1]);
        }
        int[] vis=new int[numCourses];
        int[] stack=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(dfs(adj,stack,vis,i)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> adj,int[] stack,int[] vis,int curr){
        if(stack[curr]==1){
            return true;
        }
        if(vis[curr]==1){
            return false;
        }
        stack[curr]=1;
        vis[curr]=1;
        for(int n:adj.get(curr)){
            if(dfs(adj,stack,vis,n)){
                return true;
            }
        }
        stack[curr]=0;
        return false;
    }
}