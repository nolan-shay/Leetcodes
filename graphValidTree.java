class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add( new ArrayList<>());
        }
        for ( int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        boolean answer = true;
        for ( int i = 0; i < n; i++){
            answer = answer && bfsHelper(i, adj, visited);
        }
        return answer;
    }

    public boolean bfsHelper(int pos, List<List<Integer>> adj, boolean[] visited){
        if(visited[pos]) {return true;}
        Queue<Integer> q = new LinkedList<>();
        q.add(pos);

        while(!q.isEmpty()){
            int node = q.poll();
            int count = 0;
            visited[node] = true;
            for ( int neighbor : adj.get(node)){
                if (visited[neighbor]) {count++;}
                else {q.add(neighbor);}
            }
            if ( count != 1 && node != 0) {return false;}
        }
        return true;

    }
}

// convert to adj list

/*

bfs(n, edges)
    generates adjList
    int[] visited
    boolean answer = true;
    for (int i = 0; i < n; i++){
        answer = answer && dfsHelper(i, edges, visited)
    }

bfsHelper( int i, edges, visited){
    if(visited[i]) return true;
    queue q
    q.add(i);

    while q is not empty
        int node = q.poll
        count = 0
        visited[node] = true;
        for int neighbor in adj(node)
            if visited[neighbor] = true
                count++
            else q.add(neighbor)
        if count != 1 and i != 0 return false
    return true
}


*/
