class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int sum = 0;
        for ( String row : bank){
            int devices = getDevices(row);
            if (devices != 0){
                sum += devices* prev;
                prev = devices;
            }
        }
        return sum;
    }

    public int getDevices( String row){
        int sum = 0;
        for ( char c : row.toCharArray()){
            if (c == '1') sum++;
        }
        return sum;
    }
}
