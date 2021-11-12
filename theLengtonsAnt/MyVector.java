package theLengtonsAnt;

public class MyVector {
    double x, y;

    public MyVector(double x, double y){
        this.x = x;
        this.y = y;
    }

    public MyVector(double x1, double y1, double x2, double y2){
        this.x = x2 - x1;
        this.y = y2 - y1;
    }

    public double module(){
        return (Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)));
    }

    public MyVector multiply(double value){
        return(new MyVector(this.x * value, this.y * value));
    }

    public MyVector add(MyVector v){
        double x = this.x + v.x;
        double y = this.y + v.y;
        return (new MyVector(x, y));
    }

    public void vector_normalize(){
        this.x = this.x / this.module();
        this.y = this.y / this.module();
    }

    public double getX(){
        return this.x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
