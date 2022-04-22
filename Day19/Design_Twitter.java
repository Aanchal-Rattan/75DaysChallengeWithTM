class Count {
    public Integer timestamp;
    public Integer tweetId;

    public Count(Integer counts, Integer vals) {
        this.timestamp = counts;
        this.tweetId = vals;
    }
}

class Twitter {

    HashMap<Integer, HashSet<Integer>> users;
    HashMap<Integer, ArrayList<Count>> tweets;
    int timestamp;

    public Twitter() {
        users = new HashMap<Integer, HashSet<Integer>>();
        tweets = new HashMap<Integer, ArrayList<Count>>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<Count>());
        }

        if (tweets.containsKey(userId)) {
            ArrayList<Count> a = tweets.get(userId);
            if (!a.contains(tweetId)) {
                a.add(new Count(timestamp, tweetId));
            }
        }
        timestamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Count> pq = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

        if (users.containsKey(userId)) {
            HashSet<Integer> s = users.get(userId);
            if (!s.isEmpty()) {
                for (Integer i : s) {
                    if (tweets.containsKey(i)) {
                        pq.addAll(tweets.get(i));
                    }
                }
            }
        }

        if (tweets.containsKey(userId)) {
            ArrayList<Count> t = tweets.get(userId);
            pq.addAll(tweets.get(userId));
        }

        int j = 10;
        List<Integer> result = new ArrayList<>();

        while (j > 0 && !pq.isEmpty()) {
            Count currentVal = pq.poll();
            result.add(currentVal.tweetId);
            j--;
        }
        return result;

    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            HashSet<Integer> n = new HashSet<>();
            n.add(followeeId);
            users.put(followerId, n);
            return;
        }
        Set<Integer> followers = users.get(followerId);
        if (followers.contains(followeeId)) {
            return;
        }
        followers.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) {
            Set<Integer> followers = users.get(followerId);
            followers.remove(followeeId);

        }
    }
}
