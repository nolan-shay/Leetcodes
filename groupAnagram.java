class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for ( String st : strs){
            int[] freq = new int[26];
            for ( char ch : st.toCharArray()){
                freq[ch-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for ( int i : freq){
                key.append(i+" ");
            }
            String keyStr = key.toString();
            if ( hm.containsKey(keyStr)){
                hm.get(keyStr).add(st);
            } else{
                List<String> list1 = new ArrayList<>();
                list1.add(st);
                hm.put(keyStr, list1);
                ans.add(list1);
            }
            
        }


        return ans;



    }
}

/*
 create a list<List<String>> ans
 boil down each word into a key that is unique based on the frequency of characters
 now create a Hashmap key:List<String>
 loop through each word in strs, boil it down to its key, if its key exists, add the word to its List
 else create a new Key
*/


class SolutionNSquared {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean match;
        List<List<String>> answer = new ArrayList<>();
        int[] visited = new int[strs.length]; // value 0 = unvisited; 1 = visited
        for ( int i = 0; i < strs.length; i++){
            if (visited[i] == 0){ 
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                //populate frequency array for strs[i]
                int[] freqI = new int[26];
                for ( int ind = 0; ind < strs[i].length(); ind++){
                    freqI[ strs[i].charAt(ind) - 'a' ]++;
                }
                for ( int j = i +1; j < strs.length; j++) {
                    if ( visited[j] == 0 && strs[i].length() == strs[j].length()){
                        int[] freqJ = new int[26];
                        for ( int ind = 0; ind < strs[j].length(); ind++){
                            freqJ[ strs[j].charAt(ind) - 'a' ]++;
                        }
                    
                        match = true;
                        for ( int t = 0; t<26; t++){
                            if ( freqI[t] != freqJ[t]){
                                match = false;
                            }
                        }
                        if (match){
                            visited[j] = 1;
                            group.add(strs[j]);
                        }
                    }
                }
                visited[i] = 1;
                answer.add(group);

            }
        }
        return answer;
    }
}

/*
 create a list<List<String>>
 array of same size of strs representing if a word has been grouped already
 for loop with i
    if i is unvisited
        create a <list<string>
        populate char freq array for strs[i]
        for loop with j = i+1
            if j is unvisited populate char freq array for strs[j]
                if frequency's are equivalent, add them to group
                mark j as visited
    mark i as visited
    add group to list<list<string>>



*/
