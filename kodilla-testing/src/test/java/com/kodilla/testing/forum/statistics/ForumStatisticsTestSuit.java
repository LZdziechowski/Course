package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.temporal.JulianFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
public class ForumStatisticsTestSuit {

    private int testCounter = 0;

    @Mock
    private Statistics statisticsMock;

    public List<String> generateListOfUserNames(int userNamesQuantity) {
        final List<String> userNamesList = new ArrayList<>();
        for (int i = 1; i <= userNamesQuantity; i++) {
            userNamesList.add("John" + i);
        }
        return userNamesList;
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Beginning of tests.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEech() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Test Average values of posts per user")
    class TestAverageValuesOfPostsPerUser {

        @Test
        void testAverageValuesOfPosts0Posts() {
            System.out.println("Test Average Values Of Posts 0 Posts");
            //Given
            final ForumStatistics forumStatistics = new ForumStatistics();
            forumStatistics.calculateAdvStatistics(statisticsMock);
            //when(statisticsMock.postCount()).thenReturn(0);
            //when(statisticsMock.usersNames()).thenReturn(generateListOfUserNames(5));
            //When
            final double result = forumStatistics.getAverageNumberOfPostsPerUser();
            //Then
            assertEquals(0, result);
        }

        @Test
        void testAverageValuesOfPosts1000Posts() {
            System.out.println("Test Average Values Of Posts 1000 Posts");
            //Given
            final ForumStatistics forumStatistics = new ForumStatistics();
            forumStatistics.calculateAdvStatistics(statisticsMock);
            final List<String> list = generateListOfUserNames(5);
            when(statisticsMock.postCount()).thenReturn(1000);
            when(statisticsMock.usersNames()).thenReturn(list);
            //when(statisticsMock.commentsCount()).thenReturn(10);
            //When
            final double result = forumStatistics.getAverageNumberOfPostsPerUser();
            //Then
            assertEquals(200, result);
        }
    }

    @Nested
    @DisplayName("Test Average values of comments per user")
    class TestAverageValuesOfCommentsPerUser {

    }

    @Nested
    @DisplayName("Test Average values of comments per post")
    class TestAverageValuesOfCommentsPerPost {

    }

}
