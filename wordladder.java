class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> words = new ArrayList<>();
        words.addAll(wordList);
        boolean b = false;
        int bIndex = 0;
        boolean e = false;
        for ( int i = 0; i < words.size(); i ++){
            if ( words.get(i).equals(beginWord)) {
                b = true;
                bIndex = i;
            }
            if ( words.get(i).equals(endWord)) e = true;
        }
        if (!e) return 0;
        if (!b) {
            words.add(beginWord);
            bIndex = words.size()-1;
        }
        boolean[] visited = new boolean[words.size()];
        List<List<Integer>> adj = new ArrayList<>();
        for ( int i = 0; i < words.size(); i++){
            adj.add(new ArrayList<>());
        }
        for ( int i = 0; i < words.size(); i++){
            for ( int j = i +1; j < words.size(); j++){
                if ( isOneLetterOff(words.get(i), words.get(j))){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        System.out.println(words);

        for ( int i = 0; i < words.size(); i ++){
            System.out.print(words.get(i) + ": ");
            for ( int j : adj.get(i)){
                System.out.print(words.get(j) + ",");
            }
            System.out.println();
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{bIndex,1});

        while( !q.isEmpty()){
            int[] node = q.poll();
            if ( words.get(node[0]).equals(endWord)) return node[1];
            visited[node[0]] = true;
            for ( int neighb : adj.get(node[0])){
                if (!visited[neighb]){
                    q.add(new int[]{neighb, node[1]+1});
                }
            }
        }
        return 0;
    }

    public boolean isOneLetterOff( String a, String b){
        int differences = 0;
        for ( int i = 0; i < a.length(); i ++){
            if (a.charAt(i) != b.charAt(i)) differences++;
            if (differences > 1) return false;

        }
        return true;
    }
}

/**

first pre req, is end word present.

first thought

for a graph where a connection = 1 letter difference. (we can just include beginword)
then we do a bfs on this since its unweigted, keeping track of our depth ( make sure to know how depth correlates)

transformation into a graph just gonna be nxn by word length

make new list with beginWord at end; or add it to the end.
List<List<Integer> adjList
for ( i = 0..)
    for ( j= 1+1...)
        if (one letter apart)
            adjList.get(i).add(j);
            adjList.get(j).add(i);

    Queue<int[]> q
    q.add(new int[]{lastPos,1})

    while(q isn't empty){
        node = q.pop
        visited[node] = true;
        if nodes word = end word return node[1]+1
        for ( neighb : adjList.get(node[0]))
            if( neigb isn't visited)[
                q.add(neigh, node[1] +1)
            ]
    }

    return 0;
    

given two words( string a , String b){
    int[] freq = new int[26]
    for ( char ch : a.to CharArray)
        freq[ch - 'a'] ++;
    for ( char ch : b.to CharArray)
        freq[ch - 'b'] ++;
    int occ;
    boolean negOne;
    boolean posOne;
    for ( int i = 0, i < 26)
        if( freq[i] != 0) occ++
        if( freq[i] == 1) posOne = true
        if( freq[i] == -1) negOne = true
    return occ == 2 and negOne and posOne;


}


 */
