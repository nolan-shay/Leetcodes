class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for ( int i = 0; i< n; i++){ adjList.add(new ArrayList<>());}

        for ( int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if ( !visited[i]){
                bfs(adjList, visited, i);
                count++;
            }
        }
        return count;
        
    }

    // given an edge it will find all connected components and mark them visited
    public void bfs(List<List<Integer>> adjList, boolean[] visited, int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int curNode = q.poll();
            if (!visited[curNode]){
                visited[curNode] = true;
                for ( int neighb : adjList.get(curNode)){
                    q.add(neighb);
                }
            }
        }
    }
}

/*
List of List length n adjList
populate with new arrayLists;
for edge in edges
    adjList.get(edge[0]).add(edge[1])
    adjList.get(edge[1]).add(edge[0])


count = 0;
visited = new int[n];
i = 0 to n
    if node is unvisited
        bfs(node)
        count++;


bfs( adjList, node, visited)
    queue q
    add node to q
    while q is not empty
        if (node is not visited)
            visited of node = true
            for int i : adjList.get(node)
                q.add(i);

*/
