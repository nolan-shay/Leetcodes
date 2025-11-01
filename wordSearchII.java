class Solution {
    char[][] board;
    String[] words;
    boolean[][] visited;
    List<String> ans;
    HashSet<int[]> hs;
    StringBuilder sb;

    public List<String> findWords(char[][] board, String[] words) {
        this.words = words;
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        this.ans = new ArrayList<>();
        this.hs = new HashSet<>();
        this.sb = new StringBuilder();
        Node nd = initTrie(words);
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                dfs(i,j,nd);
            }
        }
        return ans;
    }

    public void dfs( int i, int j, Node node){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        // if (hs.contains(new int[]{i,j})) return;
        if (visited[i][j]) return;
        Node cur = node.children.get(board[i][j]);
        if (cur != null){
            sb.append(board[i][j]);
            // hs.add(new int[]{i,j});
            visited[i][j] = true;
            if (cur.isTerminal){
                ans.add(sb.toString());
                cur.isTerminal = false;
            }
            dfs(i+1,j,cur);
            dfs(i,j+1,cur);
            dfs(i-1,j,cur);
            dfs(i,j-1,cur);
            sb.deleteCharAt(sb.length() -1);
            // hs.remove(new int[]{i,j});
            visited[i][j] = false;

        }
    }

    public Node initTrie(String[] words){
        Node rt = new Node();
        Node cur = null;
        Node next = null;
        for (String word : words){
            cur = rt;
            for (int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                next = cur.children.get(ch);
                if (next == null){
                    next = new Node();
                    cur.children.put(ch,next);
                }
                cur = next;
            }
            next.isTerminal = true;
        }
        return rt;
    }
}

class Node{
    boolean isTerminal;
    HashMap<Character,Node> children;
    public Node (){
        isTerminal = false;
        children = new HashMap<>();
    }
}
