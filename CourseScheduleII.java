class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] order = new int[numCourses];
        int[] ended = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        int pos = numCourses-1;
        boolean[] cycleDetected = new boolean[1];;
        for (int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());
        for ( int[] edge : prerequisites){
            adjList.get(edge[1]).add(edge[0]);
        }
        for (int node = 0; node < numCourses; node++) pos = dfs(pos, adjList, visited, order, node, ended, cycleDetected);
        if (cycleDetected[0]) return new int[0];
        return order;
    }

    public int dfs(int pos, List<List<Integer>> adjList, boolean[] visited, int[] order, int node,int[] ended, boolean[] cycleDetected){
        if (visited[node] && ended[node] == 0) cycleDetected[0] =true;
        if ( visited[node]) return pos;
        visited[node] = true;
        for ( int neighb : adjList.get(node)){
            pos = dfs(pos,adjList,visited,order,neighb,ended,cycleDetected);
        }
        ended[node] = 1;
        order[pos] = node;
        return pos-1;
    }
}

/*
first we are going to translate prerequites into adjList
then for each prereq (a,b) we will create edge. (b->a)
the we can perform topological sort
and return answer
*/
