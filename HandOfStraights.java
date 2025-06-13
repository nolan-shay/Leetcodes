class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for ( int card : hand){
            set.add(card);
            if (freqMap.containsKey(card)){
                freqMap.put(card,freqMap.get(card)+1);
            } else {
               freqMap.put(card,1);
            }
        }
        ArrayList<Integer> orderedList = new ArrayList<>();
        for ( int card : set){
            orderedList.add(card);
        }
        Collections.sort(orderedList);

        for ( int startPos = 0; startPos < orderedList.size(); startPos++){
            System.out.println(startPos);
            int start = orderedList.get(startPos);
            if ( freqMap.get(start) != 0){
                int groups = freqMap.get(start);
                freqMap.put(start, 0);
                for ( int j = 1; j < groupSize; j++){
                    if (startPos+j >= orderedList.size()) return false;
                    if (orderedList.get(startPos +j) != orderedList.get(startPos) +j) return false;
                    int nextCard = orderedList.get(startPos+j);
                    freqMap.put(nextCard,freqMap.get(nextCard)-groups);
                    if ( freqMap.get(nextCard) < 0) return false;

                }
            }
        }
        return true;
    }
}

/**

if length % groupSize != 0 return false;
if there is a card with no neighbors, then its impossible
groupsize 1 return true

obtain sorted set of cards
obtain freq map
then for (int startPos in sorted List)
    start = sorted[startPos]
    if ( map[start] != 0)
        groups = map[start];
        map[start] = 0;
        for ( int j = 1 j < groupSize, j++ )
            if startPos+j >= n return false;
            if (sorted[startPos+j] != sorted[starPos] + j) return false
            nextCard = sorted[startPos+j]
            map[nextCard] = map[nextCard] - groups;
            if max[nextCard] < 0 return false;

return true;


seconnd thought freq mapping?

first thought, how would sorting help?
1:3
2:4
3:4
4:1

1,1,1,2,2,2,2,3,3,3,3,4
3

 */
