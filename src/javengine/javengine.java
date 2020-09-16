package javengine;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

import javengine.canvas;

public class javengine
{
    public static void main(String[] args) 
    {
        canvas c = new canvas(200, 200);
        for(;;)
        {
            for(int i = 0; i < 199; i++)
            {
                c.setPixel(i, i, 255, 255, 255);
            }
            c.paint();
        }
    }
}