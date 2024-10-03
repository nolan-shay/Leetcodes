class MedianFinder {
    int maxHeapCt;
    int minHeapCt;
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.maxHeapCt = 0;
        this.minHeapCt = 0;
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if ( maxHeapCt == 0 || minHeapCt == 0){
            maxHeap.add(num);
            maxHeapCt++;
        } else {
            int left = maxHeap.peek();
            int right = minHeap.peek();
            if ( num >= right){
                minHeap.add(num);
                minHeapCt++;

            } else {
                maxHeap.add(num);
                maxHeapCt++;
            }
        }

        if ( maxHeapCt - minHeapCt == 2){
            minHeap.add(maxHeap.poll());
            minHeapCt++;
            maxHeapCt--;
        } else if (minHeapCt - maxHeapCt == 2){
            maxHeap.add(minHeap.poll());
            maxHeapCt++;
            minHeapCt--;
        }
        
    }
    
    public double findMedian() {
        if ( maxHeapCt == minHeapCt){
            return ((double) maxHeap.peek() + (double) minHeap.peek() )/2;
        } else if ( maxHeapCt > minHeapCt){
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
