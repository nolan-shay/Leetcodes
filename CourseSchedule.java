class Solution {
    List<List<Integer>> adjList = new ArrayList<>();
    boolean loopDetected = false;
    int[] visited;
    int[] closed;
    int dfsNumber = 1;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        closed = new int[numCourses];

        for ( int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for( int[] edge : prerequisites){
            adjList.get(edge[0]).add(edge[1]);
        }

        for ( int i = 0; i < numCourses; i++){
            dfs(i, i+1);
            if (loopDetected) return false;
        }
        return true;
        
    }

    public void dfs( int node, int dfsNumber2){
        if ( visited[node] ==0 ){
            dfsNumber++;
            visited[node] = dfsNumber;
            for ( int i : adjList.get(node)){
                dfs(i,dfsNumber);
            }
            dfsNumber++;
            closed[node] = dfsNumber;
        } else if ( closed[node] == 0){
            loopDetected = true;
        }
    }
}

/*
if we visit the same node in the same recursive tree of dfs, then we have a cycle
could turn this into an adj list 

for ( int i = 0; i < numCourses){
    dfs(i, i+1);
    if loopdetected return false;
}
return true;

visited[numCourses]
// visited[i] = 0 means unvisted, visited[i] >0, last dfs that visited that node.
public boolean dfs( dfsNumber, int node ) 
    if [visited[i] == 0]
        visited[i] == dfsNumber
        for ( int i : adJList[node]){
            dfs(i, dfsNumber);
        }
    else if visited[i] == dfsNumber loopDetected = true;

*/
