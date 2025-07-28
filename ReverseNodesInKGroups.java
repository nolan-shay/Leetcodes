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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode pH = new ListNode();
        Queue<ListNode> ogFirst = new LinkedList<>();
        ogFirst.add(pH);
        ListNode cur = head;

        while(true){
            ListNode kth = cur;
            int i = 0;
            while( i < k - 1 && kth != null){
                kth = kth.next;
                i++;
            }
            if (kth == null) break;
            kth = kth.next; // kth now represents kth+1
            ogFirst.add(cur);
            ogFirst.poll().next = reverseK(cur,k);
            cur = kth;
        }
        ogFirst.poll().next = cur;
        return pH.next;
        
    }

    public ListNode reverseK(ListNode cur, int k){
        ListNode prev = null;
        ListNode next = cur.next;
        for (int i= 0; i < k-1; i++){
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;


    }
}

/*


make a function that does the reverse for k nodes, and connect it to the right place in the graph

Queue<listnode> ogFirst = new Queue<>();

reversekGroup(head,k)
    if k == 1 return head
    preHead = new ListNode<>()
    cur = head
    ogFirst.add(preHead)
    while()
        look ahead k elements an if find a null exit and set kth to kth element.next
            ogFirst.add(cur);
            ogFirst.Poll.next = reverseK(cur)
            cur = kth
    og.First.poll.next = cur;
    return head


reverseK firstElement( prev, cur, next). // reverses a group of k and returns its first element
prev = null
next = cur.next

for int i =0 , < k-1
    cur.next = prev
    prev = cur
    cur = next
    next = next.next;
cur.next = prev
return cur;

*/
