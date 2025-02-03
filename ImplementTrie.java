class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        Node next = null;
        for (int i = 0; i < word.length(); i++){
            next = cur.children[word.charAt(i) - 'a'];
            if (next == null){
                cur.children[word.charAt(i) - 'a'] = next = new Node();
            }
            cur = next;
        }
        if (next != null) next.isTerminal = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        Node next = null;
        for (int i = 0; i < word.length(); i++){
            next = cur.children[word.charAt(i) - 'a'];
            if (next == null) return false;
            cur = next;
        }
        return cur.isTerminal;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        Node next = null;
        for (int i = 0; i < prefix.length(); i++){
            next = cur.children[prefix.charAt(i) - 'a'];
            if (next == null) return false;
            cur = next;
        }
        return cur != null;
    }
}

class Node{
    Node(){
        children = new Node[26];
        isTerminal = false;
    }
    public Node[] children;
    public boolean isTerminal;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
