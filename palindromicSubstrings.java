class Solution {
    public int countSubstrings(String s) {
        int counter = s.length();
        for (int i = 0; i < s.length(); i++){
            counter += even(s,i);
            counter += odd(s,i);
        }
        return counter;
    }

    public int odd(String s, int pos){
        int counter = 0;
        int left = pos - 1;
        int right = pos + 1;
        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))){
            counter++;
            left--;
            right++;
        }
        return counter;
    }

    public int even(String s, int pos){
        int counter = 0;
        int left = pos;
        int right = pos+1;
        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))){
            counter++;
            left--;
            right++;
        }
        return counter;
    }
    /*\
    void funcOdd(String s, int pos, int counter) { a(a)a
        left = pos--;
        right = pos++;
        while(left>= 0 AND right < s.length AND s.CharAt(left) == s.charAt(right))
          increment counter
          left--;
          right++;
    }
    func Even(String s, int pos, int counter)// pos is left of center a(b)ba
        left = pos;
        right = pos++;
        while(left>= 0 AND right < s.length AND s.CharAt(left) == s.charAt(right))
          increment counter
          left--;
          right++;


        */
}
