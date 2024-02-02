package Blocks;

import java.awt.*;

public class L1 extends Block{

    public L1() {
        Create(Color.ORANGE);
    }
    @Override
    public void setXY(int x, int y){
        // #   0
        // #   1
        // # # 2  3
        s[0].x = x;
        s[0].y = y;
        s[1].x = s[0].x;
        s[1].y = y - Square.SIZE;
        s[2].x = s[0].x;
        s[2].y = y + Square.SIZE;
        s[3].x = x + Square.SIZE;
        s[3].y = s[2].y;
    }
}
