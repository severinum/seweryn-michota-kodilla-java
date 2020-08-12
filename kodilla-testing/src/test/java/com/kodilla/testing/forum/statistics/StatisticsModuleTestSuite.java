package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatisticsModuleTestSuite {

    @Mock
    private Statistics statisticsMock;


    // generate list of users
    private List<String> generateUsernamesList(int size){
        List<String> userNames = new ArrayList<>();
        if(size <=0) return userNames;
        for(int i=1; i<=size; i++){
            userNames.add("User_"+i);
        }
        return userNames;
    }

    @BeforeEach
    public void init(){
        // no idea what to add here Pawel, maybe you can help me out ? Regards
        // each test need a bid different values received from the stat. mock
        // help if there is anything to add here.
    }

    @Nested
    @DisplayName("Testing Posts")
    class TestingPosts {
        @Test
        public void testWhenPostCountIsZero(){
            // given
            StatisticsModule statisticsModule = new StatisticsModule();
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(generateUsernamesList(10));
            when(statisticsMock.commentsCount()).thenReturn(0);
            statisticsModule.calculateAdvStatistics(statisticsMock);
            // when
            int postCount = statisticsModule.getPostsCount();
            double avgUserCommnets = statisticsModule.getAvgUserComments();
            double avgPostCommnets = statisticsModule.getAvgPostComments();
            // then
            assertEquals(0, postCount);
            assertEquals(0, avgUserCommnets, 0.01);
            assertEquals(0, avgPostCommnets, 0.01);
        }

        @Test
        public void testWhenPostCountIs100(){
            // given
            StatisticsModule statisticsModule = new StatisticsModule();
            when(statisticsMock.postsCount()).thenReturn(100);
            when(statisticsMock.usersNames()).thenReturn(generateUsernamesList(10));
            when(statisticsMock.commentsCount()).thenReturn(50);
            statisticsModule.calculateAdvStatistics(statisticsMock);
            // when
            int postCount = statisticsModule.getPostsCount();
            double avgUserComments = statisticsModule.getAvgUserComments();
            double avgPostComments = statisticsModule.getAvgPostComments();
            // then
            assertEquals(100, postCount);
            assertEquals(5.0, avgUserComments, 0.01);
            assertEquals(0.5, avgPostComments, 0.01);
        }
    }



    @Nested
    @DisplayName("Testing Comments")
    class TestingComments {
        @Test
        public void testWhenCommentsCountIsZero() {
            // given
            StatisticsModule statisticsModule = new StatisticsModule();
            when(statisticsMock.postsCount()).thenReturn(100);
            when(statisticsMock.usersNames()).thenReturn(generateUsernamesList(10));
            when(statisticsMock.commentsCount()).thenReturn(0);
            statisticsModule.calculateAdvStatistics(statisticsMock);
            // when
            int postCount = statisticsModule.getPostsCount();
            double avgUserComments = statisticsModule.getAvgUserComments();
            double avgPostComments = statisticsModule.getAvgPostComments();
            // then
            assertEquals(100, postCount);
            assertEquals(0, avgUserComments, 0.01);
            assertEquals(0, avgPostComments, 0.01);
        }

        @Test
        public void testWhenCommentsCountIsLowerTanPostsCount() {
            // given
            StatisticsModule statisticsModule = new StatisticsModule();
            when(statisticsMock.postsCount()).thenReturn(100);
            when(statisticsMock.usersNames()).thenReturn(generateUsernamesList(10));
            when(statisticsMock.commentsCount()).thenReturn(10);
            statisticsModule.calculateAdvStatistics(statisticsMock);
            // when
            int postCount = statisticsModule.getPostsCount();
            double avgUserComments = statisticsModule.getAvgUserComments();
            double avgPostComments = statisticsModule.getAvgPostComments();
            // then
            assertEquals(100, postCount);
            assertEquals(1, avgUserComments, 0.01);
            assertEquals(0.1, avgPostComments, 0.01);
        }

        @Test
        public void testWhenCommentsCountIsHigherTanPostsCount() {
            // given
            StatisticsModule statisticsModule = new StatisticsModule();
            when(statisticsMock.postsCount()).thenReturn(100);
            when(statisticsMock.usersNames()).thenReturn(generateUsernamesList(10));
            when(statisticsMock.commentsCount()).thenReturn(1000);
            statisticsModule.calculateAdvStatistics(statisticsMock);
            // when
            int postCount = statisticsModule.getPostsCount();
            int commentsCount = statisticsModule.getCommentsCount();
            double avgUserComments = statisticsModule.getAvgUserComments();
            double avgPostComments = statisticsModule.getAvgPostComments();
            // then
            assertEquals(100, postCount);
            assertEquals(1000, commentsCount);
            assertEquals(100, avgUserComments, 0.01);
            assertEquals(10, avgPostComments, 0.01);
        }
    }


    @Nested
    @DisplayName("Testing Users")
    class TestingUsers {
        @Test
        public void testWhenUsersCountIsZero() {
            // given
            StatisticsModule statisticsModule = new StatisticsModule();
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(generateUsernamesList(0));
            when(statisticsMock.commentsCount()).thenReturn(0);
            statisticsModule.calculateAdvStatistics(statisticsMock);
            // when
            int usersCount = statisticsModule.getUsersCount();
            double avgUserComments = statisticsModule.getAvgUserComments();
            double avgPostComments = statisticsModule.getAvgPostComments();
            double avgUserPosts = statisticsModule.getAvgUserPosts();
            // then
            assertEquals(0, usersCount);
            assertEquals(0, avgUserComments, 0.01);
            assertEquals(0, avgPostComments, 0.01);
            assertEquals(0, avgUserPosts, 0.01);
        }

        @Test
        public void testWhenUsersCountIs100() {
            // given
            StatisticsModule statisticsModule = new StatisticsModule();
            when(statisticsMock.postsCount()).thenReturn(8);
            when(statisticsMock.usersNames()).thenReturn(generateUsernamesList(100));
            when(statisticsMock.commentsCount()).thenReturn(20);
            statisticsModule.calculateAdvStatistics(statisticsMock);
            // when
            int usersCount = statisticsModule.getUsersCount();
            double avgUserComments = statisticsModule.getAvgUserComments();
            double avgPostComments = statisticsModule.getAvgPostComments();
            double avgUserPosts = statisticsModule.getAvgUserPosts();
            // then
            assertEquals(100, usersCount);
            assertEquals(0.2, avgUserComments, 0.01);
            assertEquals(2.5, avgPostComments, 0.01);
            assertEquals(0.08, avgUserPosts, 0.01);
        }

    }



}