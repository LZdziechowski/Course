package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
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

    @Nested
    @DisplayName("Tests for posts")
    class TestPosts {

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

        @DisplayName("when add post with addPost() method, getPost() method return the same post")
        @Test
        void testGetPost() {
            System.out.println("Test Get Post");
            //Given
            final String testName = "testName";
            final String testRealName = "testRealName";
            final String testPostBody = "testPostBody";
            final String testAuthor = "testAuthor";
            final ForumUser testForumUser = new ForumUser(testName, testRealName);
            final ForumPost testForumPost = new ForumPost(testPostBody, testAuthor);
            testForumUser.addPost(testForumPost.getAuthor(), testForumPost.getPostBody());
            //When
            final ForumPost retrivedPost = testForumUser.getPost(0);
            //Then
            Assertions.assertEquals(testForumPost, retrivedPost);
        }

        @DisplayName("when use removePost() method and given as a parameter post not exist, used method return false")
        @Test
        void testRemovePostNotExisting() {
            System.out.println("Test Remove Post Not Existing");
            //Given
            final String testName = "testName";
            final String testRealName = "testRealName";
            final String testPostBody = "testPostBody";
            final String testAuthor = "testAuthor";
            final ForumUser testForumUser = new ForumUser(testName, testRealName);
            final ForumPost testForumPost = new ForumPost(testPostBody, testAuthor);
            //When
            final boolean result = testForumUser.removePost(testForumPost);
            //Then
            Assertions.assertFalse(result);
        }

        @DisplayName("when use removePost() method and given as a patrameter post exist, used method return true and post is removed")
        @Test
        void testRemovePost() {
            System.out.println("Test Remove Post");
            //Given
            final String testName = "testName";
            final String testRealName = "testRealName";
            final String testPostBody = "testPostBody";
            final String testAuthor = "testAuthor";
            final ForumUser testForumUser = new ForumUser(testName, testRealName);
            final ForumPost testForumPost = new ForumPost(testPostBody, testAuthor);
            testForumUser.addPost(testAuthor, testPostBody);
            //When
            final boolean result = testForumUser.removePost(testForumPost);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, testForumUser.getPostQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for Comment")
    class TestComments {

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
            testForumUser.addComment(testForumPost, testAuthor, testCommentBody);
            //Then
            Assertions.assertEquals(1, testForumUser.getCommentQuantity());
        }

        @DisplayName("when add comment with addComment() method, getComment() methot return the same comment")
        @Test
        void testGetComment() {
            System.out.println("Test Get Comment");
            //Given
            final String testName = "testName";
            final String testRealName = "testRealName";
            final String testPostBody = "testPostBody";
            final String testAuthor = "testAuthor";
            final String testCommentBody = "testCommentBody";
            final ForumUser testForumUser = new ForumUser(testName, testRealName);
            final ForumPost testForumPost = new ForumPost(testPostBody, testAuthor);
            final ForumComment testForumComment = new ForumComment(testForumPost, testCommentBody, testAuthor);
            testForumUser.addComment(testForumPost, testForumComment.getAuthor(), testForumComment.getCommentBody());
            //When
            final ForumComment retrivedComment = testForumUser.getComment(0);
            //Then
            Assertions.assertEquals(testForumComment, retrivedComment);
        }

        @DisplayName("when use removeComment() method and given as a parameter comment not exist, used method return false")
        @Test
        void testRemoveCommentNotExisting() {
            System.out.println("Test Remove Post Not Existing");
            //Given
            final String testName = "testName";
            final String testRealName = "testRealName";
            final String testPostBody = "testPostBody";
            final String testAuthor = "testAuthor";
            final String testCommentBody = "testCommentBody";
            final ForumUser testForumUser = new ForumUser(testName, testRealName);
            final ForumPost testForumPost = new ForumPost(testPostBody, testAuthor);
            final ForumComment testForumComment = new ForumComment(testForumPost, testCommentBody, testAuthor);
            //When
            final boolean result = testForumUser.removeComment(testForumComment);
            //Then
            Assertions.assertFalse(result);
        }

        @DisplayName("when use removeComment method and given as a parameter comment exist, used method return true and comment is removed")
        @Test
        void testRemoveComment() {
            System.out.println("Test Remove Comment");
            //Given
            final String testName = "testName";
            final String testRealName = "testRealName";
            final String testPostBody = "testPostBody";
            final String testAuthor = "testAuthor";
            final String testCommentBody = "testCommentBody";
            final ForumUser testForumUser = new ForumUser(testName, testRealName);
            final ForumPost testForumPost = new ForumPost(testPostBody, testAuthor);
            final ForumComment testForumComment = new ForumComment(testForumPost, testCommentBody, testAuthor);
            testForumUser.addComment(testForumPost, testForumComment.getAuthor(), testForumComment.getCommentBody());
            //When
            final boolean result = testForumUser.removeComment(testForumComment);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, testForumUser.getCommentQuantity());
        }
    }
}
