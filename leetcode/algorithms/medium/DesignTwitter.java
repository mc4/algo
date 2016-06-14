
public class Twitter {
    static HashMap<Integer, User> users;
    
    /** Initialize your data structure here. */
    public Twitter() {
        this.users = new HashMap<Integer, User>();
    }
    
    private static void ensureUser(int userId) {
        if(users.get(userId) == null) {
            users.put(userId, new User(userId));
        } 
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        ensureUser(userId); 
     
        for(Integer i: users.keySet()) {
            User user = users.get(i);
            if(user.following.contains(userId)) {
                user.addToTail(tweetId);
            }
        }
        
        User user = users.get(userId);
        user.addToTail(tweetId);
        user.myTweets.add(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = users.get(userId).newsFeed;
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i = newsFeed.size() - 1; i >= 0; i--){
            res.add(newsFeed.get(i));
        }
        
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(users.get(followerId) == null && users.get(followeeId) == null) {
            return;
        }

        users.get(followerId).following.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(users.get(followerId) == null && users.get(followeeId) == null) {
            return;
        }
        
        User user = users.get(followerId);
        List<Integer> userFollowing = user.following;
        userFollowing.remove(new Integer(followeeId));
        user.newsFeed.removeAll(users.get(followeeId).myTweets);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
    
class User {
    int id;
    List<Integer> newsFeed;
    List<Integer> following;
    List<Integer> myTweets;
    
    public User(int id){
        this.id = id;
        this.newsFeed = new ArrayList<Integer>();
        this.following = new ArrayList<Integer>();
        this.myTweets = new ArrayList<Integer>();
    }
    
    public void addToTail(int tweetId){
        if(newsFeed.size() == 10){
            newsFeed.remove(0);
        } 
        newsFeed.add(tweetId);
    }
}