class Twitter {
    static Map<Integer, User> umap;
    int time=0;

    public Twitter() {
        umap = new HashMap<>(); 
    }
    
    public void postTweet(int userId, int tweetId) {
        if(umap.containsKey(userId)){
            User user = umap.get(userId);
            user.myfeed.add(new int[]{tweetId,time++});
        } else{
            User user = new User(userId);
            user.myfeed.add(new int[]{tweetId,time++});
            umap.put(userId,user);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(umap.containsKey(userId)){
            return umap.get(userId).getFeed();
        } else{
            User user= new User(userId);
            umap.put(userId,user);
            return List.of();
        }
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        if(umap.containsKey(followerId)){
            umap.get(followerId).follows.add(followeeId);
        } else{
            User user =new User(followerId);
            user.follows.add(followeeId);
            umap.put(followerId,user);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        if(umap.containsKey(followerId)){
            umap.get(followerId).follows.remove(Integer.valueOf(followeeId));
        }
    }
}
class User{
    int userId;
    public Set<Integer> follows; 
    public PriorityQueue<int[]> myfeed;
    public User(int userId){
        this.userId= userId;
        follows = new HashSet<>();
        myfeed  = new PriorityQueue<>((a,b)->a[1]-b[1]);
    }
    List<Integer> getFeed(){
    
        PriorityQueue<int[]> copy = new PriorityQueue<>((a,b)->a[1]-b[1]);
        copy.addAll(myfeed);    
        for(Integer friend: follows){
            User user = Twitter.umap.get(friend);
            copy.addAll(user.myfeed);
        }
        while(copy.size()>10){
            copy.poll();
        }
        List<Integer> resfeed = new ArrayList<>();
        while(!copy.isEmpty()){
            resfeed.add(copy.poll()[0]);
        }
        Collections.reverse(resfeed);
        return resfeed;
    }
}
