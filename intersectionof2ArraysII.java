class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // ensure mapping is done of smaller array
        int[] numsSm, numsL;
        if (nums1.length > nums2.length){
            numsSm = nums2;
            numsL = nums1;
        } else {
            numsSm = nums1;
            numsL = nums2;
        }
        List<Integer> intersection = new ArrayList<>();
        HashMap<Integer,Integer> freq = new HashMap<>();
        for ( int i = 0; i < numsSm.length; i++){
            if (freq.containsKey(numsSm[i])){
                freq.put(numsSm[i],freq.get(numsSm[i]) + 1);
            } else {
                freq.put(numsSm[i], 1);
            }
        }
        for ( int i = 0; i< numsL.length; i++){
            if ( freq.containsKey(numsL[i]) && freq.get(numsL[i]) > 0){
                freq.put(numsL[i],freq.get(numsL[i]) - 1);
                intersection.add(numsL[i]);
            }
        }
        int[] answer = new int[intersection.size()];
        for ( int i = 0; i < intersection.size(); i++){
            answer[i] = intersection.get(i);
        }
                
        return answer;
    }
}
