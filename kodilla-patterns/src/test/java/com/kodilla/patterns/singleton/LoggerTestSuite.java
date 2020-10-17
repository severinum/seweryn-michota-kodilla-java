package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void setUpLogger(){
        logger = Logger.INSTANCE;
    }

    @Test
    void testIfLogWasAdded(){
        // given
        // when
        logger.log("Test log");
        // then
        assertFalse(logger.getLastLog().equals(""));
    }

    @Test
    void testLastLog(){
        // given
        // when
        logger.log("Test log");
        logger.log("New log");
        // then
        assertEquals("New log", logger.getLastLog());
    }

}