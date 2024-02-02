package Blocks;

import java.awt.*;

public class t extends Block {

    public t() {
        Create(Color.MAGENTA);
    }

    @Override
    public void setXY(int x, int y) {
        //
        //    #       2
        // #  #  #  1 0 3
        s[0].x = x;
        s[0].y = y;
        s[1].x = s[0].x - Square.SIZE;
        s[1].y = y;
        s[2].x = s[0].x;
        s[2].y = y - Square.SIZE;
        s[3].x = x + Square.SIZE;
        s[3].y = s[0].y;
    }

    public void position1() {
        //
        //    #       2
        // #  #  #  1 0 3
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x - Square.SIZE;
        tempS[1].y = s[0].y;
        tempS[2].x = s[0].x;
        tempS[2].y = s[0].y - Square.SIZE;
        tempS[3].x = s[0].x + Square.SIZE;
        tempS[3].y = s[0].y;
        updateXY(1);
    }

    public void position2() {
        // #    1
        // # #  0 2
        // #    3
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x;
        tempS[1].y = s[0].y - Square.SIZE;
        tempS[2].x = s[0].x + Square.SIZE;
        tempS[2].y = s[0].y;
        tempS[3].x = s[0].x;
        tempS[3].y = s[0].y + Square.SIZE;
        updateXY(2);
    }

    public void position3() {
        //
        // # # #  3 0 1
        //   #      2
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x + Square.SIZE;
        tempS[1].y = s[0].y;
        tempS[2].x = s[0].x;
        tempS[2].y = s[0].y + Square.SIZE;
        tempS[3].x = s[0].x - Square.SIZE;
        tempS[3].y = s[0].y;
        updateXY(3);
    }

    public void position4() {
        //   #    3
        // # #  2 0
        //   #    1
        tempS[0].x = s[0].x;
        tempS[0].y = s[0].y;
        tempS[1].x = s[0].x;
        tempS[1].y = s[0].y + Square.SIZE;
        tempS[2].x = s[0].x - Square.SIZE;
        tempS[2].y = s[0].y;
        tempS[3].x = s[0].x;
        tempS[3].y = s[0].y - Square.SIZE;
        updateXY(4);
    }
}

