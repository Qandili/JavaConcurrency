package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class MyGraph extends JPanel{
    Point line1Point1;
    Point line1Point2;
    Point line2Point1;
    Point line2Ppoint2;
    Graphics graphics;
    boolean isAbove=false;


    public MyGraph() {
        line1Point1=new Point(200,200);
        line1Point2=new Point(100,300);
        line2Point1=new Point(200,200);
        line2Ppoint2=new Point(300,300);
        UpThread upThread=new UpThread(this);
        DownThread downThread=new DownThread(this);
    }
    public void moveDown() throws InterruptedException {
        System.out.println("Move down");
        synchronized(this){
            while (isAbove){
                System.out.println("down");
                System.out.println(line1Point2);
                System.out.println(line2Ppoint2);
                if (line1Point2.y==300 || line2Ppoint2.y==300){
                    isAbove=false;
                    notifyAll();
                }
                line1Point2.y+=20;
                line2Ppoint2.y+=20;
                System.out.println(line1Point2);
                repaint();
                Thread.sleep(200);
            }
        }
    }
    public void moveUp() throws InterruptedException {
        synchronized (this){
            while (!isAbove){
                System.out.println("up");
                System.out.println(line1Point2);
                System.out.println(line2Ppoint2);
                if (line1Point2.y==-20 || line2Ppoint2.y==-20){
                    isAbove=true;
                    wait();
                }
                line1Point2.y-=20;
                line2Ppoint2.y-=20;
                System.out.println(line1Point2);
                repaint();
                Thread.sleep(200);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics=g;
        //vertical line
        g.setColor(Color.red);
        g.drawLine(line1Point1.x, line1Point1.y, line1Point2.x, line1Point2.y);

        //horizontal line
        g.setColor(Color.green);
        g.drawLine(line2Point1.x, line2Point1.y, line2Ppoint2.x, line2Ppoint2.y);
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setStroke(new BasicStroke(10));
//        g2.draw(new Line2D.Float(30, 20, 80, 90));

    }

}
