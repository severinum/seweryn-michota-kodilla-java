package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.execute(()-> System.out.println("This is an example tex."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);


        // String beautifier test
        System.out.println("String beautifier test");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String basicString = "Ala ma kota";
        String str1 = poemBeautifier.beautify(basicString, (str) -> "ABC " + str);
        String str2 = poemBeautifier.beautify(basicString, (str) -> str + " ABC");
        String str3 = poemBeautifier.beautify(basicString, (str) -> str.toUpperCase());
        String str4 = poemBeautifier.beautify(basicString, (str) -> str.toLowerCase());
        String str5 = poemBeautifier.beautify(basicString, (str) -> str.replace(" ", "-"));

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);

    }
}
