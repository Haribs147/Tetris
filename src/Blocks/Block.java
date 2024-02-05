package Blocks;

import Main.Board;
import Main.KeyHandler;

import java.awt.*;

public abstract class Block {

    public Square[] s = new Square[4];
    public Square[] tempS = new Square[4];
    int dropCounter = 0;
    public int direction = 1;

    public boolean downCollision = false;
    public boolean leftCollision = false;
    public boolean rightCollision = false;
    public boolean rotationCollision = false;

    //SLIDING
    public int sliding = 0;
    public int flag = 0;

    private int slidingCounter = 0;

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
        checkRotationCollision();
        if(rotationCollision){
            rotationCollision = false;
            return;
        }
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
        checkStaticCollision();
        //System.out.println(sliding);
        //System.out.println(downCollision);
        if (sliding == 0 || sliding == 2) {//zobaczyæ czy to nie powinno byæ ni¿ej pod if(sliding == 1)
            dropCounter++;
            if (dropCounter == Board.dropTime) {
                s[0].y += Square.SIZE;
                s[1].y += Square.SIZE;
                s[2].y += Square.SIZE;
                s[3].y += Square.SIZE;
                dropCounter = 0;
            }
            if(KeyHandler.s){
                if (!downCollision || s[0].y == 670 || s[1].y == 670 || s[2].y == 670 || s[3].y == 670) {
                    System.out.println("co");
                    s[0].y += Square.SIZE;
                    s[1].y += Square.SIZE;
                    s[2].y += Square.SIZE;
                    s[3].y += Square.SIZE;
                    dropCounter = 0;
                }
                KeyHandler.s = false;
            }
        }

        if (sliding == 1) {
            slidingCounter++;
            if (slidingCounter == 60) {
                slidingCounter = 0;
                sliding = 2;
                dropCounter = 0;
            }
        }

        if(KeyHandler.a){
            if(!leftCollision) {
                s[0].x -= Square.SIZE;
                s[1].x -= Square.SIZE;
                s[2].x -= Square.SIZE;
                s[3].x -= Square.SIZE;
            }
            leftCollision = false;
            KeyHandler.a = false;
        }
        if(KeyHandler.d){
            if (!rightCollision) {
                s[0].x += Square.SIZE;
                s[1].x += Square.SIZE;
                s[2].x += Square.SIZE;
                s[3].x += Square.SIZE;
            }
            rightCollision = false;
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
    }

    public void checkStaticCollision(){
        downCollision = false;
        for (int i = 0; i < Board.staticSquares.size();i++){
            int x = Board.staticSquares.get(i).x;
            int y = Board.staticSquares.get(i).y;
            //check down
            for (int j = 0; j < s.length; j++){
                if(s[j].x == x && s[j].y + Square.SIZE == y){
                    downCollision = true;
                    if (sliding == 1 && slidingCounter == 60)
                        sliding = 2;
                }
            }
            //check left
            for (int j = 0; j < s.length; j++){
                if(s[j].x - Square.SIZE == x  && s[j].y == y){
                    leftCollision = true;
                }
            }
            //check right
            for (int j = 0; j < s.length; j++){
                if(s[j].x + Square.SIZE == x && s[j].y == y){
                    rightCollision = true;
                }
            }
        }
    }

    public void checkRotationCollision() {
        for (int i = 0; i < Board.staticSquares.size(); i++) {
            int x = Board.staticSquares.get(i).x;
            int y = Board.staticSquares.get(i).y;

            //check rotation temp and normal
            for (int j = 0; j < s.length; j++) {
                if (tempS[j].x == x && tempS[j].y  == y) {
                    rotationCollision = true;
                }
            }
        }
    }


    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(s[0].c);
        graphics2D.drawRect(s[0].x, s[0].y, Square.DRAWSIZE, Square.DRAWSIZE);
        graphics2D.drawRect(s[1].x, s[1].y, Square.DRAWSIZE, Square.DRAWSIZE);
        graphics2D.drawRect(s[2].x, s[2].y, Square.DRAWSIZE, Square.DRAWSIZE);
        graphics2D.drawRect(s[3].x, s[3].y, Square.DRAWSIZE, Square.DRAWSIZE);
    }
}
