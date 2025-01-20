class Solution { // from 1/20/25
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int length = 0;
        while( cur != null){
            length++;
            cur = cur.next;
        }
        cur = head;
        if ( n < length){
            for ( int i = 0; i < (length -n -1); i++){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        } else {
            head = head.next;
        }
        return head;
    }
}

/**
so we have to have ref to 3.
3.next = 3.next.next
n = 1
n = 1
but if n = sz
head = head.next;
edge cases where it is the front node or the last node

so first step is to iterate over the whole array to find its size

cur = head
length = 
while ( cur != null)
    length ++;

*/



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
        if (head.next == null) {return null;}
        ListNode cur2 = head;
        ListNode cur1 = head;
        for ( int i = 0; i < n; i++){
            cur2 = cur2.next;
        }
        if ( cur2 == null) { return head.next;}
        while(cur2.next!= null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur1.next = cur1.next.next;
        return head;

    }
}
/*
ListNode cur = head;
        HashMap<Integer, ListNode> hm = new HashMap<>();
        int count = 1;
        hm.put(count, cur);
        while(cur.next!=null){
            count++;
            cur = cur.next;
            hm.put(count, cur);
        }
        if (count == 1) {return null;}
        if ( count - n == 0) { return head.next;}
        ListNode hop = hm.get(count-n);
        hop.next = hop.next.next;
        return head; 
*/

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
