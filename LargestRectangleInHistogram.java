class Solution {
    public int largestRectangleArea(int[] heights) {
        List<int[]> sortedH = new ArrayList<>();
        int max = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        for ( int i = 0; i < heights.length; i++){
            sortedH.add(new int[]{heights[i],i});
        }
        Collections.sort(sortedH, (a,b)->(Integer.compare(a[0],b[0])));

        for ( int i = 0; i < sortedH.size(); i++){
            int[] cur = sortedH.get(i);
            max = Math.max(max, eval(cur, tree, heights.length));
            tree.add(cur[1]);
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
/**
ways we can find some rectangles
size 1 rect
given x adj nums, rect size would be min x length 

first thought 
for each bar, expand left and right until you reach a bar less than you (exclusive)
then multiuply your height times dist from left to right
n2 solution

2nd thought get a sorted list of 
(height,index) nlgn
then work from lowest height up by putting the indexes into a sorted array
1,1 max rectangle would be length * 1 if lower and higher = 
2,3
as we look at each bar from lowest to highest, we see the indexes of any smaller bars
in the Treeset, giving us the left and right bounds of a rectangle at that height
then we put our index into the Treeset.
(1,3)
**/
