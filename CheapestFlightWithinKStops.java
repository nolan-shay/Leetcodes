class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        int[] tmpDist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(tmpDist,Integer.MAX_VALUE);
        dist[src] = 0;
        tmpDist[src] = 0;

        for (int i = 0; i < k+1; i++){
            for ( int[] flight : flights){
                if ( dist[flight[0]] != Integer.MAX_VALUE){
                    tmpDist[flight[1]] = Math.min(tmpDist[flight[1]], dist[flight[0]] + flight[2]);
                }
            }
            dist = tmpDist.clone();
        }

        return tmpDist[dst] == Integer.MAX_VALUE? -1 : tmpDist[dst];

    }
}

/**

bellman ford

dist [0 ,inf,inf,inf] // cost to get to eacch node from src in 0 hops
tmp dist[inf,inf,inf] // cost to get to eacch node from src in 1 hop
//set dist = tmp dist. dist

for i in k+1
    for flight in flight
        if dist[from] != inf
            tmpDist[to] = min( tmpDist[to], dist[from] + price);
    dist = tmpDist;

 */
