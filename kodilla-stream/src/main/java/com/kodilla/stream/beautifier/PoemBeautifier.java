package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public String beautify(String str, PoemDecorator poemDecorator){
        String beutfied = poemDecorator.decorate(str);
        return  beutfied;
    }
}
