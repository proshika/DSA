class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> currPath=new LinkedList<>();
        currPath.add(0);

        dfs(graph,0,graph.length-1,currPath,result);
        return result;
    }
    private void dfs(int[][] graph,int currNode,int target,List<Integer> currPath,List<List<Integer>> result){
        if(currNode==target){
            result.add(new ArrayList<>(currPath));
            return;
        }
        for(int neighbor:graph[currNode]){
            currPath.add(neighbor);
            dfs(graph,neighbor,target,currPath,result);
            currPath.remove(currPath.size()-1);
        }
    }
}