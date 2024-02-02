package Blocks;

import Main.Board;
import Main.KeyHandler;

import java.awt.*;

public abstract class Block {

    public Square[] s = new Square[4];;
    int dropCounter = 0;
    public void Create(Color c){
        s[0] = new Square(c);
        s[1] = new Square(c);
        s[2] = new Square(c);
        s[3] = new Square(c);
    }

    public void setXY(int x, int y){}

    public void updateXY(int direction){
    }

    public void update(){
        dropCounter++;
        if (dropCounter == Board.dropTime){
            s[0].y += Square.SIZE;
            s[1].y += Square.SIZE;
            s[2].y += Square.SIZE;
            s[3].y += Square.SIZE;
            dropCounter = 0;
        }
        if(KeyHandler.a == true){
            s[0].x -= Square.SIZE;
            s[1].x -= Square.SIZE;
            s[2].x -= Square.SIZE;
            s[3].x -= Square.SIZE;
            KeyHandler.a = false;
        }
        if(KeyHandler.d == true){
            s[0].x += Square.SIZE;
            s[1].x += Square.SIZE;
            s[2].x += Square.SIZE;
            s[3].x += Square.SIZE;
            KeyHandler.d = false;
        }
        if(KeyHandler.w == true){
             
        }
        if(KeyHandler.s == true){
            s[0].y += Square.SIZE;
            s[1].y += Square.SIZE;
            s[2].y += Square.SIZE;
            s[3].y += Square.SIZE;
            dropCounter = 0;
            KeyHandler.s = false;
        }
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(s[0].c);
        graphics2D.drawRect(s[0].x, s[0].y, Square.SIZE, Square.SIZE);
        graphics2D.drawRect(s[1].x, s[1].y, Square.SIZE, Square.SIZE);
        graphics2D.drawRect(s[2].x, s[2].y, Square.SIZE, Square.SIZE);
        graphics2D.drawRect(s[3].x, s[3].y, Square.SIZE, Square.SIZE);


    }
}
