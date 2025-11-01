class Solution { // 11/1/25
    int rows;
    int cols;
    boolean[][] visitedP;
    boolean[][] visitedA;
    Queue<List<Integer>> pQ;
    Queue<List<Integer>> aQ;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        rows = heights.length;
        cols = heights[0].length;
        visitedP = new boolean[rows][cols];
        visitedA = new boolean[rows][cols];
        pQ = new LinkedList<>();
        aQ = new LinkedList<>();

        for ( int i = 0; i < rows; i++){
            visitedP[i][0] = true;
            pQ.add(Arrays.asList(i,0));
        }
        for ( int i = 0; i < cols; i++){
            visitedP[0][i] = true;
            pQ.add(Arrays.asList(0,i));
        }
        for ( int i = 0; i < rows; i++){
            visitedA[i][cols-1] = true;
            aQ.add(Arrays.asList(i,cols-1));
        }
        for ( int i = 0; i < cols; i++){
            visitedA[rows-1][i] = true;
            aQ.add(Arrays.asList(rows-1,i));
        }

        while ( !pQ.isEmpty()){
            List<Integer> cur = pQ.poll();
            eval( pQ, visitedP, heights, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0),cur.get(1)+1));
            eval( pQ, visitedP, heights, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0),cur.get(1)-1));
            eval( pQ, visitedP, heights, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0)+1,cur.get(1)));
            eval( pQ, visitedP, heights, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0)-1,cur.get(1)));
        }

        while ( !aQ.isEmpty()){
            List<Integer> cur = aQ.poll();
            eval( aQ, visitedA, heights, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0),cur.get(1)+1));
            eval( aQ, visitedA, heights, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0),cur.get(1)-1));
            eval( aQ, visitedA, heights, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0)+1,cur.get(1)));
            eval( aQ, visitedA, heights, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0)-1,cur.get(1)));
        }

        for ( int i = 0; i < rows; i++){
            for (int j = 0; j<cols; j++){
                if (visitedP[i][j] && visitedA[i][j]) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;

    }

    public void eval(Queue<List<Integer>> q, boolean[][] visited, int[][] heights, int val, List<Integer> point){
        if (point.get(0) < 0 || point.get(0) >= rows || point.get(1) < 0 || point.get(1) >= cols) return;
        if (heights[point.get(0)][ point.get(1)] < val) return;
        if (visited[point.get(0)][ point.get(1)]) return;
        visited[point.get(0)][ point.get(1)] = true;
        q.add(point);
    }
}

/**
 do an atlantic bfs and a pacific bfs, two different visited arrays, the overlap is where you can go to both

visitedP = [][]
visitedA = [][]

for int i = 0 < rows
    visitedP[row,0] = true
    pQ.add([row,0])
for int i = 0 < rows
    visitedA[row,col size] = true
    aQ.add([row, col size])


while(pQ.isnotEmpty)
    set of neighbors
    for neighbs
        if inbounds and unvisited and >= this node
            mark as visited add to queue
    
for int row = 0 in rows
    int col = 0 in cols
        if visited in visitedP and visitedA, add to result Set.


 */

class Solution2 { // DFS solution 11/1/25
    int rows;
    int cols;
    boolean[][] visitedP;
    boolean[][] visitedA;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        rows = heights.length;
        cols = heights[0].length;
        visitedP = new boolean[rows][cols];
        visitedA = new boolean[rows][cols];

        for ( int i = 0; i < rows; i++){
            dfs(visitedP, Arrays.asList(i,0), heights);
        }
        for ( int i = 0; i < cols; i++){
            dfs(visitedP, Arrays.asList(0,i), heights);
        }
        for ( int i = 0; i < rows; i++){
            dfs(visitedA,Arrays.asList(i,cols-1), heights);
        }
        for ( int i = 0; i < cols; i++){
            dfs(visitedA,Arrays.asList(rows-1,i), heights);
        }

        for ( int i = 0; i < rows; i++){
            for (int j = 0; j<cols; j++){
                if (visitedP[i][j] && visitedA[i][j]) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;

    }

    public void dfs(boolean[][] visited, List<Integer> cur, int[][] heights){
            visited[cur.get(0)][ cur.get(1)] = true;
            dfsH(visited, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0),cur.get(1)+1), heights);
            dfsH(visited, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0),cur.get(1)-1), heights);
            dfsH(visited, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0)+1,cur.get(1)), heights);
            dfsH(visited, heights[cur.get(0)][cur.get(1)], Arrays.asList(cur.get(0)-1,cur.get(1)), heights);
    }

    public void dfsH(boolean[][] visited, int val, List<Integer> point, int[][] heights){
        if (point.get(0) < 0 || point.get(0) >= rows || point.get(1) < 0 || point.get(1) >= cols) return;
        if (heights[point.get(0)][ point.get(1)] < val) return;
        if (visited[point.get(0)][ point.get(1)]) return;
        visited[point.get(0)][ point.get(1)] = true;
        dfs(visited, point, heights);
    }
}

