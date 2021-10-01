/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuretmp;
import java.util.ArrayList;
import java.util.Random;
import myvector.MyVector;

/**
 *
 * @author student
 */
public class FigureTmp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Random rand = new Random();
//        ArrayList<Point> points = new ArrayList<>();
//        for(int i = 0; i < 10; i ++){
////            Point p = new Point(rand.nextDouble(), rand.nextDouble());
//            Point p = new Point((double) 0, (double) 1);
//            points.add(p);
//        }
////        System.out.print((double)10);
//        FigureAnalog figure = new FigureAnalog(points);
//        figure.Print();
//        System.out.println();
//        figure.Move(new MyVector((double)0, (double)1), (double)10);
//        figure.Print();
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point((double)0, (double)0));
        points.add(new Point((double)0, (double)4));
        points.add(new Point((double)5, (double)0));
        
        FigureAnalog figure = new FigureAnalog(points);
        figure.Print();
        figure.SetSquare();

    }
    
}



class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY() {
        this.y = y; 
    }
}


class FigureAnalog {
    ArrayList<Point> points = new ArrayList<>();

    public FigureAnalog(ArrayList<Point> points) {
        this.points = points;
    }

    void Print() {
//        System.out.println("(" + Double.toString(points.get(0).x) + Double.toString(points.get(0).y) + ")");
        for (int i = 0; i < points.size(); i ++) {
            System.out.println("(" + Double.toString(points.get(0).getX()) + ", " +  Double.toString(points.get(0).getY()) + ")");
        }
        
    }

    void Move(MyVector v, double move_length) {
        v.vector_normalize();
        v.multiply(move_length);
        MyVector tmp_v;
        for (int i = 0; i < points.size(); i ++) {
            v = new MyVector(points.get(i).getX(), points.get(i).getY()).add(v);
            points.set(i, new Point(v.getX(), v.getY()));
        }
    }

    double SetSquare() {
        double out = (double) 0;
        for(int i = 0; i < points.size(); i ++){
            out += points.get(i).getX() * (points.get((i + 1) % points.size()).getY() - points.get((i - 1) % points.size()).getY());
        }
        return out;
    }
}


class TriangleAnalog extends FigureAnalog {
    private double x1, x2, x3, y1, y2, y3;

    public TriangleAnalog(double x1, double x2, double x3, double y1, double y2, double y3){
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

class CircleAnalog extends FigureAnalog {
    private double x, y, R;

    public CircleAnalog(double x, double y, double R){
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

class RectangleAnalog extends FigureAnalog {
    private double x1, x2, x3, x4, y1, y2, y3, y4;

    public RectangleAnalog(double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4){
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