package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    private int testCounter = 0;

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing to execute test: " + testCounter);
    }

    @Test
    void testDefaultSharingStrategies() {
        System.out.println("Test testDefaultSharingStrategies()");
        //Given
        User userFB = new Millenials("userFB");
        User userTW = new YGeneration("userTW");
        User userSC = new ZGeneration("userSC");
        //When
        String resultFB = userFB.sharePost();
        String resultTW = userTW.sharePost();
        String resultSC = userSC.sharePost();
        //Then
        assertEquals("Facebook", resultFB);
        assertEquals("Twitter", resultTW);
        assertEquals("Snapchat", resultSC);
    }

    @Test
    void testIndividualSharingStrategy() {
        System.out.println("Test testDefaultSharingStrategies()");
        //Given
        User userFB = new Millenials("userFB");
        User userTW = new YGeneration("userTW");
        User userSC = new ZGeneration("userSC");
        //When
        userFB.setSharingStrategy(new TwitterPublisher());
        String resultFB = userFB.sharePost();
        userTW.setSharingStrategy(new SnapchatPublisher());
        String resultTW = userTW.sharePost();
        userSC.setSharingStrategy(new FacebookPublisher());
        String resultSC = userSC.sharePost();
        //Then
        assertEquals("Facebook", resultSC);
        assertEquals("Twitter", resultFB);
        assertEquals("Snapchat", resultTW);
    }
}
