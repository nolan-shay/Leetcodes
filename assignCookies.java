class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        int numSatisfied = 0;
        
        while( child < g.length && cookie < s.length){
            //satisfied customer
            if ( s[cookie] >= g[child]) {
                numSatisfied ++;
                cookie++;
                child++;
            }else{ // not satisfied, try a bigger cookie
                cookie++;
            }
            
        }
        
        return numSatisfied;
    }
}
