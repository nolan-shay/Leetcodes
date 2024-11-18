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
class Solution2 {
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        HashSet<Integer> hs = new HashSet<>();
        for ( int i =0; i < n; i++){
            parent[i] = i;    
        }
        for (int [] e : edges){
            union(e[0],e[1]);
        }
        for ( int i =0; i < n; i++){
            hs.add(find(i));   
        }
        return hs.size();

    }

    public int find(int i){
        if (parent[i] == i){
            return i;
        } else {
            int rep = find(parent[i]);
            parent[i] = rep;
            return rep;
        }
    }

    public void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        parent[parentA] = parentB;
    }

}

/*

int[] parents

for ( int i = 0; i< n;i++){
    parent[i] = i;
}

for ( edge e : edges){
    union(e[0], e[1])
}

for ( int i = 0; i< n;i++){
    Set.add(find(i))
}
return Set.size();

find ()
    if Parent[i] = i
        return i;
    else 
        return find(parent[i])

union( a, b)

    parentA = find(a);
    parentB = find(B);
    parent[parentA] = parentB;

*/
