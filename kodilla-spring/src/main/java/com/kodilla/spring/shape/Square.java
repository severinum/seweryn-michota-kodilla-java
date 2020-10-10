package com.kodilla.spring.shape;

import org.springframework.context.annotation.Bean;


public class Square implements Shape {
    @Override
    public String getShapeName() {
        return "This is a square";
    }
}
