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

        this.avgUserPosts = this.usersCount <= 0 ? 0 : (this.postsCount / (double) this.usersCount);
        this.avgPostComments = this.postsCount <= 0 ? 0 : (this.commentsCount / (double) this.postsCount);
        this.avgUserComments = this.usersCount <= 0 ? 0 : (this.commentsCount / (double) this.usersCount);

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
}