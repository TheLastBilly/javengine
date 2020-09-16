package javengine;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.*;
import javax.swing.JFrame;

public class canvas 
{
    private int height;
    private int width;

    BufferStrategy buffer_strategy;
    Graphics graphics;
    JFrame frame;

    ColorModel color_model;
    DataBuffer data_buffer;
    SampleModel sample_model;
    WritableRaster writeale_raster;
    BufferedImage buffered_image;

    private int raw_buffer[];

    private void configure_buffer()
    {
        width = frame.getWidth();
        height = frame.getHeight();

        raw_buffer = new int[width * height];

        color_model = new DirectColorModel(24, 255, 255<<8, 255<<16);
        data_buffer = new DataBufferInt(raw_buffer, raw_buffer.length);
        sample_model = color_model.createCompatibleSampleModel(width, height);
        writeale_raster = Raster.createWritableRaster(sample_model, data_buffer, null);
        buffered_image = new BufferedImage(color_model, writeale_raster, false, null);
    }

    public canvas(int height, int width)
    {
        //Initialize bars
        this.height = height;
        this.width = width;
        
        //Initialize frame
        frame = new JFrame();
        frame.setSize(height, width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //Set buffer strategy
        frame.createBufferStrategy(1);
        buffer_strategy = frame.getBufferStrategy();
        graphics = buffer_strategy.getDrawGraphics();

        configure_buffer();
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public void setPixel(int x, int y, short r, short g, short b)
    {
        if(x >= width || y >= height)
        {return;}
        //logger.log(String.valueOf(x));
        raw_buffer[y * width + x] = (int)(r | g << 8 | b << 16);
    }

    public void paint()
    {
        //If the frame's dimentions have changed...
        if(width != frame.getWidth() || height != frame.getHeight())
        {configure_buffer();}

        graphics.drawImage(buffered_image , 0, 0, null);
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}