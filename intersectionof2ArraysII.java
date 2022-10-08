class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                if ( nums1[i] == nums2[j]){
                    intersection.add(nums1[i]);
                    nums2[j] = -1;
                    //exit for loop
                    break;
                }
            }
        }
        int[] ans = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++){
            ans[i] = intersection.get(i);
        }
        return ans;
    }
}
