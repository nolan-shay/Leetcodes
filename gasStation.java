class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        //first check if there is enough fuel
        for ( int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
        }
        if (tank < 0){
            return -1;
        }
        
        tank = 0;
        int startIndex = 0;
        for ( int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0){
                tank = 0;
                startIndex = i+1;
            }
        }
        return startIndex;
    }
}
