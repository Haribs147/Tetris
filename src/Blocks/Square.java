package Blocks;

import java.awt.*;

public class Square {
    public int x, y;
    public static int SIZE = 30;
    public static final int DRAWSIZE = SIZE - 4;
    public Color c;

    public Square(Color c){
        this.c = c;
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(c);
        graphics2D.fillRect(x, y, DRAWSIZE, DRAWSIZE);
    }
}
