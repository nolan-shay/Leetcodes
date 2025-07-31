class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> mh = new PriorityQueue<Point>((a, b) -> Double.compare(b.dist, a.dist));
        int[][] ans = new int[k][];
        int numElements = 0;
        for ( int[] point : points){
            double dist = Math.sqrt( (point[0]*point[0]) + (point[1]*point[1]) );
            if ( numElements < k){
                mh.add( new Point(point,dist));
                numElements++;
            } else if ( dist < mh.peek().dist){
                mh.poll();
                mh.add( new Point(point,dist));
            }
        }
        for ( int i = 0; i < k; i++){
            ans[i] = mh.poll().coord;
        }
        return ans;
    }
}

class Point {
    int [] coord;
    double dist;
    public Point (int[] coord, double dist){
        this.coord = coord;
        this.dist = dist;
    }
}

/**
dist(x,y)
    sqrt(x^2 + y^2)

maxHeap based on dist //kept to at most k elements
numElements = 0;

for int[] point : points
    dist = sqrt(x^2 + y^2)
    if (numElements < k )
        heap.add(point, dist)
        numElements++
    else( if dist < heap.peek() )
        heap.pop
        heap.add(point,dist)
for (int i = 0; i<k, i++)
    ans[i] = heap.pop().point();


n = number of points
n(lgn)

 */
