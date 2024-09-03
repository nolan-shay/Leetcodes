class Solution {
    public int getSum(int a, int b) {
        String sum = add(convert(a),convert(b));
        System.out.println(convert(a));
        System.out.println(convert(b));

        System.out.println(sum);

        return revert(sum);
    }

    //converts an integer into 12 char two's complement
    public String convert(int a){
        //check sign
        if (a < 0){
            // System.out.println("convert: " + Integer.toBinaryString(a * -1));
            return invert( toTwelve((Integer.toBinaryString(a * -1))));
        } else {
            return toTwelve(Integer.toBinaryString(a));
        }
        //if its negative we will invert it find the binary, then do the twos complement inversion
        //else its just the binary.
        
    }

    // flips the sign of a twos complement binary representation and returns it in a 12 bit string;
    public String invert(String a){
        // go through the string and flip the bits, add 1 with add func
        String ans = "";
        for (int i = 0; i< a.length(); i++){
            if(a.charAt(i) == '0'){
                ans = ans + "1";
            } else {
                ans = ans + "0";
            }
        }
        // System.out.println("invert before add: " + ans);
        return add( toTwelve("1"), toTwelve(ans));

    }

    // given two twos complement ints, add them together.
    public String add( String a, String b){
        String ans = "";
        int carry = 0;
        for(int i = 11; i >= 0; i--){
            char charA = a.charAt(i);
            char charB = b.charAt(i);
            //if all zero then zero
            if (charA == '0' && charB == '0' && carry == 0 ){
                ans = "0" + ans;
            }
            //if one then one and carry = 0
            else if ((charA == '1' && charB =='0' && carry == 0) || (charA == '0' && charB =='1' && carry == 0) || (charA == '0' && charB =='0' && carry == 1)){
                ans = "1" + ans;
                carry = 0;
            }
            //if two then zero and carry = 1
            else if ((charA == '1' && charB =='1' && carry == 0) || (charA == '0' && charB =='1' && carry == 1) || (charA == '1' && charB =='0' && carry == 1)){
                ans = "0" + ans;
                carry = 1;
            } else {
                ans = "1" + ans; 
                carry = 1;
            }
            //if 3 then 1 and carry = 1
        }
        return ans;

    }

    String toTwelve(String a){
        while( a.length() < 12){
            a = "0"+a;
        }
        return a;
    }

    int revert(String a){
        if (a.charAt(0) == '1'){
            String ans = invert(a);
            return Integer.parseInt(ans,2) * -1;
        } else {
            return Integer.parseInt(a,2);
        }
    }
}

//first thought is convert to binary, add in binary, convert back to int;
//convert both ints to binary strings
//
