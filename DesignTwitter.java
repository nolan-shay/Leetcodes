class Twitter {
    //get(user) returns the list of tweets that user has posted
    List<List<Tweet>> tweets;
    //get(user) returns the hashset representint the ids that user follows
    List<HashSet<Integer>> follows; 
    int time;

    public Twitter() {
        tweets = new ArrayList<>();
        follows = new ArrayList<>();
        time = 0;
        for (int i = 0; i < 501; i ++){
            tweets.add(new ArrayList<>());
            follows.add(new HashSet<>());
            follows.get(i).add(i);
        }
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.get(userId).add(new Tweet(tweetId, time));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        int size = 0;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        for ( int followee : follows.get(userId)){
            for ( Tweet tweet : tweets.get(followee)){
                if ( size < 10){
                    pq.add(tweet);
                    size++;
                } else if ( pq.peek().time < tweet.time) {
                    pq.poll();
                    pq.add(tweet);
                }
            }
        }
        Integer[] feed = new Integer[size];
        for (int i = size-1; i >= 0; i--){
            feed[i] = pq.poll().id;
        }
        return Arrays.asList(feed);
    }
    
    public void follow(int followerId, int followeeId) {
        if ( followerId == followeeId) return;
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if ( followerId == followeeId) return;
        follows.get(followerId).remove(followeeId);
    }
}

public class Tweet{
    int id;
    int time;
    
    public Tweet(int id, int time){
        this.id = id;
        this.time = time;
    }
}

/**
time = 0
Queue/LinkedList of all tweets
intialize list of Hashsets of size 500 (populated with userId)

postTweet(useerId, tweetID)
    add to all tweets (userId,tweetId,time)
    time++;

getNewsFeed( userId)
    pq minHeap based on timestamp
    sz = 0
    for( followee : hashsetList[userid])
        for tweet : tweets[userid] {
            if pq.size<10 add
            else if pq.peek.time < tweet.time
                pq.pop()
                pq.add(tweet)
        }

follow ( userid, followeeID)[
    hashsetList[userId].add(followeeID)
]

unfollow ( userid, followeeID)[
    hashsetList[userId].remove(followeeID)
]
 */

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
