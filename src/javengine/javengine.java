package javengine;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

import javengine.circle;
import javengine.painter;
import javengine.painterClient;

public class javengine
{
    public static void main(String[] args) 
    {
        logger.log("started");
        logger.client main_l = new logger.client("main");
        main_l.log("log");

        JFrame frame = new JFrame("javengine");
        painter canvas = new painter();
        try
        {
            canvas.registerClient(new circle());
        }
        catch(Exception e)
        {
            logger.log(e.getMessage());
        }
        main_l.log("good here!");
        canvas.setSize(400,400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
}