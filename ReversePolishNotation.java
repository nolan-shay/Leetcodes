class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int operand1,operand2;
        for( String t : tokens){
            if ( t.equals("/")){
                operand2 = stack.pop();
                operand1 = stack.pop();
                stack.push(operand1 / operand2);
            } else if ( t.equals("+")){
                operand2 = stack.pop();
                operand1 = stack.pop();
                stack.push(operand1 + operand2);
            } else if ( t.equals("-")){
                operand2 = stack.pop();
                operand1 = stack.pop();
                stack.push(operand1 - operand2);
            } else if ( t.equals("*")){
                operand2 = stack.pop();
                operand1 = stack.pop();
                stack.push(operand1 * operand2);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
/**

make a stack

for string in tokens
    if not a token (+ - * /)
        push that value on the stack
    if it is a token
        operand2 = pop
        operand1 = pop
    stack.push operand1 token operand2
return stack.pop

Input: tokens = ["1","2","+","3","*","4","-"]

stack = 5

**/
