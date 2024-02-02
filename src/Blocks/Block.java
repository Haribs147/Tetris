package Blocks;

import Main.Board;
import Main.KeyHandler;

import java.awt.*;

public abstract class Block {

    public Square[] s = new Square[4];
    public Square[] tempS = new Square[4];
    int dropCounter = 0;
    public int direction = 1;
    public void Create(Color c){
        s[0] = new Square(c);
        s[1] = new Square(c);
        s[2] = new Square(c);
        s[3] = new Square(c);
        tempS[0] = new Square(c);
        tempS[1] = new Square(c);
        tempS[2] = new Square(c);
        tempS[3] = new Square(c);
    }

    public void setXY(int x, int y){}

    public void updateXY(int direction){
        this.direction = direction;
        s[0].x = tempS[0].x;
        s[0].y = tempS[0].y;
        s[1].x = tempS[1].x;
        s[1].y = tempS[1].y;
        s[2].x = tempS[2].x;
        s[2].y = tempS[2].y;
        s[3].x = tempS[3].x;
        s[3].y = tempS[3].y;

    }

    public void position1(){}
    public void position2(){}
    public void position3(){}
    public void position4(){}


    public void update(){
        dropCounter++;
        if (dropCounter == Board.dropTime){
            s[0].y += Square.SIZE;
            s[1].y += Square.SIZE;
            s[2].y += Square.SIZE;
            s[3].y += Square.SIZE;
            dropCounter = 0;
        }
        if(KeyHandler.a){
            s[0].x -= Square.SIZE;
            s[1].x -= Square.SIZE;
            s[2].x -= Square.SIZE;
            s[3].x -= Square.SIZE;
            KeyHandler.a = false;
        }
        if(KeyHandler.d){
            s[0].x += Square.SIZE;
            s[1].x += Square.SIZE;
            s[2].x += Square.SIZE;
            s[3].x += Square.SIZE;
            KeyHandler.d = false;
        }
        if(KeyHandler.w){
            if (direction == 1)
                position2();
            else if (direction == 2)
                position3();
            else if (direction == 3)
                position4();
            else if (direction == 4)
                position1();
            KeyHandler.w = false;
        }
        if(KeyHandler.s){
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
