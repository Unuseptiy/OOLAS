package Robots;

public class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void Println() {
        System.out.println("(" + String.format("%1$.2f", this.x) + "; " + String.format("%.2f", this.y) + ")");
    }

    public void Print() {
        System.out.print("(" + String.format("%1$.2f", this.x) + "; " + String.format("%.2f", this.y) + ")");
    }
}
