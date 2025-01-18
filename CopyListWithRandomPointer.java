/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node,Node> hm = new HashMap<>();
        Node cur = head;
        while ( cur != null){
            Node newNode = new Node(cur.val);
            hm.put(cur,newNode);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            Node newNode = hm.get(cur);
            if (cur.next == null){
                newNode.next = null;
            } else {
                newNode.next = hm.get(cur.next);
            }
            if (cur.random == null){
                newNode.random = null;
            } else {
                newNode.random = hm.get(cur.random);
            }
            cur = cur.next;
        }
        return hm.get(head);
    }
}

/**
HashMap of ogNode: newNode
go thrugh head list once and make the hashmap ( creating new Nodes )
then go through a second time for each node cur

newNode = hm.get(cur)
newNode.next = hm.get(cur.next)
newNode.random = hm.get(cur.random)
return hm.get(head);

hm Node:Node
cur = head
    while (cur != null)
    newNode = new Node ( cur.value);
    hm.put(cur,newNode);
    cur = cur.next;
cur = head
while cur != null
    newNode = hm.get(cur);
    if cur.next != null
        newNode.next = hm.get(cur.next)
    else NewNode.next == null
    if cur.random != null
        newNode.random = hm.get(cur.random)
    else cur.random == null;
    cur = cur.next

 */
