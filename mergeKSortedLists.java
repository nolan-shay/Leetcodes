class SolutionPQ {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        LNComp comp = new LNComp();
        PriorityQueue<ListNode> pq = new PriorityQueue<>(comp);
        for ( ListNode ln :lists){
            if(ln != null){
                pq.add(ln);
            }
        }
        ListNode head = pq.poll(); // cur node in growing list
        if (head == null) return null;
        if (head.next != null){
            pq.add(head.next);
        }
        ListNode cur = head;
        ListNode top = pq.poll();
        head.next = top;
        while ( top != null){
            cur.next = top;
            cur = top;
            if (top.next != null){
               pq.add(top.next);
            }
            top = pq.poll();
        }

        return head;

        
    }

}

class LNComp implements Comparator<ListNode> {

    public int compare (ListNode a, ListNode b){
        return a.val-b.val;
    }
}

class SolutionFirst {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int min = 0;
        int minIndex = -1;
        for ( int i = 0; i < lists.length; i++){
            if (lists[i] != null){
                min = lists[i].val;
                minIndex = i;
                break;
            }
        }
        if (minIndex == -1) {return null;}
        for ( int i = minIndex+1; i < lists.length; i++){
            if( lists[i] != null && lists[i].val < min){
                min = lists[i].val;
                minIndex = i;
            }

        }
        ListNode head = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        head.next = mergeKLists(lists);
        return head;

        
    }

}
