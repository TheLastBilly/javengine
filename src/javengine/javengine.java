package javengine;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

import javengine.canvas;
import javengine.logger;

public class javengine
{
    public static void main(String[] args) 
    {
        canvas c = new canvas(200, 200);
        for(;;)
        {
            for(int x = 0; x < c.getWidth(); x++)
            {
                for(int y = 0; y < c.getHeight(); y++)
                    c.setPixel(x, y, (short)(255 % (y+1)), (short)(255 % (y+1)), (short)(255 % (y+1)));
            }
            c.paint();
        }
    }
}