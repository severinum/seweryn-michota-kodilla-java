package com.kodilla.testing.shape;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Adding figures tests")
    class AddingFigures {
        @Test
        public void testAddFigure(){
            // given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circe(4.0);
            // when
            shapeCollector.addFigure(shape);
            int expected = 1;
            int actual = shapeCollector.getShapes().size();
            // then
            assertEquals(expected, actual);
        }

        @Test
        public void testAddingNull(){
            // given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = null;
            // when
            shapeCollector.addFigure(shape);
            int expected = 0;
            int actual = shapeCollector.getShapes().size();
            // then
            assertEquals(expected, actual);
        }

        @Test
        public void testAddingMultipleFigures(){
            // given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circe(4.0);
            Shape square = new Square(5);
            Shape triangle = new Traingle(4, 6);
            // when
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            int expected = 3;
            int actual = shapeCollector.getShapes().size();
            // then
            assertEquals(expected, actual);
        }
    }


    @Nested
    @DisplayName("Removing figures test")
    class RemovingFigures{
        @Test
        public void testRemoveFigure(){
            // given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circe(4.0);
            shapeCollector.addFigure(circle);
            // when
            boolean actual = shapeCollector.removeFigure(circle);
            // then
            assertTrue(actual);
            assertEquals(0, shapeCollector.getShapes().size());
        }

        @Test
        public void testRemoveFigureFromEmptyList(){
            // given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circe(4.0);
            // when
            boolean actual = shapeCollector.removeFigure(circle);
            // then
            assertFalse(actual);
            assertEquals(0, shapeCollector.getShapes().size());
        }

        @Test
        public void testRemoveFigureThatDoesNotExistInList(){
            // given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circe(4.0);
            Shape square = new Square(5.0);
            Shape triangle = new Traingle(4.0, 6.0);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);

            Shape circle2 = new Circe(3.5);
            // when
            boolean actual = shapeCollector.removeFigure(circle2);
            // then
            assertFalse(actual);
            assertEquals(3, shapeCollector.getShapes().size());
        }
    }


    @Nested
    @DisplayName("Fetching figures tests")
    class FetchingFigures {
        @Test
        public void testGetFigure(){
            // given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circe(4.0);
            Shape square = new Square(5);
            Shape triangle = new Traingle(4, 6);

            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            // when
            Shape actual = shapeCollector.getFigure(1);
            // then
            assertEquals(square, actual);
        }

        @Test
        public void testGetFigureWithIndexOutOfBounds(){
            // given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circe(4.0);
            Shape square = new Square(5);
            Shape triangle = new Traingle(4, 6);

            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            // when
            Shape actual = shapeCollector.getFigure(3);
            // then
            assertNull(actual);
        }
    }


    @Nested
    @DisplayName("Showing figures tests")
    class ShowingFigures {
        @Test
        public void testShowFigures(){
            // given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circe(4.0);
            Shape square = new Square(5);
            Shape triangle = new Traingle(4, 6);

            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            // when
            String actual = shapeCollector.showFigures();
            String expected = "Circle, Square, Triangle";
            // then
            assertEquals(expected, actual);

        }

        @Test
        public void testShowFiguresOnEmptyList(){
            // given
            ShapeCollector shapeCollector = new ShapeCollector();
            // when
            String actual = shapeCollector.showFigures();
            String expected = null;
            // then
            assertEquals(expected, actual);

        }
    }
}
