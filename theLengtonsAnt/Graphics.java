package theLengtonsAnt;

import javax.swing.JFrame;
import java.awt.*;

public class Graphics extends JFrame {
    Field field;
    int n;
    
    public Graphics(Field field, int n) {
        super("simpleApp");
        setSize(500, 500);
        setVisible(true);
        this.field = field;
        this.n = n;
    }

    @Override
    public void paint(java.awt.Graphics g) {
        System.out.println(this.n);
//        Graphics2D gr2d = (Graphics2D) g;
//        gr2d.setBackground(Color.white);
//        int width = 500;
//        int height = 500;
////        gr2d.setColor(Color.white);
////        g.fillRect(0, 0, width, height);
//        gr2d.setColor(Color.black);
//        gr2d.drawRect(1, 1, width - 1, height - 1);
//
////        draw the table
////        int n = this.field.table[0].length;
//
//        int step = width / this.n;
//        System.out.println(n + ", " + step);
////        for (int i = 0; i < n; i ++) {
//////            gr2d.drawLine(step * i, 0, step * i, height);
////            for(int j = 0; j < n; j ++) {
////                if(field.table[i][j] == 1) {
////                    gr2d.fillRect(j * step, i * step, step, step);
////                }
////                else {
////                    gr2d.drawRect(j * step, i * step, step, step);
////                }
////            }
////        }
    }
}
