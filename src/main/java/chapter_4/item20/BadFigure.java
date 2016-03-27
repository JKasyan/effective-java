package chapter_4.item20;

/**
 * Created by evgen on 18.03.16.
 */
public class BadFigure {

    enum Shape {RECTANGLE, CIRCLE}

    final Shape shape;

    double length;
    double width;

    double radius;

    BadFigure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    public double area() {
        switch (shape){
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return radius * radius * Math.PI;
            default:
                throw new AssertionError();
        }
    }
}

abstract class Figure {
    abstract double area();
}

class Rectangle extends Figure {

    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

class Square extends Rectangle {

    public Square(double length) {
        super(length, length);
    }
}

class Circle extends Figure {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return radius * radius * Math.PI;
    }
}