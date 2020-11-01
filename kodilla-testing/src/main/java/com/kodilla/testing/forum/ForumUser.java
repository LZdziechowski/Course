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

    public void addPost(String author, String postBody) {
        ForumPost forumPost = new ForumPost(postBody, author);
        posts.add(forumPost);
    }

    public void addComment(ForumPost thePost, String author, String commentBody) {
        ForumComment forumComment = new ForumComment(thePost, commentBody, author);
        comments.add(forumComment);
    }

    public int getPostQuantity() {
        return posts.size();
    }

    public int getCommentQuantity() {
        return comments.size();
    }

    public ForumPost getPost(int postNumber) {
        if(postNumber >= 0 && postNumber < posts.size()) {
            return posts.get(postNumber);
        }
        return null;
    }

    public ForumComment getComment(int commentNumber) {
        if(commentNumber >= 0 && commentNumber < comments.size()) {
            return comments.get(commentNumber);
        }
        return null;
    }

    public boolean removePost(ForumPost thePost) {
        boolean result = false;
        if(posts.contains(thePost)) {
            posts.remove(thePost);
            result = true;
        }
        return result;
    }

    public boolean removeComment(ForumComment theComment) {
        boolean result = false;
        if(comments.contains(theComment)) {
            comments.remove(theComment);
            result = true;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
