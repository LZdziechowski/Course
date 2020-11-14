package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum(int quantityOfForumUsers) {
        generateList(quantityOfForumUsers);
    }

    public void generateList(int userQuantity) {
        char userSex;
        LocalDate date;
        int quantutyOfPosts;
        for(int i = 1; i <= userQuantity; i++){
            userSex = 'M';
            date = LocalDate.of(1900 + i, 1, 1);
            quantutyOfPosts = -30 + i;
            if (i % 2 == 0){
                userSex = 'F';
            }
            if (quantutyOfPosts < 0) {
                quantutyOfPosts = 0;
            }
            forumUserList.add(new ForumUser(i, "userName" + i, userSex, date,quantutyOfPosts));
        }
    }

    public List<ForumUser> getForumUserList() {
        return forumUserList;
    }
}
