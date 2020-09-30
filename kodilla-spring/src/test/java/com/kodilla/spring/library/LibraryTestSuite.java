package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class LibraryTestSuite {

    @Autowired
    private Library library;

    @Test
    void testLoadFromDb(){
        // given
        // when
        library.loadFromDb();
        // then
        // do nothing
    }

    @Test
    void testSaveToDb(){
        // given
        // when
        library.saveToDb();
        // then
        // do nothing
    }
}
