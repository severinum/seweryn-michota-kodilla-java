package com.kodilla.testing.forum.statistics;

public class StatisticsModule {

    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double avgUserPosts;
    private double avgUserComments;
    private double avgPostComments;

    private Statistics statistics;

    public void calculateAdvStatistics(Statistics statistics){
        this.statistics = statistics;
        this.usersCount = statistics.usersNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();

        this.avgUserPosts = _calculateAvgUserPosts();
        this.avgPostComments = _calculateAvgPostComments();
        this.avgUserComments = _calculateAvgUserComments();

    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAvgUserPosts() {
        return avgUserPosts;
    }

    public double getAvgUserComments() {
        return avgUserComments;
    }

    public double getAvgPostComments() {
        return avgPostComments;
    }

    private double _calculateAvgUserComments() {
        if(this.usersCount <= 0) return 0;
        return (this.commentsCount / (double) this.usersCount);
    }

    private double _calculateAvgPostComments() {
        if(this.postsCount <= 0) return 0;
        return (this.commentsCount / (double) this.postsCount);
    }

    private double _calculateAvgUserPosts() {
        if(this.usersCount <= 0) return 0;
        return (this.postsCount / (double) this.usersCount);
    }
}