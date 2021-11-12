package theLengtonsAnt;

import draw.MyVector;

public class Ant {
    int x, y;
    Field field;
    MyVector direction = new MyVector(1, 0);


    public Ant(int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.field = new Field(n);
    }

    public void move() {
        if (field.table[this.x][this.y] == 1) {
            double tmpX = direction.getY(), tmpY = -direction.getX();
            direction.setX(tmpX);
            direction.setY(tmpY);

//            direction.setX(direction.getY());
//            direction.setY(direction.getX());
//            System.out.println("here0");
        }
        else {
            double tmpX = -direction.getY(), tmpY = direction.getX();
            direction.setX(tmpX);
            direction.setY(tmpY);
//            System.out.println("here1" + tmpX + ", " + tmpY + ", " + direction.getX() + ", " + direction.getY());
        }

        this.field.table[this.x][this.y] = 1 - this.field.table[this.x][this.y];
        this.x += direction.getX();
        this.y += direction.getY();

        if (x > field.table.length || y > field.table.length) {
            this.x -= direction.getX();
            this.y -= direction.getY();
            System.out.println("Your ant rested in border");
        }
    }
}
