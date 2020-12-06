package com.kodilla.spring.forum;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ForumUserTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.printf("Beginning of tests.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All test are finished");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing to execute test: #" + testCounter);
    }

    @Test
    void testGetUsername() {
        System.out.printf("Test getUsername");
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        ForumUser forumUser = context.getBean(ForumUser.class);
        //When
        String result = forumUser.getUsername();
        //Then
        assertEquals("John Smith", result);
    }
}
