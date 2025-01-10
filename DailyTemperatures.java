class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int[] result = new int[temperatures.length];
        int[] start = new int[]{temperatures[0],0};
        st.push(start);
        for (int i = 1; i < temperatures.length; i++){
            int cur = temperatures[i];
            while( !st.isEmpty() && cur > st.peek()[0]){
                int[] prev = st.pop();
                result[prev[1]] = i-prev[1];
            }
            st.push(new int[]{cur,i});
        }
        return result;
    }
}

/**

easy solution n^2 scan backwards

stack = {}
result = array of 0s
push first element
for each starting at 1
    while cur > peek 
        pop and update result for peek
        result[pop.index]] = cur.index-pop.index;
    push cur;

[100,38,30,12,1,40,35,40,28, 101]

stack = [ (100,0),(40,5),(40,7) (28,8) 
cur = (101,9)
result = [9,4,3,2,1,4,1,2,1,0]

**/
