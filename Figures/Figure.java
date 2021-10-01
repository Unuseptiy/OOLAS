/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figure;
import myvector.MyVector;

/**
 *
 * @author student
 */
public class Figure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Triangle t = new Triangle(0, 0, 5, 0, 4, 0);
        t.Print();
        System.out.println(t.SetSquare());
        Move.Move(t, new MyVector(0, 1), 10);
        System.out.println();
        t.Print();
        
        Rectangle r = new Rectangle(0, 0, 1, 1, 0, 1, 1, 0);
        r.Print();
        System.out.println(r.SetSquare());
        Circle c = new Circle(0, 0, 10);
        c.Print();
        System.out.println(c.SetSquare());
        
        Figure[] f = new Figure[4];
        f[0] = t;
        f[1] = r;
        f[2] = c;
        f[3] = new Figure() {double a = 10; public double SetSquare(){return a * a;}};
        System.out.println(utils.SquareSum(f));
    }
    
    void Print() {}

    void Move() {}

    double SetSquare() {
        return 0;
    }

}

class Triangle extends Figure {
    public double x1, x2, x3, y1, y2, y3;

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

class Circle extends Figure {
    public double x, y, R;

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

class Rectangle extends Figure {
    public double x1, x2, x3, x4, y1, y2, y3, y4;

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


class Move {
    public static void Move(Rectangle r, MyVector v, double move_length){
        v.vector_normalize();
        MyVector v1 = new MyVector(r.x1, r.y1).add(v.multiply(move_length));
        MyVector v2 = new MyVector(r.x2, r.y2).add(v.multiply(move_length));
        MyVector v3 = new MyVector(r.x3, r.y3).add(v.multiply(move_length));
        MyVector v4 = new MyVector(r.x4, r.y4).add(v.multiply(move_length));

        r.x1 = v1.getX();
        r.x2 = v2.getX();
        r.x3 = v3.getX();
        r.x4 = v4.getX();

        r.y1 = v1.getY();
        r.y2 = v2.getY();
        r.y3 = v3.getY();
        r.y4 = v4.getY();
    }
    
    public static void Move(Circle c, MyVector v, double move_length){
        v.vector_normalize();
        MyVector v1 = new MyVector(c.x, c.y).add(v.multiply(move_length));

        c.x = v1.getX();
        c.y = v1.getY();
    }
    
    public static void Move(Triangle t, MyVector v, double move_length){
        v.vector_normalize();
        MyVector v1 = new MyVector(t.x1, t.y1).add(v.multiply(move_length));
        MyVector v2 = new MyVector(t.x2, t.y2).add(v.multiply(move_length));
        MyVector v3 = new MyVector(t.x3, t.y3).add(v.multiply(move_length));

        t.x1 = v1.getX();
        t.x2 = v2.getX();
        t.x3 = v3.getX();
        t.y1 = v1.getY();
        t.y2 = v2.getY();
        t.y3 = v3.getY();

    }
}

class utils {
//    public static double SetSquare(Rectangle r) {
//        return Math.abs(.5 * (r.x1 * (r.y2 - r.y4) + r.x2 * (r.y3 - r.y1) + r.x3 * (r.y4 - r.y2) + r.x4 * (r.y1 - r.y3)));
//    }
//    
//    public static double SetSquare(Circle c) {
//        return Math.PI * Math.pow(c.R, 2);
//    }
//    
//    public static double SetSquare(Triangle t) {
//       return Math.abs(.5 * (t.x1 * (t.y2 - t.y3) + t.x2 * (t.y3 - t.y1) + t.x3 * (t.y1 - t.y2)));
//    }
    
    public static double SquareSum(Figure[] f){
        double out = 0;
        for(int i = 0; i < f.length; i ++) {
            out += f[i].SetSquare();
        }
        return out;
    }
    
}
