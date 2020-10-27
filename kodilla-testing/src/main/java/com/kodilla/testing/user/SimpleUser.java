package com.kodilla.testing.user;

public class SimpleUser {

    private final String username;
    private final String realName;

    public SimpleUser(String username, String realName){
        this.username = username;
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }
}
