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
    HashSet<Integer> visited;
    HashMap<Integer,Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        visited = new HashSet<>();
        map = new HashMap<>();
        return dfs(node);
    }

    public Node dfs(Node node){
        if (visited.contains(node.val)) return map.get(node.val);
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        visited.add(node.val);
        for (Node neighb: node.neighbors){
            newNode.neighbors.add(dfs(neighb));
        }
        return newNode;
    }
}

/**
dfs make deep copies along the way
caveat, dfs doesn't "Explore" each edge

Node dfs( Node node){
    if unvisited
        NewNode = copy of nodes value, empty list
        map.add(value,NewNode)
        mark as visited
        for Node neighb : neighbors
            NewNode.neighbors.add(dfs(neighb))
        return NewnNode;
    if visited return the already created copy of newNode

}
 */
