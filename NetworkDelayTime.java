class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for (int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }
        for ( int[] time : times){
            adjList.get(time[0]).add(time);
        }
        dist[k] = 0;
        pq.add(new int[]{k,0});

        while( !pq.isEmpty()){
            int[] cur = pq.poll();
            for ( int[] nb : adjList.get(cur[0])){
                int weight = cur[1] + nb[2];
                if ( weight < dist[nb[1]]){
                    dist[nb[1]] = weight;
                    pq.add( new int[]{nb[1],weight});
                }
            }
        }
        int max = 0;
        for (int d : dist){
            max = Math.max(d,max);
        }
        System.out.println(Arrays.toString(dist));
        return max == Integer.MAX_VALUE? -1 : max;
        
    }
}

/**
//put times into adjList format
List<int[]> adjList = new lsit
for int i ... n+1
    adjList.add new list

for time in times


dist[n+1] = 0, inf,inf..

pq<[node, time of arrival]? ordered on time

put [k,0] onto the q

while( q is not empty)
    cur = q.poll
    for int[] neighb: adjList.get(cur[0])
        weight = cur.time + neighb.weight;
        if weight < dist[neighb[1]]
            dist[neigb[1]] = weight
            pq.add( new int[neighb[1],weight]);

get max of dist
if inf return -1 else return max;

 */
