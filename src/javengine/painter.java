package javengine;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;

import javengine.painterClient;

public class painter extends Canvas {
    private static logger.client loggerClient = new logger.client("painter");

    public Vector<painterClient> clientList = new Vector<painterClient>();
    public void registerClient(painterClient c)
    {
        clientList.add(c);
    }

    public void paint(Graphics g)
    {
        for(int i = 0; i < clientList.size(); i++)
        {
            painterClient.code result = clientList.get(i).paint(g);
            switch(result)
            {
                case OK:
                    break;
                case BAD:
                    loggerClient.log("Error");
                    break;
                case DELETE:
                    clientList.remove(i);
                    break;
                default:
                    break;
            }
        }
    }
}