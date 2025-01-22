class LRUCache {
    int capacity;
    int curCap;
    Node head;
    Node tail;
    HashMap<Integer, Node> hm;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.curCap = 0;
        this.head = null;
        this.tail = null;
        hm = new HashMap<>();
        
    }
    
    //get value and put at 'top'
    public int get(int key) { //constant
        System.out.println("get " + key);
        if (!hm.containsKey(key)) return -1;
        // System.out.println("removing " + key);
        moveToTail(hm.get(key));

        return hm.get(key).value;
    }
    
    // add or update and put at 'top'
    // if capacity too large, remove element at 'bottom'
    // bookkKeep capacity
    public void put(int key, int value) { // constant
        System.out.println("put" + key + " " + value);
        if (hm.containsKey(key)){
            hm.get(key).value = value;
            moveToTail(hm.get(key));
            return;
        }
        if ( curCap < capacity){
            curCap++;
        } else {
            System.out.println("removing " + head.key);
            hm.remove(head.key);
            head = head.next;
            if (head != null) head.prev = null;
        }
        //add to end
        Node newNode = new Node(value, key);
        hm.put(key,newNode);
        if (tail == null && head == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            if (head == null) head = tail;
        }
    }

    private void moveToTail(Node cur){
        if ( cur == tail) {
            System.out.println("cur==tail");
            return;
        }
        if ( cur == head ){
            System.out.println("cur==head");
            head = head.next;
            tail.next = cur;
            cur.prev = tail;
            cur.next = null;
            head.prev = null;
            tail = cur;
            return;
        }
        System.out.println("cur==mid");
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur.prev = tail;
        tail.next = cur;
        cur.next = null;
        tail = cur;
    }
}

class Node {
    int value;
    int key;
    Node prev;
    Node next;

    public Node ( int value, int key){
        this.value = value;
        this.key = key;
        prev = null;
        next = null;
    }
}
/**
Queue<keys>
HashMap<Key, value>
put ()
    if key not present, add to backk of q
        if curCap < cap curCapp ++
        else remove front of queue; remove key from hashMap
    if key present, move from wherever to backk of queue

get()
    if not present -1
    if present return value and move from wherevere to back of q


most difficult part when update or get
    need to either move or delete a node in the middle of the q. and we need constant 
    time access to it
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
