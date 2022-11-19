class Solution {
    public boolean canReach(int[] arr, int start) {
        int current, forward, backward;
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            current = q.remove();
            if (arr[current] == 0) { return true;}
            visited[current] = true;
            forward = current + arr[current];
            backward = current - arr[current];
            if ( forward >= 0 && forward < arr.length && !visited[forward]){
                    q.add(forward);
            }
            if ( backward >= 0 && backward < arr.length && !visited[backward]){
                    q.add(backward);
            }
        }
        return false;
    }
}
