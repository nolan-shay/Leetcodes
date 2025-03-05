class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones){
            pq.add(stone);
        }
        while(!pq.isEmpty()){
            int stoneA = pq.poll();
            if (pq.isEmpty()) return stoneA;
            int stoneB = pq.poll();
            int result = Math.abs(stoneA - stoneB);
            if (result != 0) pq.add(result);
        }
        return 0;
    }
}
