package com.kodilla.stream.forum;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ForumUserTestSuit {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Beginning of tests.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    void testGetLocationsOfFriends() {
        System.out.println("Test Get Locations Of Friends");
        //Given
        //CreateUsers
        final ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        final ForumUser user2 = new ForumUser("ethanreard", "Ethan Reard", "Miami");
        final ForumUser user3 = new ForumUser("eRiK", "Erik Hull", "Key West");
//        final ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
//        final ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
//        final ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        final ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
//        final ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        final ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Washington");
        final ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");
        //When
        //Create relations for user1
        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);
        //Create relations for user3
        user3.addFriend(user1);
        user3.addFriend(user7);
        user3.addFriend(user2);
        user3.addFriend(user9);
        //Create relations for user7
        user7.addFriend(user1);
        user7.addFriend(user3);
        //Create relations for user10
        user10.addFriend(user1);
        //Create relations for user2
        user2.addFriend(user3);
        //Create relations for user9
        user9.addFriend(user3);
        //Then
        //user1 has 3 friends with following locations:
        //      user3:  "Key West"
        //      user7:  "Washington"
        //      user10: "Miami"
        assertEquals(3,user1.getLocationsOfFriends().size());
        assertTrue(user1.getLocationsOfFriends().contains("Key West"));
        assertTrue(user1.getLocationsOfFriends().contains("Washington"));
        assertTrue(user1.getLocationsOfFriends().contains("Miami"));
        assertFalse(user1.getLocationsOfFriends().contains("Warsaw"));
    }

    @Test
    void testGetLocationsOfFriendsOfFriends() {
        System.out.println("Test Get Locations Of Friends Of Friends");
        //Given
        //CreateUsers
        final ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        final ForumUser user2 = new ForumUser("ethanreard", "Ethan Reard", "Miami");
        final ForumUser user3 = new ForumUser("eRiK", "Erik Hull", "Key West");
        final ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
        final ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
        final ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        final ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
        final ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        final ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Washington");
        final ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");
        //When
        //Create relations for user1
        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);
        //Create relations for user3
        user3.addFriend(user1);
        user3.addFriend(user7);
        user3.addFriend(user2);
        user3.addFriend(user9);
        //Create relations for user7
        user7.addFriend(user1);
        user7.addFriend(user3);
        //Create relations for user10
        user10.addFriend(user1);
        //Create relations for user2
        user2.addFriend(user3);
        //Create relations for user9
        user9.addFriend(user3);
        //Then
        //user1 has 3 friends with following friends and their locations:
        //      user3:  user1: - should be skipped ("this" in context of user1)
        //      user7: "Washington"
        //      user2: "Miami"
        //      user9: "Washington" - duplicated, should be skipped
        //      user7:  user1: - should be skipped ("this" in context of user1)
        //      user3: "Key West"
        //      user10: user1: - should be skipped ("this" in context of user1)
        assertEquals(3,user1.getLocationsOfFriendsOfFriends().size());
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Washington"));
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Miami"));
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Key West"));
        assertFalse(user1.getLocationsOfFriendsOfFriends().contains("Warsaw"));
    }
}
