package theLengtonsAnt;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int n = 10, stepQuantity = 5;

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите размер поля: ");
//        n = scanner.nextInt();
//        System.out.println("Введите количество шагов муравья: ");
//        stepQuantity = scanner.nextInt();

        Ant ant = new Ant(5, 5, n);
//        System.out.println("x: " + ant.x + ", y: " + ant.y + ", d: " +  ant.direction.getX() + ", " + ant.direction.getY());
        for(int i = 0; i < stepQuantity; i ++) {
            ant.move();
//            System.out.println("i: " + i + ", x: " + ant.x + ", y: " + ant.y + ", d: " + ant.direction.getX() + ", " + ant.direction.getY());
        }
//        for(int i = 0; i < n; i ++){
//            for(int j = 0; j < n; j ++) {
//                System.out.print(ant.field.table[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(n);

        Graphics app = new Graphics(ant.field, n);
    }
}
