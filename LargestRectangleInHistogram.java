class Solution {
    public int largestRectangleArea(int[] heights) {
        List<int[]> sortedH = new ArrayList<>();
        int max = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        for ( int i = 0; i < heights.length; i++){
            sortedH.add(new int[]{heights[i],i});
        }
        Collections.sort(sortedH, (a,b)->(Integer.compare(a[0],b[0])));
        List<int[]> curBars;

        for ( int i = 0; i < sortedH.size(); i++){
            int[] cur = sortedH.get(i);
            curBars = new ArrayList<>(Arrays.asList(cur));
            i++;
            while(i < sortedH.size() && curBars.get(0)[0] == sortedH.get(i)[0]){
                curBars.add(sortedH.get(i));
                i++;
            }
            i--;
            for(int[] bar : curBars){
                // System.out.println("bar" + bar[0] + ", " +bar[1]);
                max = Math.max(max, eval(bar, tree, heights.length));
            }
            for(int[] bar : curBars){
                tree.add(bar[1]);
            }
            
        }
        return max;
    }

    public int eval(int[] bar, TreeSet<Integer> tree, int length){
        Integer lower = tree.lower(bar[1]);
        Integer higher = tree.higher(bar[1]);
        if ( lower == null && higher == null){
            return bar[0] * length;
        } else if ( lower == null){
            return bar[0] * higher;
        } else if (higher ==null){
            return bar[0] * (length -1 - lower);
        } else return bar[0] * (higher - 1 - lower);
    }
}
