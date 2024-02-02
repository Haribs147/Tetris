package Blocks;

import java.awt.*;

public class Block {

    public Square[] s = new Square[4];;

    public void Create(Color c){
        s[0] = new Square(c);
        s[1] = new Square(c);
        s[2] = new Square(c);
        s[3] = new Square(c);
    }
}
