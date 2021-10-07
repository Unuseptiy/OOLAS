package Robots;

import java.util.Random;
//import MyVector.MyVector;

public class main {
    public static void main(String[] args) {
        Random rand = new Random();

//        Dog[] dogs = new Dog[3];
//        Cat[] cats = new Cat[3];
//        double min_ = 0, max_ = 500;
//        double d_x, d_y, c_x, c_y;
//        for(int i = 0; i < 3; i ++) {
//            d_x = min_ + (max_ - min_) * rand.nextDouble();
//            d_y = min_ + (max_ - min_) * rand.nextDouble();
//            c_x = min_ + (max_ - min_) * rand.nextDouble();
//            c_y = min_ + (max_ - min_) * rand.nextDouble();
//            dogs[i] = new Dog(d_x, d_y);
//            cats[i] = new Cat(c_x, c_y);
//        }

        int robots_cnt = 6; // должно быть четным
        Robot[] robots = new Robot[robots_cnt];
        double min_ = 0, max_ = 50, x, y;
//        x, y – координаты робота
        for(int i = 0; i < robots_cnt; i ++) {
            x = min_ + (max_ - min_) * rand.nextDouble();
            y = min_ + (max_ - min_) * rand.nextDouble();
            if (i < robots_cnt / 2) {
                robots[i] = new Dog(x, y);
            }
            else {
                robots[i] = new Cat(x, y);
            }
        }

////        Test for robots array filling
//        for(int i = 0; i < robots_cnt; i++) {
//            robots[i].Print();
//        }


        int epoch = 10;
//        double[][] track = new double[epoch][robots_cnt];
        Point[][] track = new Point[epoch + 1][robots_cnt];
        int step_len;
        double degree, min_d = 0, max_d = 360;
        for(int i = 0; i < epoch; i ++) {
            for(int j = 0; j < robots_cnt; j ++) {
                track[i][j] = new Point(robots[j].x, robots[j].y);
                step_len = rand.nextInt(10);
                degree = min_d + (max_d - min_d) * rand.nextDouble();
                RobotManager.robotMove(robots[j], step_len, degree);
            }
        }
        for(int i = 0; i < robots_cnt; i++) {
            track[epoch][i] = new Point(robots[i].x, robots[i].y);
        }

////        Test for track array filling
//        for(int i = 0; i < epoch; i ++) {
//            for(int j = 0; j < robots_cnt; j ++) {
//                track[i][j].Print();
//                System.out.print(" ");
//            }
//            System.out.println();
//        }



        MyVector v;
//        x, y – координаты вектора, проведенного от i-го робота к j-ому.
        for(int i = 0; i < robots_cnt / 2; i++) {
            for(int j = robots_cnt / 2; j < robots_cnt; j++) {
                x = robots[i].x - robots[j].x;
                y = robots[i].y - robots[j].y;
                v = new MyVector(x, y);
                if (v.module() < 10) {
                    System.out.println("Dog " + Integer.toString(i) + " catch the Cat " + Integer.toString(j));
                    System.out.println("Dog trajectory:");
                    for(int e = 0; e <= epoch; e++) {
                        track[e][i].Println();
                    }
                    System.out.println("Cat trajectory:");
                    for(int e = 0; e <= epoch; e++) {
                        track[e][j].Println();
                    }
                }
            }
        }
    }
}
