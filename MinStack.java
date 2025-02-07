class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            min.push(val);
        }else{
            if (val <= min.peek()) min.push(val);
        }
        st.push(val);
    }
    
    public void pop() {
        if ( !st.isEmpty() && min.peek().equals(st.pop())) min.pop();
    }
    
    public int top() {
        if(!st.isEmpty()) return st.peek();
        return -12345;
    }
    
    public int getMin() {
        if(!min.isEmpty()) return min.peek();
        return -12345;
    }
}

/**
    stack st = reg stack
    stack min = stack for min values.

    push()
        if st.isEmpty{
            add to min stack
            andd to stack
        }
        else
            add to st
            if new min or equal to min, add to min

    pop()
        pop off st
        if that value equal the top of min, pop that as well.


    push 2 
    push 1 
    push 6


 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
