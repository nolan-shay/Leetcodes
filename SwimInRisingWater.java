class Solution {
    private int n;
    private PriorityQueue<Pos> pq;
    private int[][] dist;
    private int[][] grid;


    public int swimInWater(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        dist = new int[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        Pos start = new Pos(0,0,grid[0][0]);
        pq = new PriorityQueue<>((a,b)-> a.time - b.time);
        pq.add(start);

        while(!pq.isEmpty()){
            Pos cur = pq.poll();
            Pos right = new Pos(cur.x, cur.y+1, 0);
            add(cur,right);
            Pos left = new Pos(cur.x, cur.y-1, 0);
            add(cur,left);
            Pos up = new Pos(cur.x-1, cur.y, 0);
            add(cur,up);
            Pos down = new Pos(cur.x+1, cur.y, 0);
            add(cur,down);
        }
        System.out.println(Arrays.deepToString(dist).replace("], ", "]\n"));
        return dist[n-1][n-1];
    }

    public void add(Pos cur, Pos next){
        if (next.x >= 0 && next.x < n && next.y >= 0 && next.y < n){
            next.time = Math.max(cur.time, grid[next.x][next.y]);
            if (next.time < dist[next.x][next.y]){
                dist[next.x][next.y] = next.time;
                pq.add(next);
            }
        }
    }
}

class Pos {
    public int x;
    public int y;
    public int time;

    public Pos(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }

}

/*
[x,y,t] sorted by time low to hi
queue<pos> = {[0,0,0]}
dist[][] init to inf

while(q is not empty){
    cur = q.pop()
    right = [cur.x,cuy.y+1,0]
    add(cur, right)
    left = [cur.x, cur.y-1,0]
    add(cur, left)...

}
return dist[n-1][n-1];

void add( pos cur, pos next){
    checck bounds of next.
    next.time = Math.max(cur.time, grid[next.x][mext.y]);
    if next.time < dist[next.x][next.y]
        dist[][] = next.time
        q.add(next);
}
