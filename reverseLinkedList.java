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
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null) {return head;}
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        reverseHelper(head);
        return tail;
    }
    
    public void reverseHelper(ListNode head){
        if (head.next == null){
            return;
        }else{
            reverseHelper(head.next);
            head.next.next = head;
            head.next = null;
        }
    }
}


// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if( head == null || head.next == null) {return head;}
//         ListNode tail = head;
//         while(tail.next != null){
//             tail = tail.next;
//         }
//         ListNode cur = head;
//         ListNode cur2 = head.next;
//         while(head.next != null){
//             cur = head;
//             cur2 = head.next;
//             while(cur2.next != null){
//                 cur2 = cur2.next;
//                 cur = cur.next;
//             }
//             cur2.next = cur;
//             cur.next = null;
//         }
//         return tail;
//     }
// }
