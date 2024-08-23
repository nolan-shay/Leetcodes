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
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null){
            return;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        stack.push(cur);
        while(cur.next != null){
            cur = cur.next;
            stack.push(cur);
        }
        ListNode start = head;
        while(true){
            cur = stack.pop();
            cur.next = start.next;
            start.next = cur;
            start = start.next.next;
            if( cur == start){
                start.next = null;
                return;
            }
        }


    }
}


class Solution2 {
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {return;}
        //find halfway
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverseList(slow.next);
        slow.next = null;
        ListNode tmp1,tmp2;
        while(head2 != null && head != null){
            tmp1 = head.next;
            tmp2 = head2.next;
            head.next = head2;
            head2.next = tmp1;
            head = tmp1;
            head2 = tmp2;

        }

    }

    public ListNode reverseList(ListNode head){
        ListNode prev= null,next = null;
        ListNode cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
