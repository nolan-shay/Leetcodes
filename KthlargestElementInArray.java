class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sz = 0;
        for ( int num:nums){
            if (sz < k){
                pq.add(num);
                sz++;
            }else if ( num > pq.peek()){
                pq.poll();
                pq.add(num);
            }
        }
        return pq.peek();
    }
}

/**

pq
int sz

for num in nums
    if sz < k
        pq.add(num)
    else if num > pq.peek
        pq.poll
        pq.add(num)
return pq.peek();

create a pq, minHeap

add elements unitl it is size k
then if element > min
    pop min
    add element

return min

 */
