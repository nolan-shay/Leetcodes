class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char ch: s1.toCharArray()){
            if (hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            } else hm.put(ch,1);
        }
        for ( int i = 0; i < s1.length(); i++){
            decrement(s2.charAt(i), hm);
        }

        int ptr1 = 0;
        int ptr2 = s1.length();
        while( !hm.isEmpty() && ptr2 < s2.length()){
            decrement(s2.charAt(ptr2), hm);
            increment(s2.charAt(ptr1), hm);
            ptr1++;
            ptr2++;
        }
        return hm.isEmpty();
    }

    public void decrement( char ch, HashMap<Character, Integer> hm){
        if (hm.containsKey(ch)){
            int freq = hm.get(ch);
            if (freq == 1) {
                hm.remove(ch);
            } else {
                hm.put(ch,hm.get(ch)-1);
            }
        } else {
            hm.put(ch,-1);
        }
    }

    public void increment( char ch, HashMap<Character, Integer> hm){
        if (hm.containsKey(ch)){
            int freq = hm.get(ch);
            if (freq == -1) {
                hm.remove(ch);
            } else {
                hm.put(ch,hm.get(ch)+1);
            }
        } else {
            hm.put(ch,+1);
        }
    }

    
}

/**
s2 contains a permutation of s1
s2.length is at least s1.length

 hashMap< char: instances> hm
 create a freq map of s1
 for int i = 0; i < s1.length; i++  
    chhar= s1.charAt i
    if hm.containsKey(char)
        hm.put(char,hm.get(char)+1)
    else hm.put char,1

//negative means this char exists too many times
//not present means 0 times
// positive means it doesn't occur enough

 for int i = 0; i < s1.length; i++
    char = s2.charAt(i)
    if hm.contains(char) 
        freq = hm.get(char)
        if freq == 1 remove that from hashmap
        else hm.put(char, hm.getChar-1);
    else hm.put(char:-1)

// as we move ptr 2, we decrement, 
// as we move ptr1, we increment
//  then move our window piece by piece until we are at the end or hashMap is empty
  ptr1 = 0;
  ptr2 = s1.length
(ptr1,ptr2]
while(!hm.isEmpty() And ptr2 < s2.length)
decrement char at ptr2
increment char at ptr1
    char = s2.charAt(i)
    if hm.contains(char) 
        freq = hm.get(char)
        if freq == -1 remove that from hashmap
        else hm.put(char, hm.getChar+1);
    else hm.put(char:1)
ptr1++
ptr2++
return(hm.isEmpty)

  
ptr1 = 0
ptr2 = 1

s1 ="ab"
s2 ="bba"

 */
