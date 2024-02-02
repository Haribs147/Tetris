package Blocks;

import java.awt.*;

public class z2 extends Block {

    public z2() {
        Create(Color.GREEN);
    }

    @Override
    public void setXY(int x, int y) {
        //
        //    # #    0 1
        // #  #    3 2
        y = y - 30;
        s[0].x = x;
        s[0].y = y;
        s[1].x = s[0].x + Square.SIZE;
        s[1].y = y;
        s[2].x = s[0].x;
        s[2].y = y + Square.SIZE;
        s[3].x = x - Square.SIZE;
        s[3].y = s[2].y;
    }

    public void position1() {
        //
        //    # #    0 1
        // #  #    3 2
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x + Square.SIZE;
        tempS[1].y = s[0].y;
        tempS[2].x = s[0].x;
        tempS[2].y = s[0].y + Square.SIZE;
        tempS[3].x = s[0].x - Square.SIZE;
        tempS[3].y = s[0].y + Square.SIZE;
        updateXY(1);
    }

    public void position2() {
        // #    1
        // # #  0 2
        //   #    3
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x;
        tempS[1].y = s[0].y - Square.SIZE;
        tempS[2].x = s[0].x + Square.SIZE;
        tempS[2].y = s[0].y;
        tempS[3].x = s[0].x + Square.SIZE;
        tempS[3].y = s[0].y + Square.SIZE;
        updateXY(2);
    }

    public void position3() {
        //
        //    # #    0 1
        // #  #    3 2
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x + Square.SIZE;
        tempS[1].y = s[0].y;
        tempS[2].x = s[0].x;
        tempS[2].y = s[0].y + Square.SIZE;
        tempS[3].x = s[0].x - Square.SIZE;
        tempS[3].y = s[0].y + Square.SIZE;
        updateXY(3);
    }

    public void position4() {
        // #    1
        // # #  0 2
        //   #    3
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x;
        tempS[1].y = s[0].y - Square.SIZE;
        tempS[2].x = s[0].x + Square.SIZE;
        tempS[2].y = s[0].y;
        tempS[3].x = s[0].x + Square.SIZE;
        tempS[3].y = s[0].y + Square.SIZE;
        updateXY(4);
    }
}

