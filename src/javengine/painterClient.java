package javengine;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;

public class painterClient
{
    public static enum code
    {
        OK,
        BAD,
        DELETE
    }

    public String getErrorDescription(){ return ""; }
    public code paint(Graphics g){ return code.OK; }
}
