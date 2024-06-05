class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        if (n==1){
            ans[0] = 0;
            ans[1] = 1;
        }else if (n>1){
            ans[0] = 0;
            ans[1] = 1;
            int cur = 2;
            loop1:while( cur <= n){
                for ( int i = 0; i < cur; i++){
                    if ( cur+i > n) break loop1;
                    ans[cur+i] = 1+ ans[i];
                }
                cur = cur*2;
            }
        }
        return ans;
        
    }
}

/*
func(ans[n])
set 0,1 to 0,1
while(cur < n){
    cur = 2
    for ( int i = 0, i< cur; i++)
        if cur + i >= n break
        ans[cur +i] = 1+ ans[i];
    cur = cur*2
}

/*
0:00000
1:00001
2:00010
3:00011
4:00100
5:00101
6:00110
7:00111
8:01000
9: 1+ [ans[9-8]]
*/
