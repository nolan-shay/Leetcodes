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
        if (node == null) return null;
        HashMap<Integer,Node> hm = new HashMap<>();
        return oldDfs(node, hm);
    }

    private Node oldDfs(Node oldNode, HashMap<Integer,Node> hm){
        if (hm.containsKey(oldNode.val) ){
            return hm.get(oldNode.val);
        }
        Node newNode = new Node(oldNode.val);
        hm.put(newNode.val,newNode);
        for ( Node neighbor : oldNode.neighbors){
            newNode.neighbors.add(oldDfs(neighbor, hm));
        }
        return newNode;
    }
}
