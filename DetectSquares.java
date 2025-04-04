class DetectSquares {

    HashMap<Integer,HashSet<Integer>> xMap;
    HashMap<Integer,HashSet<Integer>> yMap;
    HashMap<String,Integer> occ;

    public DetectSquares() {
        xMap = new HashMap<>();
        yMap = new HashMap<>();
        occ = new HashMap<>();
    }
    
    public void add(int[] point) {
        if ( xMap.containsKey(point[0])){
            xMap.get(point[0]).add(point[1]);
        }else {
            xMap.put(point[0], new HashSet<>());
            xMap.get(point[0]).add(point[1]);
        }
        if ( yMap.containsKey(point[1])){
            yMap.get(point[1]).add(point[0]);
        } else {
            yMap.put(point[1], new HashSet<>());
            yMap.get(point[1]).add(point[0]);
        }
        String pointStr = point[0]+","+point[1];
        if ( occ.containsKey(pointStr)){
            occ.put(pointStr,occ.get(pointStr)+1);
        } else {
            occ.put(pointStr, 1);
        }
    }
    
    public int count(int[] point) {
        int squares = 0;
        int x1 = point[0];
        int y1 = point[1];
        if (xMap.get(x1) == null) return 0;
        for ( int y2 : xMap.get(x1)){
            int dist = Math.abs(y1-y2);
            int x2 = x1-dist;
            if (dist == 0) continue;
            if ( yMap.containsKey(y1) && yMap.get(y1).contains(x2)){
                // point one x1,y1
                //poinnt two = x1,y2
                // point three = x2, y1
                // point 4 = x2,y2
                if ( xMap.containsKey(x2) && xMap.get(x2).contains(y2)){
                    squares += occ.get(x1+","+y2) * occ.get(x2+","+y1) * occ.get(x2+","+y2);
                }
            }
            x2 = x1+dist;
            if ( yMap.containsKey(y1) && yMap.get(y1).contains(x2)){
                if ( xMap.containsKey(x2) && xMap.get(x2).contains(y2)){
                    squares += occ.get(x1+","+y2) * occ.get(x2+","+y1) * occ.get(x2+","+y2);
                }
            }
        }
        return squares;


        //squares = 0
        // iterate throughh all points in xhashmap, val
            //is there a matching negative value in yhashmap
            // |point[2] - val|
                // is there a final corner
                // square += ( instance of pt1 +... pt3)
            //is there a mathching positive value in yhashmap
                //is there a final corner
                // square += ( instance of pt1 +... pt3)
    }
}

/**
count(1,2)

to make a square we need a point on x = 1 with dis = y - 2
does the point (1 - 2, 2) exist or (1+2,2) so (-1,2) or (3,2)




 */



/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
