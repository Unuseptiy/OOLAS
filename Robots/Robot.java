package Robots;
import MyVector.MyVector;

import java.util.Random;

public abstract class Robot implements Cost{
    double x, y;
    MyVector direction = new MyVector(1, 0);
    int price;

    public Robot(double x, double y) {
        Random rand = new Random();
        this.x = x;
        this.y = y;
        this.price = rand.nextInt(500);
    }

    public void Forward(int step_len) {
        MyVector v = new MyVector(this.x, this.y);
        v = v.add(this.direction.multiply(step_len));
        this.x = v.getX();
        this.y = v.getY();
    }

    public void Rotate(double degree) {
//        мб неправильно из-за градусов/радиан.
        double tg_alpha = this.direction.getX() / this.direction.getY();
        double alpha = Math.atan(tg_alpha);
        alpha = (alpha + degree);
        alpha %= 2 * Math.PI;
        if (alpha % 2 * Math.PI == 0) {
            return;
        }
        if (alpha % Math.PI == 0) {
            this.direction.setX(-this.direction.module());
            this.direction.setY(0);
            return;
        }
        this.direction.setX(this.direction.module() * Math.cos(alpha));
        this.direction.setY(this.direction.module() * Math.sin(alpha));
    }

    public abstract void Voice();

    public void Print() {
        System.out.println("(" + String.format("%1$.2f", this.x) + "; " + String.format("%.2f", this.y) + ")");
//        String.form
    }

    @Override
    public double GetPrice() {
        return this.price;
    }
}
