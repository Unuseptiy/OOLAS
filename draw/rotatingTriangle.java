//TODO: треугольники уменьшаются, можно сделать: когда они пропадут, появляется луна.
package draw;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class rotatingTriangle extends JComponent implements ActionListener {
    private double scale;
    private Color color;
    private Timer timer;
    int width = 500;
    int height = 500;
    int cx = (width - width % 2) / 2, cy = (height - height % 2) / 2;
    double[][] matrixData = new double[2][2];


    class Point {
        int x, y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public int[] matrToVecMult(double[][] matrix, int[] vector){
        int[] out = {0, 0};
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < vector.length; j ++){
                out[i] += matrix[i][j] * vector[j];
            }
        }
        return out;
    }


    class Triangle {
        Point[] points = new Point[3];
        public Triangle(Point p1, Point p2, Point p3) {
            this.points[0] = p1;
            this.points[1] = p2;
            this.points[2] = p3;
        }

//        mb this initializing is invalid; False: this initializing are valid
        public Triangle(Point[] p) {
            this.points = p;
        }

//        Question: maybe in foreach we can't change the variable;
        public Triangle rotateTraingle(Point point, double angle) {
//          calculation of rotated coordinates
            Triangle outTriangle = new Triangle(this.points);

//            for (Point p : outTriangle.points) {
//                int[] tmpVec = {p.x - point.x, p.y - point.y};
//                tmpVec = matrToVecMult(matrixData, tmpVec);
//                p.x = tmpVec[0] + point.x;
//                p.y = tmpVec[1] + point.y;
//            }

            for (int i = 0; i < outTriangle.points.length; i ++) {
                int[] tmpVec = {outTriangle.points[i].x - point.x, outTriangle.points[i].y - point.y};
                tmpVec = matrToVecMult(matrixData, tmpVec);
                outTriangle.points[i].x = tmpVec[0] + point.x;
                outTriangle.points[i].y = tmpVec[1] + point.y;
            }

            return outTriangle;
        }
    }


//    the rotation angle
    public double theta = 0;
//    the point – center of rotation
    public Point centerPoint = new Point(cx, cy);

    public Triangle initTriangle = new Triangle(new Point(cx - 10, cy - 30),
                                                new Point(cx + 10, cy - 30),
                                                new Point(cx, cy - 50));
    public Triangle[] triangles = new Triangle[8];


    public rotatingTriangle(Color color, int delay) {
        scale = 1.0;
        timer = new Timer(delay, this);
        this.color = color;
        setPreferredSize(new Dimension(500, 500));
        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);
        matrixData[0][0] = cosTheta;
        matrixData[0][1] = -sinTheta;
        matrixData[1][0] = sinTheta;
        matrixData[1][1] = cosTheta;

        triangles[0] = initTriangle;
        for (int i = 1; i < 8; i ++) {
            theta += 45 * Math.PI / 180;
            triangles[i] = triangles[i - 1].rotateTraingle(centerPoint, theta);
        }
    }


    public void start() {
        timer.start();
    }


    public void stop() {
        timer.stop();
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        g2d.setColor(Color.black);
        g2d.drawRect(0, 0, width - 1, height - 1);
        g2d.drawLine(centerPoint.x, centerPoint.y, centerPoint.x, centerPoint.y);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        g2d.scale(scale, scale);

//        painting the circle
        Ellipse2D el = new Ellipse2D.Double(cx - 25, cy - 25, 50, 50);
        g2d.fill(el);

//        calculate the rotated coordinates
//        the angle of rotation
        theta += 1 * Math.PI / 180;
//        the rotation matrix
        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);
        matrixData[0][0] = cosTheta;
        matrixData[0][1] = -sinTheta;
        matrixData[1][0] = sinTheta;
        matrixData[1][1] = cosTheta;

//here the rotation of triangles must be implemented
//        for (Triangle triangle : triangles) {
//            triangle = triangle.rotateTraingle(centerPoint, theta);
//        }

        for (int i = 0; i < triangles.length; i ++) {
            triangles[i] = triangles[i].rotateTraingle(centerPoint, theta);
        }


        // Рисуем треуголник
        BasicStroke c = new BasicStroke(3); //толщина линии 3 многоугольника
        g2d.setStroke(c);
//        g2d.setPaint(Color.MAGENTA);

//        for (Triangle triangle : triangles) {
//            Polygon j = new Polygon();
//            for (Point p : triangle.points) {
//                j.addPoint(p.x, p.y);
//            }
//            g2d.fillPolygon(j);
//        }

        for(int i = 0; i < triangles.length; i ++) {
            Polygon polygon = new Polygon();
            for (int j = 0; j < triangles[i].points.length; j ++) {
                polygon.addPoint(triangles[i].points[j].x, triangles[i].points[j].y);
            }
            g2d.fillPolygon(polygon);
        }

//        for(int point = 0; point < 3; point ++) {
//            j.addPoint(x[point], y[point]);
//        }
//        g2d.fillPolygon(j);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Moving Circle");
                JPanel panel = new JPanel();
                final rotatingTriangle rotatingTriangleGreen = new rotatingTriangle(Color.orange, 200);
                panel.add(rotatingTriangleGreen);
                frame.getContentPane().add(panel);
                final JButton button = new JButton("Start");
                button.addActionListener(new ActionListener() {
                    private boolean pulsing = false;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (pulsing) {
                            pulsing = false;
                            rotatingTriangleGreen.stop();
                            button.setText("Start");
                        } else {
                            pulsing = true;
                            rotatingTriangleGreen.start();
                            button.setText("Stop");
                        }
                    }
                });
                panel.add(button);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 550);
                frame.setVisible(true);
            }
        });
    }
}
