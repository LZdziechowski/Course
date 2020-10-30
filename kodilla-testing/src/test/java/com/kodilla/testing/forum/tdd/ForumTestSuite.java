package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @DisplayName("when add post with a addPost() method, getPostQuantity() method return 1")
    @Test
    void testAddPost() {
        System.out.println("Test Add Post.");
        //Given
        final String testName = "testName";
        final String testRealName = "testRealName";
        final String testPostBody = "testPostBody";
        final ForumUser testForumUser = new ForumUser(testName, testRealName);
        //When
        testForumUser.addPost(testName, testPostBody);
        //Then
        Assertions.assertEquals(1, testForumUser.getPostQuantity());
    }

    @DisplayName("when add comment with a addComment() method, getCommentQuantity() method return 1")
    @Test
    void testAddComment() {
        System.out.println("Test Add Comment");
        //Given
        final String testName = "testName";
        final String testRealName = "testRealName";
        final String testPostBody = "testPostBody";
        final String testAuthor = "testAuthor";
        final String testCommentBody = "testCommentBody";
        final ForumUser testForumUser = new ForumUser(testName, testRealName);
        final ForumPost testForumPost = new ForumPost(testPostBody, testAuthor);
        //When
        testForumUser.addComment(testForumPost, testAuthor,testCommentBody);
        //Then
        Assertions.assertEquals(1, testForumUser.getCommentQuantity());
    }


}
