package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: before");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: after");
    }

    @DisplayName(
            "when create SimpleUser with realName, " +
                    "then getRealName should return real user name"
    )
    @Test
    void testCaseRealName() {
        //Given
        final String testUsername = "testUsername";
        final String testRealName = "testRealName";
        SimpleUser simpleUser = new SimpleUser(testUsername, testRealName);
        //When
        String result;
        result = simpleUser.getRealName();
        //Then
        Assertions.assertEquals(testRealName, result);
    }

    @DisplayName(
            "When created SimpleUser with name, " +
                    "then getUsername should return correct name"
    )
    @Test
    void testCaseUsername() {
        //Given
        final String testUsername = "testUsername";
        final String testRealName = "testRealName";
        SimpleUser simpleUser = new SimpleUser(testUsername, testRealName);
        //When
        String result;
        result = simpleUser.getUsername();
        //Then
        Assertions.assertEquals(testUsername, result);
    }
}
