class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' ){
                stk.push('(');
            } else if (s.charAt(i) == '{' ){
                stk.push('{');
            } else if (s.charAt(i) == '[' ){
                stk.push('[');
            } else if (s.charAt(i) == ')' && !stk.empty() && stk.peek() == '('){
                stk.pop();
            } else if (s.charAt(i) == '}' && !stk.empty() && stk.peek() == '{'){
                stk.pop();
            } else if (s.charAt(i) == ']' && !stk.empty() && stk.peek() == '['){
                stk.pop();
            } else {return false;}
            
            
        }
        
        return stk.empty();
        
    }
}

class SolutionR {
    public boolean isValid(String s) {
        if ( s.length() == 0) { return true;}
        int count = 0;
        char first = s.charAt(0);
        char last;
        if ( first == '(') { last = ')';} 
        else if ( first == '[') { last = ']';}
        else { last = '}';}
        
        for ( int i = 0; i < s.length(); i++){
            if ( s.charAt(i) == first){
                count++;
            } else if ( s.charAt(i) == last){
                count--;
            }
            if (count == 0){
                if ( i == s.length() - 1){
                    return isValid( s.substring(1,i) );
                } else {
                    return isValid( s.substring(1,i)) && isValid( s.substring(i+1, s.length()) );
                }
            }
        }
        return false;
    }
}
