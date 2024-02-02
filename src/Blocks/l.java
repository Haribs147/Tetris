package Blocks;

import java.awt.*;

public class l extends Block{

    public l() {
        Create(Color.CYAN);
    }
    @Override
    public void setXY(int x, int y){
        // #    1
        // #    0
        // #    2
        // #    3
        s[0].x = x;
        s[0].y = y;
        s[1].x = s[0].x;
        s[1].y = y - Square.SIZE;
        s[2].x = s[0].x;
        s[2].y = y + Square.SIZE;
        s[3].x = s[0].x;
        s[3].y = y + Square.SIZE * 2;
    }
    public void position1(){
        // #    1
        // #    0
        // #    2
        // #    3
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x;
        tempS[1].y = s[0].y - Square.SIZE;
        tempS[2].x = s[0].x;
        tempS[2].y = s[0].y + Square.SIZE;
        tempS[3].x = s[0].x;
        tempS[3].y = s[0].y + Square.SIZE * 2;
        updateXY(1);
    }
    public void position2(){
        //
        // # # # #
        // 3 2 0 1
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x + Square.SIZE;
        tempS[1].y = s[0].y;
        tempS[2].x = s[0].x - Square.SIZE;
        tempS[2].y = s[0].y;
        tempS[3].x = s[0].x - Square.SIZE * 2;
        tempS[3].y = s[0].y;
        updateXY(2);
    }
    public void position3(){
        // #    1
        // #    0
        // #    2
        // #    3
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x;
        tempS[1].y = s[0].y - Square.SIZE;
        tempS[2].x = s[0].x;
        tempS[2].y = s[0].y + Square.SIZE;
        tempS[3].x = s[0].x;
        tempS[3].y = s[0].y + Square.SIZE * 2;
        updateXY(3);
    }
    public void position4(){
        //
        // # # # #
        // 3 2 0 1
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x + Square.SIZE;
        tempS[1].y = s[0].y;
        tempS[2].x = s[0].x - Square.SIZE;
        tempS[2].y = s[0].y;
        tempS[3].x = s[0].x - Square.SIZE * 2;
        tempS[3].y = s[0].y;
        updateXY(4);
    }

}
