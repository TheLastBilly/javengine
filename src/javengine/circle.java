package javengine;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class circle extends painterClient
{
    @Override
    public code paint(Graphics g) {
        g.drawOval(100, 100, 200, 200);
        return painterClient.code.OK;
    }
}