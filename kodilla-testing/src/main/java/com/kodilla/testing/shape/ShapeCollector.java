package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;


public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<Shape>();

    public void addFigure(Shape shape){
        if(shape != null){
           shapes.add(shape);
        }
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if(shapes.contains(shape)){
            shapes.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n){
        if(n >=0 && n < shapes.size()){
            return shapes.get(n);
        }
        return null;
    }

    public String showFigures(){
        String outputStr = "";
        if(shapes.size() > 0){
            for (Shape shape: shapes){
                outputStr += shape.getShapeName() + ", ";
            }
            outputStr = outputStr.substring(0, outputStr.length() - 2); // removing last ", " at the end of the str
            return outputStr;
        }
        return null;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
