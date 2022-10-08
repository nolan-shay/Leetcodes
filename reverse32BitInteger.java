class Solution {
    public int reverse(int x) {
        int answer = 0;
        int newAnswer = 0;
        int mult = 1;
        if (x < 0){
            mult = -1;
            x = -x;
        }
        while (x>0){
            newAnswer = answer*10 + x%10;
            if ((newAnswer - x% 10) /10  != answer){
                return 0;
            } 
            answer = newAnswer;
            x = x / 10;
        }
        return answer *mult;
        
    }
}
