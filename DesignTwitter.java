import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import DesignTwitter_355.Tweet;

public class DesignTwitter {

	public static void main(String[] args) {
		DesignTwitter obj = new DesignTwitter();
//		obj.postTweet(1, 5);
//		System.out.println(obj.getNewsFeed(1));
//		obj.follow(2, 1);
//		obj.follow(2, 1);
//		obj.postTweet(2, 6);
//		obj.postTweet(1, 7);
//		System.out.println(obj.getNewsFeed(1));
//		System.out.println(obj.getNewsFeed(2));
////		obj.unfollow(2, 1);
//		obj.unfollow(1, 2);
//		System.out.println(obj.getNewsFeed(1));
//		System.out.println(obj.getNewsFeed(2));
		
//		obj.postTweet(1, 5);
//		obj.follow(1, 2);
//		obj.follow(2, 1);
//		obj.postTweet(2, 6);
//		System.out.println(obj.getNewsFeed(1));
//		System.out.println(obj.getNewsFeed(2));
//		obj.unfollow(2, 1);
//		System.out.println(obj.getNewsFeed(1));
//		System.out.println(obj.getNewsFeed(2));
//		obj.unfollow(1, 2);
//		System.out.println(obj.getNewsFeed(1));
//		System.out.println(obj.getNewsFeed(2));
//	
		obj.postTweet(1, 5);
		obj.postTweet(2, 6);
		obj.postTweet(1, 7);
		obj.follow(2, 1);
		System.out.println(obj.getNewsFeed(1));
		System.out.println(obj.getNewsFeed(2));
		obj.unfollow(2, 1);
		System.out.println(obj.getNewsFeed(1));
		System.out.println(obj.getNewsFeed(2));
//		obj.unfollow(1, 2);
//		System.out.println(obj.getNewsFeed(1));
//		System.out.println(obj.getNewsFeed(2));
	
	}

	private Map<Integer, PriorityQueue<Tweet>> postMap = null;
	private Map<Integer, Set<Integer>> followerMap = null;
    private Map<Integer, LinkedList<Tweet>> individualPostMap = null;
    private int time = 0;

	public DesignTwitter() {
		postMap = new HashMap<>();
		followerMap = new HashMap<>();
        individualPostMap = new HashMap<>();
        time = 0;
	}

	public void postTweet(int userId, int tweetId) {
        time++;
        Tweet tweet = new Tweet(tweetId, time);
        
		Set<Integer> followers = followerMap.get(userId);
		if(followers == null){
			createNewUser(userId);
			followers = followerMap.get(userId);
			followerMap.put(userId, followers);
		}
		
		for(int follower : followers){
			PriorityQueue<Tweet> post = postMap.get(follower);
			post.offer(tweet);
			postMap.put(follower, post);
		}
		
		LinkedList<Tweet> individualPosts = individualPostMap.get(userId);
		individualPosts.offerFirst(tweet);
		individualPostMap.put(userId, individualPosts);
	}

	public List<Integer> getNewsFeed(int userId) {
		List<Integer> feeds = new ArrayList<>();
		List<Tweet> tweets = new ArrayList<>();
		
		PriorityQueue<Tweet> posts = postMap.get(userId);
		if(posts == null){
			return feeds;
		}

		int i=0;
		while(i != 10 && !posts.isEmpty()){
			Tweet t = posts.poll();
			tweets.add(t);
            i++;
		}
		i=0;
		while(i != tweets.size()) {
			posts.offer(tweets.get(i));
			i++;
		}
		
		for(Tweet t : tweets) {
			feeds.add(t.id);
		}
		
		return feeds;
	}

	public void follow(int followerId, int followeeId) {
		Set<Integer> followers = followerMap.get(followerId);
		if(followers == null){
			createNewUser(followerId);
			followers = followerMap.get(followerId);
		}
		
		followerMap.put(followerId, followers);
		
		followers = followerMap.get(followeeId);
		if(followers == null){
			createNewUser(followeeId);
			followers = followerMap.get(followeeId);
		}
		
		if(followers.contains(followerId)) {
			return;
		}
		
		followers.add(followerId);
		followerMap.put(followeeId, followers);
		
		LinkedList<Tweet> postsFollowee = individualPostMap.get(followeeId);
		PriorityQueue<Tweet> postsFollower = postMap.get(followerId);
		
		for(Tweet post : postsFollowee) {
			postsFollower.offer(post);
		}
		
		postMap.put(followerId, postsFollower);
	}

	public void unfollow(int followerId, int followeeId) {
		Set<Integer> followers = followerMap.get(followeeId);
		if(!followers.contains(followerId)) {
			return;
		}
		followers.remove(followerId);
		followerMap.put(followeeId, followers);
		
		LinkedList<Tweet> postsFollowee = individualPostMap.get(followeeId);
		PriorityQueue<Tweet> postsFollower = postMap.get(followerId);
		
		for(Tweet post : postsFollowee) {
			postsFollower.remove(post);
		}
		postMap.put(followerId, postsFollower);
	}
    
	private void createNewUser(int userId) {
		Set<Integer> followers = new HashSet<>();
		followers.add(userId);  
		followerMap.put(userId, followers);
		postMap.put(userId, new PriorityQueue<>((t1, t2) -> t2.time - t1.time));  
		individualPostMap.put(userId, new LinkedList<>());
	}
	
	private static class Tweet{
        int id;
        int time;
        
        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }
}
