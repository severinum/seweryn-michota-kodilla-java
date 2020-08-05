package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }


    @DisplayName(
            "When created SimpleUser with name." +
                    "then getUsername should return correct name"
    )

    @Test
    void testCaseUsername(){
        // given
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        // when
        String result = simpleUser.getUsername();
        String expectedResult = "theForumUser";
        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("when create SimpleUser with name, " +
            "then getUsername should return correct name"
    )
    @Test
    void testCaseRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        //When
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);
        //Then
        Assertions.assertEquals("John Smith", result);
    }

}
