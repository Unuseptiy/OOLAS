package MyVector;

public class main {
    public static void main(String[] args){
        MyVector v1 = new MyVector(1, 1);
        MyVector v2 = new MyVector(2, 2, 3, 1);

        System.out.println(v1.module());

        MyVector v3 = v1.multiply(3);
        System.out.println(v3.x);
        System.out.println(v3.y);
        
        MyVector v4 = v1.add(v2);
        System.out.println(v4.x);
        System.out.println(v4.y);
    }
}