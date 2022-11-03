class SolutionR {
    public boolean canJump(int[] nums) {
        return canJumpHelper(nums, 0);
    }
    
    public boolean canJumpHelper( int[] nums, int index){
        System.out.println("cjh:" + index);
        if (index >= nums.length){
            return false;
        } if ( index == nums.length - 1) {
            return true;
        } if ( nums[index] == 0 ){
            return false;
        }
        boolean reachable = false;
        for ( int i = 1; i <= nums[index]; i++){
            reachable = reachable || canJumpHelper(nums, index + i);
            if ( reachable ) {return reachable;}
        }
        return reachable;
        
    }
}

class SolutionLinear {
    public boolean canJump(int[] nums) {
        if ( nums.length == 1) { return true; }
        int indexZero = -1;
        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i] == 0 && indexZero == -1){
                indexZero = i;
            }
            if ( indexZero != -1 && i + nums[i] > indexZero){
                indexZero = -1;
            }
        }
        return indexZero == -1;
    }
    
        
}
