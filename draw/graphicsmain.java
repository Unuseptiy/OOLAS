package draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JFrame;

public class graphicsmain extends JFrame{
    public graphicsmain() {
        super("simpleApp");
        setSize(700, 600);
        setVisible(true);
    }

//    public void triangle(int x1, int y1, int x2, int y2, int x3, int y3, Graphics2D gr2d) {
//        gr2d.drawLine(x1, y1, x2, y2);
//        gr2d.drawLine(x1, y1, x3, y3);
//        gr2d.drawLine(x3, y3, x2, y2);
//    }


    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;
        gr2d.setBackground(Color.green);



//        gr2d.setPaint(Color.BLUE);
//        gr2d.drawLine(500, 50, 300, 300);

        // Рисуем многоугольник (треуголник или звезда частный случай многоугольника)
//        BasicStroke с = new BasicStroke(3); //толщина линии 3 многоугольника
//        gr2d.setStroke(с);
//        gr2d.setPaint(Color.MAGENTA);
//        Polygon j = new Polygon();
//        j.addPoint(270, 439);
//        j.addPoint(185, 400);
//        j.addPoint(100, 470);
//        j.addPoint(200, 550);
//        j.addPoint(240, 590);
//        j.addPoint(270, 539);
//        gr2d.fillPolygon(j);



//        gr2d.drawRoundRect(200, 50, 200, 300, 200, 400);

//        gr2d.setPaint(Color.YELLOW);
//        //Прямоугольник с закругленными краями
//        gr2d.drawRoundRect(500, 500, 70, 40, 10, 10);



////        // Рисуем простые линии
////        gr2d.setPaint(Color.RED);
//        int cx = 350, cy = 300, r = 50;
//        gr2d.drawLine(cx, 0, cx, cy);
//        gr2d.drawLine(0, cy, cx, cy);
//        gr2d.setPaint(Color.DARK_GRAY);
////         Фигура овал
////        gr2d.fillOval(cx, cy, r, r);
//        gr2d.drawOval(cx, cy, r, r);


////        Rotation
//        double theta = 45, cosTheta = Math.cos(theta), sinTheta = Math.sin(theta);
//        double[][] matrixData = {{cosTheta, -sinTheta}, {sinTheta, cosTheta}};









//        // Рисуем треуголник
//        int[] x = {200, 300, 250};
//        int[] y = {300, 300, 200};
//        BasicStroke c = new BasicStroke(3); //толщина линии 3 многоугольника
//        gr2d.setStroke(c);
//        gr2d.setPaint(Color.MAGENTA);
//        Polygon j = new Polygon();
//        for(int point = 0; point < 3; point ++) {
//            j.addPoint(x[point], y[point]);
//        }
//        gr2d.fillPolygon(j);











//        triangle(cx - r, cx + r + 5, cx + r, cx + r + 5, cx, cx + r + 10, gr2d);



//        // Заполненный овал
//        gr2d.fillOval(100, 50, 200, 300);
//        gr2d.setPaint(Color.pink);
//        gr2d.drawArc(100, 200, 300, 300, ABORT, ABORT);
//        // Получаем толстую линию
//        gr2d.setPaint(Color.lightGray);
//        BasicStroke p = new BasicStroke(10); //толщина линии 20
//        gr2d.setStroke(p);
//        //Овал с толстой линией
//        gr2d.drawOval(100,100,300,300);
//        gr2d.setPaint(Color.red);

//        //Получаем цветной треугольник
//        for (int i = 0; i < 30; i++) {
//            gr2d.setPaint(Color.getHSBColor(5+i*350, 5+i*100, 5+i*100));
//            gr2d.drawLine(400 + i*5, 400- i*6, 400 + i*4, 400 + i*3);
//        }
//        gr2d.clearRect(50, 40, 200, 200);
    }
}
