package com.kodilla.patterns.strategy.social;

public class User {

    private final String username;
    protected SocialPublisher socialPublisher;

    public User(String username) {
        this.username = username;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setSharingStrategy(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
