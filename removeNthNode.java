/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        Stack<ListNode> st = new Stack<>();
        int count = 1;
        st.push(cur);
        while(cur.next!=null){
            count++;
            cur = cur.next;
            st.push(cur);
        }
        if (count == 1) {return null;}
        if ( count - n == 0) { return head.next;}

        for ( int i =0; i < n; i++){
            st.pop();
        }
        ListNode hop = st.pop();
        hop.next = hop.next.next;
        return head;

    }
}

/*
        ListNode cur = head;
        int count = 0;
        while ( cur.next != null){
            count++;
            cur = cur.next;
        }
        if ( count == 0 ) { return null;}

        int beforeRemove = count-n;
        if ( beforeRemove == -1){ return head.next;}
        cur = head;
        count = 0;
        while (count != beforeRemove){
            count++;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;*/
