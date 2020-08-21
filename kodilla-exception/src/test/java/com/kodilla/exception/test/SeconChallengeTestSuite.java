package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeconChallengeTestSuite {

    @Test
    void shouldNotThrowAnyException(){
        // given
        SeconChallenge seconChallenge = new SeconChallenge();
        // when & then
        assertDoesNotThrow(() -> seconChallenge.probablyIWillThrowException(1,2));
    }

    @Test
    void shouldThrowThreeExceptions(){
        // given
        SeconChallenge seconChallenge = new SeconChallenge();
        // when & then
        assertAll(
                () -> assertThrows(Exception.class, () -> seconChallenge.probablyIWillThrowException(2,1.6)),
                () -> assertThrows(Exception.class, () -> seconChallenge.probablyIWillThrowException(1,1.5)),
                () -> assertThrows(Exception.class, () -> seconChallenge.probablyIWillThrowException(2.1,1))
        );
    }

}