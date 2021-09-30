package Figures;
import MyVector.MyVector;

class Point {
    double x, y;

    public void Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class FigureAnalog {
    Point[] points;

    public void FigureAnalog(Point[] points) {
        this.points = points;
    }

    void Print() {
        System.out.println("(" + Double.toString(points[0].x) + Double.toString(points[0].y) + ")");
        for (int i = 1; i <= points.length; i ++) {
            System.out.println(", (" + Double.toString(points[i].x) + Double.toString(points[i].y) + ")");
        }
    }

    void Move(MyVector v, double move_length) {
        for (int i = 0; i <= points.length; i ++) {

        }
    }

    double SetSquare() {
        return 0;
    }
}


class TriangleAnalog extends Figure {
    private double x1, x2, x3, y1, y2, y3;

    public Triangle(double x1, double x2, double x3, double y1, double y2, double y3){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public void Print() {
        System.out.println("(" + Double.toString(x1) + ", " + Double.toString(y1) + "), ("
                + Double.toString(x2) + ", " + Double.toString(y2) + "), ("
                + Double.toString(x3) + ", " + Double.toString(y3) + ")"   );
    }

    public void Move(MyVector v, double move_length) {
        v.vector_normalize();
        MyVector v1 = new MyVector(this.x1, this.y1).add(v.multiply(move_length));
        MyVector v2 = new MyVector(this.x2, this.y2).add(v.multiply(move_length));
        MyVector v3 = new MyVector(this.x3, this.y3).add(v.multiply(move_length));

        this.x1 = v1.getX();
        this.x2 = v2.getX();
        this.x3 = v3.getX();
        this.y1 = v1.getY();
        this.y2 = v2.getY();
        this.y3 = v3.getY();

    }

    public double SetSquare() {
        return Math.abs(.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
    }
}

class CircleAnalog extends Figure {
    private double x, y, R;

    public Circle(double x, double y, double R){
        this.x = x;
        this.y = y;
        this.R = R;
    }

    void Print() {
        System.out.println("(" + Double.toString(x) + ", " + Double.toString(y) + "), R = " + Double.toString(R));
    }

    void Move(MyVector v, double move_length) {
        v.vector_normalize();
        MyVector v1 = new MyVector(this.x, this.y).add(v.multiply(move_length));

        this.x = v1.getX();
        this.y = v1.getY();
    }

    double SetSquare() {
        return Math.PI * Math.pow(R, 2);
    }
}

class RectangleAnalog extends Figure {
    private double x1, x2, x3, x4, y1, y2, y3, y4;

    public Rectangle(double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;

        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;
    }

    public void Print() {
        System.out.println("(" + Double.toString(x1) + ", " + Double.toString(y1) + "), ("
                + Double.toString(x2) + ", " + Double.toString(y2) + "), ("
                + Double.toString(x3) + ", " + Double.toString(y3) + "), ("
                + Double.toString(x4) + ", " + Double.toString(y4) + ")");
    }

    public void Move(MyVector v, double move_length) {
        v.vector_normalize();
        MyVector v1 = new MyVector(this.x1, this.y1).add(v.multiply(move_length));
        MyVector v2 = new MyVector(this.x2, this.y2).add(v.multiply(move_length));
        MyVector v3 = new MyVector(this.x3, this.y3).add(v.multiply(move_length));
        MyVector v4 = new MyVector(this.x4, this.y4).add(v.multiply(move_length));

        this.x1 = v1.getX();
        this.x2 = v2.getX();
        this.x3 = v3.getX();
        this.x4 = v4.getX();

        this.y1 = v1.getY();
        this.y2 = v2.getY();
        this.y3 = v3.getY();
        this.y4 = v4.getY();

    }

    public double SetSquare() {
        return Math.abs(.5 * (x1 * (y2 - y4) + x2 * (y3 - y1) + x3 * (y4 - y2) + x4 * (y1 - y3)));
    }
}