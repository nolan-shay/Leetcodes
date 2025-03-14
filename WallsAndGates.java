class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for ( int i = 0; i < grid.length; i ++){
            for ( int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0){
                    q.add(new int[]{i+1,j,1});
                    q.add(new int[]{i-1,j,1});
                    q.add(new int[]{i,j+1,1});
                    q.add(new int[]{i,j-1,1});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 2147483647){
                grid[x][y] = dist;
                q.add(new int[]{x+1,y,dist+1});
                q.add(new int[]{x-1,y,dist+1});
                q.add(new int[]{x,y+1,dist+1});
                q.add(new int[]{x,y-1,dist+1});

            }
        }
    }
}

/** multi source bfs

loop through the array, adding all 0s x,y,0 to our q
q (x,y,dist)

while( q is not empty)
    (x,y,dist) = q.poll()
    if( x and y are within bounds and grid[x][y] == max value)
        grid[x][y] = dist+1;
        q.add(x-1,y,dist+1)
        q.add(x+1,y,dist+1)
        q.add(x,y-1,dist+1)
        q.add(x,y+1,dist+1)

  [ 3,-1, 0, 1],
  [ 2, 2, 1,-1],
  [ 1,-1, 2,-1],
  [ 0,-1, 3, 4]



*/
