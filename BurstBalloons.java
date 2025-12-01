class SolutionDP { //12/1/25
    int[] nums;
    int[][] dpArr;
    public int maxCoins(int[] nums) {
        this.nums = new int[nums.length +2];
        this.nums[0] = 1;
        this.nums[this.nums.length-1] = 1;
        for (int i = 0; i < nums.length; i++) this.nums[i+1] = nums[i];
        System.out.println(Arrays.toString(this.nums));

        dpArr = new int[this.nums.length][this.nums.length];

        int n = this.nums.length;

        for (int l = n-2; l >= 1; l--){
            for ( int r = 1; r < n-1; r++){
                if (l == r){
                    dpArr[l][r] = this.nums[l-1] * this.nums[l] * this.nums[l+1];
                } else if ( l > r){
                    dpArr[l][r] = 0;
                } else {
                    int max = 0;
                    for ( int i = l; i <= r; i++){
                        int calc = dpArr[l][i-1] +
                            (this.nums[l-1] * this.nums[i] * this.nums[r+1]) +
                            dpArr[i+1][r];
                        max = Math.max(calc, max);
                    }
                    dpArr[l][r] = max;
                }
            }
        }
        return dpArr[1][this.nums.length-2];

        // for ( int len = 0; len <= nums.length; len++){
        //     for ( int l = 1; l <= nums.length-len; l++ ){
        //         int r = l + len;
        //         if (l == r){
        //             dpArr[l][r] = this.nums[l-1] * this.nums[l] * this.nums[l+1];
        //         } else {
        //             int max = 0;
        //             for ( int i = l; i <= r; i++){
        //                 int calc = dpArr[l][i-1] +
        //                     (this.nums[l-1] * this.nums[i] * this.nums[r+1]) +
        //                     dpArr[i+1][r];
        //                 max = Math.max(calc, max);
        //             }
        //             dpArr[l][r] = max;
        //         }
        //     }
        // }
    }
}


class SolutionRecursion { //11/30/25
    int[] nums;
    HashMap<String, Integer> hm;
    public int maxCoins(int[] nums) {
        this.nums = new int[nums.length +2];
        this.nums[0] = 1;
        this.nums[this.nums.length-1] = 1;
        for (int i = 0; i < nums.length; i++) this.nums[i+1] = nums[i];
        System.out.println(Arrays.toString(this.nums));
        hm = new HashMap<>();
        return maxH(1, nums.length);
    }

    public int maxH(int l, int r){
        String key = l+","+r;
        if (hm.containsKey(key)) return hm.get(key);
        if ( l > r) return 0;
        int max = 0;
        for ( int i = l; i <= r; i++){
            int calc = maxH(l, i-1) +
                (nums[l-1] * nums[i] * nums[r+1]) +
                maxH(i+1, r);
            max = Math.max(calc, max);
        }
        hm.put(key, max);
        return max;
    }
}
