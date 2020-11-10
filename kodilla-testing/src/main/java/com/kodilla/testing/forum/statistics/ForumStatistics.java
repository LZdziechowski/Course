package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private double numberOfUsers;
    private double numberOfPosts;
    private double numberOfComments;
    private double averageNumberOfPostsPerUser;
    private double averageNumberOfCommentsPerUser;
    private double averageNumberOfCommentsPerPost;
    //Statistics statistics;

//    public ForumStatistics(Statistics statistics) {
//        //this.statistics = statistics;
//        numberOfUsers = statistics.usersNames().size();
//        numberOfPosts = statistics.postCount();
//        numberOfComments = statistics.commentsCount();
//        if (statistics.usersNames().size() > 0) {
//            averageNumberOfPostsPerUser = (double) statistics.postCount() / statistics.usersNames().size();
//            averageNumberOfCommentsPerUser = (double) statistics.commentsCount() / statistics.usersNames().size();
//        } else {
//            averageNumberOfPostsPerUser = 0;
//            averageNumberOfCommentsPerUser = 0;
//        }
//        if (statistics.postCount() > 0) {
//            averageNumberOfCommentsPerPost = (double) statistics.commentsCount() / statistics.postCount();
//        } else {
//            averageNumberOfCommentsPerPost = 0;
//        }
//    }


    public void calculateAdvStatistics(Statistics statistics) {

        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postCount();
        numberOfComments = statistics.commentsCount();
        if (statistics.usersNames().size() > 0) {
            averageNumberOfPostsPerUser = (double) statistics.postCount() / statistics.usersNames().size();
            averageNumberOfCommentsPerUser = (double) statistics.commentsCount() / statistics.usersNames().size();
        } else {
            averageNumberOfPostsPerUser = 0;
            averageNumberOfCommentsPerUser = 0;
        }
        if (statistics.postCount() > 0) {
            averageNumberOfCommentsPerPost = (double) statistics.commentsCount() / statistics.postCount();
        } else {
            averageNumberOfCommentsPerPost = 0;
        }
    }

    public void showStatistics() {
        System.out.println("Number of users: " + numberOfUsers +
                "\nNumber of Posts: " + numberOfPosts +
                "\nNumber of comments: " + numberOfComments +
                "\nAverage number of posts per user: " + averageNumberOfPostsPerUser +
                "\nAverage number of comments per user: " + averageNumberOfCommentsPerUser +
                "\nAverage number of comments per post: " + averageNumberOfCommentsPerPost);
    }

    public double getNumberOfUsers() {
        return numberOfUsers;
    }

    public double getNumberOfPosts() {
        return numberOfPosts;
    }

    public double getNumberOfComments() {
        return numberOfComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }
}
