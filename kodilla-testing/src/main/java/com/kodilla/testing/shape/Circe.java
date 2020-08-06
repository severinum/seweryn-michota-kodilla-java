package com.kodilla.testing.shape;

import java.util.Objects;

public class Circe implements Shape {

    private double r;

    public Circe(double r) {
        this.r = r;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getField() {
        return Math.PI * (r * r);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circe circe = (Circe) o;
        return Double.compare(circe.r, r) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r);
    }
}
