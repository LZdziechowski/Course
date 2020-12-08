package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuit {

    @Test
    void testLog() {
        System.out.println("Test log() method");
        //Given
        Logger logger = Logger.INSTANCE;
        //When
        logger.log("testLog");
        String result = logger.getLastLog();
        //This
        assertEquals("testLog", result);
    }
}
