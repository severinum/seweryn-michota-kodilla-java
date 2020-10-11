package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialmedia.TwitterPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTestSuite {

    @Test
    void testDefaultSharingStrategies(){
        // given
        User adam = new Millenials("Adam Smith");
        User mike = new YGeneration("Mike Mayers");
        User anna = new ZGeneration("Anna Doyle");

        // when
        String adamPostingOn = adam.sharePost();
        System.out.println("Adam posting on: " + adamPostingOn);

        String mikePostingOn = mike.sharePost();
        System.out.println("Mike posing on: " + mikePostingOn);

        String annaPosingOn = anna.sharePost();
        System.out.println("Anna posting on: " + annaPosingOn);

        // then
        assertEquals("Facebook", adamPostingOn);
        assertEquals("Twitter", mikePostingOn);
        assertEquals("Snapchat", annaPosingOn);
    }


    @Test
    void testIndividualSharingStrategy(){
        // given
        User adam = new Millenials("Adam Smith");

        // when
        String adamPostingOn = adam.sharePost();
        System.out.println("Adam posting on: " + adamPostingOn);
        adam.setSocialPublisher(new TwitterPublisher());
        adamPostingOn = adam.sharePost();
        System.out.println("Adam now posting on: " + adamPostingOn);

        // then
        assertEquals("Twitter", adamPostingOn);

    }
}