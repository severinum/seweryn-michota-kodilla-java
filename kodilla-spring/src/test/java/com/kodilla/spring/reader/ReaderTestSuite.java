package com.kodilla.spring.reader;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReaderTestSuite {

    @Test
    void testRead(){
        // given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        Reader reader = context.getBean(Reader.class);
        // when & then
        reader.read();

        System.out.println("======== beans list ========== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ======== beans list ========== ");
    }

    @Test
    void testConditional(){
        // given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        // when
        boolean book2Exists = context.containsBean("book2");
        // then
        System.out.println("Bean book2 was found in the container : " + book2Exists);
    }

}