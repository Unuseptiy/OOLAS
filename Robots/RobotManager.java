package Robots;

import java.util.Random;

public class RobotManager {
    public static void robotMove(Robot robot, int step_len, double degree) {
//        robot.Forward(7);
//        robot.Rotate(37 * (2 * Math.PI / 180));
//        robot.Forward(5);
//        robot.Voice();

        robot.Forward(step_len);
        robot.Rotate(degree * (2 * Math.PI / 180));
        Random rand = new Random();
        robot.Forward(step_len + rand.nextInt(10 - step_len));
        robot.Voice();
    }
}
