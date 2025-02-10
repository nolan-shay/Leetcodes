class Solution {
    Queue<Character> q;
    HashSet<Character> hs;
    int cap;
    int curCap;
    PriorityQueue<Pair> taskList;
    public int leastInterval(char[] tasks, int n) {
        if ( n == 0) return tasks.length;
        cap = n;
        curCap = 0;
        q = new LinkedList<>();
        hs = new HashSet<>();
        taskList = new PriorityQueue<>((a,b)->(b.freq-a.freq));
        HashMap<Character,Integer> hm = new HashMap<>();
        for ( char ch : tasks){
            if (hm.containsKey(ch)) hm.put(ch,hm.get(ch)+1);
            else hm.put(ch,1);
        }
        for (Map.Entry<Character,Integer> e : hm.entrySet()){
            taskList.add(new Pair(e.getKey(),e.getValue()));
        }
        int count = 0;
        while(!taskList.isEmpty()){
            Pair task = getBestElement();
            add(task);
            if (task != null){
                task.freq = task.freq-1;
                if (task.freq != 0) taskList.add(task);
            }
            count++;
        }
        return count;
        
    }

    public Pair getBestElement(){
        Stack<Pair> st = new Stack<>();
        Pair element = taskList.poll();
        if (element == null) return element;
        while(element != null && hs.contains(element.ch)){
            st.push(element);
            element = taskList.poll();
        }
        while(!st.isEmpty()){
            taskList.add(st.pop());
        }
        return element;
    }

    public void add(Pair el){
        if (cap == 0) return;
        char ch = el != null ? el.ch : '!';
        if (curCap< cap){
            curCap++;
            hs.add(ch);
            q.add(ch);
        }else {
            char task = q.poll();
            hs.remove(task);
            hs.add(ch);
            q.add(ch);
        }
    }
}

class Pair{
    char ch;
    int freq;
    public Pair(char ch, int freq){
        this.ch = ch;
        this.freq=freq;
    }
}

/**

get HashMap Char to freq, for each emtry
    insert(linkedList, val);
while(LinkedList.isEmpty)
    element<A:#> getbestElement() give us the element with the highest val in linkedlist that doesn't appear in hashset
    add(element) to Queue Hashset //happens every time
    Heap.push(element with freeq decremented)


getBestElement( HashSet, LinkedList){ //)O(n)
    element = Heap.poll() // make sure we instantiate a max heap!
    while(hs.contains(nelement.char))
        stack.push element
        element = heap.poll()
    }
    while(!st.isEmpty){
        heap.push(st.pop());
    }
    return element;
}

add (char task){
    if curCap < cap
        q.add(task)
        hs.add(task)
        curCap++;
    else 
        last = q.poll()
        hs.remove(last)
        q.add(task)
        hs.add(task)
}
 */


// linked list sorted, we could look at n+1 elements
// remove first element that isn't in our hashset, then insert that element back in
// ordered freq map that diminishes as we add tasks...
// Queue Hashet combo size n+1 of last tasks
/**
 b : 2
 A : 1
 */
