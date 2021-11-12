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

public class DVD extends JComponent implements ActionListener {
    private double scale;
    private Color color;
    private Timer timer;
    int width = 500;
    int height = 500;
//    public double x = 10;
//    public double y = 10;

//    For DVD constraints
    public double x = width - 112;
    public double y = 40;
//    For VALERA constraints
//    public double x = width - 200;
//    public double y = 40;

    public MyVector direction = new MyVector(3, 1);


    public DVD(Color color, int delay) {
        scale = 1.0;
        timer = new Timer(delay, this);
        this.color = color;
        setPreferredSize(new Dimension(500, 500));
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
        g2d.setColor(Color.black);
        g.fillRect(0, 0, width, height);
        g2d.setColor(Color.white);
        g2d.drawRect(0, 0, width - 1, height - 1);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        g2d.scale(scale, scale);

//        System.out.println(direction.getX() + " " + direction.getY() + "\n");

//        checking if the circle hit the border
        if (x <= 1) {
            System.out.println("here1.0");
            if (x + direction.getX() <= 1) {
//                the direction reflection
                double newX, newY;
                newX = -direction.getX();
                newY = direction.getY();
                direction = new MyVector(newX, newY);
                System.out.println("here1");
            }
        }
        if (y <= 40) {
            System.out.println("here2.0");
            if (y + direction.getY() <= 40) {
                double newX, newY;
                newX = direction.getX();
                newY = -direction.getY();
                direction = new MyVector(newX, newY);
                System.out.println("here2");
            }
        }
        if (x >= width - 112) {
//        if (x >= width - 200) {
            System.out.println("here3.0");
            if (x + direction.getX() >= width - 200) {
//            if (x + direction.getX() >= width - 112) {
                double newX, newY;
                newX = -direction.getX();
                newY = direction.getY();
                direction = new MyVector(newX, newY);
                System.out.println("here3");
            }
        }
        if (y >= height - 3) {
            System.out.println("here4.0");
            if (y + direction.getY() >= height - 3) {
                double newX, newY;
                newX = direction.getX();
                newY = -direction.getY();
                direction = new MyVector(newX, newY);
                System.out.println("here4");
            }
        }

//        movement in the direction
        MyVector tmpVector = new MyVector(x, y);
        tmpVector = tmpVector.add(direction);
        x = tmpVector.getX();
        y = tmpVector.getY();
        System.out.println(x + " " + y + "\n" + direction.getX() + " " + direction.getY() + "\n");
//        draw DVD-text
        g2d.setFont(new Font("Helvetica Bold", Font.BOLD, 50));
        g2d.drawString("DVD", (int) x, (int) y);
        //        draw circle
//        Ellipse2D el = new Ellipse2D.Double(x, y, 20, 20);
//        g2d.fill(el);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("bouncing Circle");
                JPanel panel = new JPanel();
                final DVD MovingCircleGreen = new DVD(Color.BLUE, 40);
                panel.add(MovingCircleGreen);
                frame.getContentPane().add(panel);
                final JButton button = new JButton("Start");
                button.addActionListener(new ActionListener() {
                    private boolean pulsing = false;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (pulsing) {
                            pulsing = false;
                            MovingCircleGreen.stop();
                            button.setText("Start");
                        } else {
                            pulsing = true;
                            MovingCircleGreen.start();
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