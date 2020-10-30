package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {

    private final String name;
    private final String realName;
    private final List<ForumPost> posts = new ArrayList<>();
    private final List<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String name, String postBody) {
        //do nothing
    }

    public void addComment(ForumPost thePost, String author, String commentBody) {
        //do nothing
    }

    public int getPostQuantity() {
        //return 100 temporarily
        return 100;
    }

    public int getCommentQuantity() {
        //return 100 temporarily
        return 100;
    }

    public ForumPost getPost(int postNumber) {
        //return null means that the operation was unsuccessful
        return null;
    }

    public ForumComment getComment(int commentNumber) {
        //return null means that the operation was unsuccessful
        return null;
    }

    public boolean removePost(ForumPost thePost) {
        //return true temporarily
        return true;
    }

    public boolean removeComment(ForumComment theComment) {
        //return true temporarily
        return true;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
