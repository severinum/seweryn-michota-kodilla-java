package com.kodilla.testing.shape;

import java.util.Objects;

public class Traingle implements Shape {

    private double a;
    private double h;

    public Traingle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return 0.5 * a * h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Traingle traingle = (Traingle) o;
        return Double.compare(traingle.a, a) == 0 &&
                Double.compare(traingle.h, h) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, h);
    }
}
