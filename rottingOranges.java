class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 2 && dist[i][j] == 0){
                    BFS(i,j,grid,dist);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                max = Math.max(dist[i][j], max);
                if (grid[i][j] == 1) {return -1;}
            }
        }
        return max;
    }

    public void BFS(int i, int j, int[][] grid, int[][] dist){
        Queue<int[]> q = new LinkedList<>();
        int[] c = new int[]{i,j};
        q.add(c);
        while (!q.isEmpty()){
            int[] org = q.poll();
            int x = org[0];
            int y = org[1];
            grid[x][y] = 2;
            addEdge(q,x,y+1, grid, dist, dist[x][y]);
            addEdge(q,x,y-1, grid, dist, dist[x][y]);
            addEdge(q,x+1,y, grid, dist, dist[x][y]);
            addEdge(q,x-1,y, grid, dist, dist[x][y]);

        }
    }

    public void addEdge(Queue<int[]> q, int i, int j, int[][] grid, int[][] dist, int thisDist){
        if ( 0 <= i && i < grid.length && 0 <= j && j < grid[0].length ){
            if (grid[i][j] == 1 && dist[i][j] == 0){
                q.add(new int[]{i,j});
                dist[i][j] = thisDist +1;
            } else if (grid[i][j] == 2 ){
                if (thisDist+1 < dist[i][j]){
                    q.add(new int[]{i,j});
                }
                dist[i][j] = Math.min(dist[i][j], thisDist+1);
            }
        }
    }
}

/*

int[][] dist = new int[grid.length][grid[0].length];

for ( int i = 0 )
    for (int j = 0)
        if dist i,j == 0 and gridi,j = 2
            BFS(i,j, grid, dist)

max = 0;
for ( int i = 0 )
    for (int j = 0)
        if dist i,j > max then max = dist i,j
        if grid i,j == 1 return -1
return max;

BFS(i,j, grid, dist)

    Q .add( int[i,j])

    While(Q.isEmpty){
        int [] orange = q.poll();
        addEdge( q, orange[0]+1, orange[0]-1, grid, dist, dist[orange[0]][orange[1]])
        addEdge( q, orange[0]-1, orange[0]-1, grid, dist, dist[orange[0]][orange[1]])
        addEdge( q, orange[0]+1, orange[0]+1, grid, dist, dist[orange[0]][orange[1]])
        addEdge( q, orange[0]-1, orange[0]+1, grid, dist, dist[orange[0]][orange[1]])

    }

add Edge( queue, int i, int j, grid, dist, parentDist){
    if ( 0 <= i && i < grid.length && 0 <= j && j < grid[0].length ){
        if (grid i,j == 1 && dist = 0){
            add it to the Queue
            dist[i,j] = 1+ parentDist;
        } else if {grid i,j == 2} {
            dist[i,j] = min( dist[i,j], 1 + parentDist);
        }
    }
}



distance [][] of the same size

iterate through the matrix and call BFS on rotten tomatoes with dist[0]

in our BFS when we check the visited array if its 0 its unvisited, and so we visit it and assign it its 
minute it was rotted, else if its visited ie dist > 0, then we replace it with our dist if its smaller.

at the end we iterate through and see if any are still rotten
*/
