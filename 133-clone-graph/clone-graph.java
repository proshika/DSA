/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
   
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        HashMap<Node,Node> hm=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        hm.put(node,new Node(node.val,new ArrayList<>()));
        q.add(node);
        while(!q.isEmpty()){
            Node curr=q.remove();
            for(Node neighbor:curr.neighbors){
                if(!hm.containsKey(neighbor)){
                  hm.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                  q.add(neighbor);
                }
                hm.get(curr).neighbors.add(hm.get(neighbor));
            }
        }
        return hm.get(node);
    }
}