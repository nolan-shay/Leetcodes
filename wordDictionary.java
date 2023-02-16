class WordDictionary {

    public Trie trieDict;

    public WordDictionary() {
        trieDict = new Trie('_');
    }
    
    public void addWord(String word) {
        Trie node = trieDict;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if ( node.neighbors[ ch -'a' ] == null){
                node.neighbors[ ch -'a' ] = new Trie(ch);
            }
            // node.print();
            node = node.neighbors[ch-'a'];
        }
        node.isTerminal = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, trieDict);
    }

    private boolean searchHelper( String word, int pos, Trie tr){
        if ( tr == null) return false;
        char ch = word.charAt(pos);
        if ( ch == '.'){
            if ( pos == word.length() -1 ){
                for ( Trie neighbor : tr.neighbors) {
                    if ( neighbor != null && neighbor.isTerminal ){
                        return true;
                    }
                }
                return false;
            }
            for ( Trie neighbor : tr.neighbors) {
                if ( searchHelper(word, pos+1, neighbor) ){
                    return true;
                }
            }
            return false;
        }
        Trie nextNode = tr.neighbors[ ch-'a' ];
        if ( pos == word.length() - 1) {
            return nextNode != null && nextNode.isTerminal;
        }
        return searchHelper(word, pos+1, nextNode);
    }
}

class Trie {
    public char val;
    public Trie[] neighbors;
    public boolean isTerminal;
    public Trie (char ch){
        val = ch;
        neighbors = new Trie[26];
        isTerminal = false;
    }

    public void print(){
        System.out.println( this + " " + this.val + " " + this.isTerminal);
        for ( Trie neighbor : neighbors){
            System.out.print(neighbor);
        }
        System.out.println();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
