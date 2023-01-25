class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1 ){
            if (nums[0] == target){
                return 0;
            } else { return -1;}
        } else if (nums.length == 2){
            if (nums[0] == target){
                return 0;
            } else if (nums[1] == target){
                return 1;
            }else{ return -1;}
        }
        // now guranteed length of 3 or more
        int pivot = 0;
        if (nums[0] > nums[nums.length-1]){
            pivot = findPivot(nums, 0, nums.length-1);
        }
        //System.out.println(pivot);
        if (pivot == 0){
            return binarySearch(nums, target, 0, nums.length-1);
        }else if (target >= nums[pivot] && target <= nums[nums.length-1]){
            return binarySearch(nums, target, pivot, nums.length-1);
        } else if ( target <= nums[pivot-1] && target >= nums[0]){
            return binarySearch(nums, target, 0, pivot-1);
        } else {
            return -1;
        }
        
    }

    //base cases start == end or len 2
    public int binarySearch(int[] nums, int target, int start, int end){
        if (start == end){
            if (nums[start] == target){
                return start;
            } else { return -1;}
        }else if (end - start == 1){
            if (nums[start] == target){
                return start;
            } else if (nums[end] == target){
                return end;
            }
            else{ return -1;}
        }
        System.out.println("start:" + start +", end " + end);
        int middle = (end + start )/2;
        if ( nums[middle] == target){
            return middle;
        }else if ( target < nums[middle]){
            return binarySearch(nums, target, start, middle-1);
        } else {
            return binarySearch(nums, target, middle+1, end);
        }

    }

    public int findPivot( int[] nums, int start, int end){
        if (end-start == 1){
            return end;
        }else {
            int middle = (start + end)/2;
            if ( nums[start] > nums[middle]){
                return findPivot(nums,start, middle);
            } else {
                return findPivot(nums, middle, end);
            }
        }
    }

}

/* BROAD
    find pivot
    check if target is within the bnounds of the after pivot section of the array
        if it is binary search on that array
    check if targer is within bounds of before the pivot
        if it is binary search on that array
    else return -1;
*/
