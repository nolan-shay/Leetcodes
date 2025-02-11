class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<HashSet<Integer>> hsList = new ArrayList<>();
        int[] culprit = new int[2];
        int pos = 0;
        
        for (int i = 0; i < edges.length; i++){
            HashSet<Integer> hs1 = null;
            HashSet<Integer> hs2 = null;
            for ( int j = 0; j < hsList.size(); j++){
                HashSet hs = hsList.get(j);
                if (hs.contains(edges[i][0])){
                    hs1 = hs;
                }
                if (hs.contains(edges[i][1])){
                    hs2 = hs;
                    pos = j;
                }
            }
            if ( hs1 == null && hs2 == null){
                HashSet<Integer> tempHs = new HashSet<>();
                tempHs.add(edges[i][0]);
                tempHs.add(edges[i][1]);
                hsList.add(tempHs);
            } else if (hs1 == hs2){
                culprit = edges[i];
            } else if ( hs1 == null){
                hs2.add(edges[i][0]);
            } else if ( hs2 == null){
                hs1.add(edges[i][1]);
            } else {
                hs1.addAll(hs2);
                hsList.remove(pos);
            }
        }
        return culprit;

    }
}

/*

create an arrayList of sets
add the first edge in its own set (i,j) can first edge be the only culprit??


then for edge (i,j) in edges
    hs1 = null
    hs2 = null
    for (hs : hslist){
        if hs.contains i
            hs1 = hs
        if hs.contains j
            hs2 = hs
    }
    if hs1 == hs2
        cuplrit == edge
    if hs1 == null and hs2 == null
        add a new hashset with this edge
    if hs1 == null
        hs2.add(i);
    if hs2 == null
        hs1.add(j)
    else hs1 != hs2
        hs1.addAll(hs2)
        remove hs2 from arraylist;

return culprit
*/


class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge : edges){
            if (uf.find(edge[0]) == uf.find(edge[1])){
                return edge;
            } else {
                uf.union(edge[0], edge[1]);
            }
        }
        return new int[2];
       
    }
}

class UnionFind {
    int[] parent;
    public UnionFind(int size){
        parent = new int[size+1];
        for ( int i = 0; i<size+1; i++){
            parent[i] = i;
        }
    }

    public int find(int child){
        if ( parent[child] == child){
            return child;
        }
        parent[child] = find(parent[child]);
        return parent[child];
    }

    public void union(int i, int j){
        int iParent = find(i);
        int jParent = find(j);
        parent[jParent] = iParent;

    }
}
