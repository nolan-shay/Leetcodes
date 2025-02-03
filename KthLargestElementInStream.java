class KthLargest {
    PriorityQueue<Integer> minHeap;
    int curCap;
    int k;

    public KthLargest(int k, int[] nums) {
        curCap = 0;
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums){
            add(num);
        }
        
    }
    
    public int add(int val) {
        if (curCap < k){
            minHeap.add(val);
            curCap++;
        } else {
            if (val > minHeap.peek()){
                minHeap.poll();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}
/**

minHeap<intger> 
int curCap = 0
for (num in nums)
    if( curCap < k)
        add that element to minHeap
        CurCap++
    else{
        if num > minHeap.peek();
            minHeap.poll()
            minHeap.add(nums);
    }

add(num)
    if( curCap < k)
        add that element to minHeap
        curCap++
    else{
        if num > minHeap.peek();
            minHeap.poll()
            minHeap.add(nums);
    }

 */


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
