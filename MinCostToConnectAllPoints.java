class Solution {

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        boolean[] visited = new boolean[points.length];
        int weight = 0;
        visited[0]= true;
        addEdges(0, points, visited, pq);

        while (!pq.isEmpty()){
            Edge e = pq.poll();
            if (visited[e.to]) continue;
            visited[e.to] = true;
            weight = weight + e.weight;
            addEdges(e.to, points, visited, pq);
        }
        return weight;
    }

    public void addEdges( int node, int[][] points, boolean[] visited, PriorityQueue<Edge> pq){
        for ( int i = 0; i <points.length; i++){
            if (!visited[i]){
                Edge e = new Edge(node, i, Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]) );
                pq.add(e);

            }
        }
    }
}
class Edge{
    int from;
    int to;
    int weight;
    public Edge( int from, int to , int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
/**
we don't have a list of edges, rather, there is an "edge" between all nodes
meaning there are ~n^2 edges or at least O(n^2) operations

pq = minHeap based on cost
visited [same lenght]
weight = 0;
visited[0] = true
addEdges(0)

while( pq isn't empty){
    edge = pq.poll()
    if (edge.to == visited) break or continue;
    visited[edge.to] = true;
    weight = weight + edge.weight;
    addEdges(edge.to);
}
return weight;

addEdges( int node){
    for ( int i =0; i < point.length; i ++){
        if (!visited[i]){
            Edge = newEdge(node, i, |points[node][0] - points[i][0]| +|points[node][1] - points[i][1]|);
            pq.addEdge(Edge)
        }
    }
}

class Edge{
    int from
    int to 
    int weight
}


 */
