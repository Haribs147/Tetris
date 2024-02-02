package Main;

import Blocks.Block;
import Blocks.L1;
import Blocks.Square;

import java.awt.*;

public class Board {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    //BLOCK
    Block block;
    final int starting_x;
    final int starting_y;

    public static int dropTime = 60;
    //ARENA
    public Board(){
        left_x = GamePanel.WIDTH/2 - WIDTH/2;
        right_x = left_x + WIDTH;
        top_y = GamePanel.HEIGHT/2 - HEIGHT/2;
        bottom_y = top_y + HEIGHT;

        starting_x = GamePanel.WIDTH/2-30;
        starting_y = top_y + Square.SIZE;
        block = new L1();
        block.setXY(starting_x, starting_y);
    }

    public void update(){
        block.update();
    }

    public void draw(Graphics2D graphics2D){
        //Main area
        graphics2D.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke(4f));
        graphics2D.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8); // -4 i +8 ¿eby obs³ugiwaæ kolizje

        //Next block
        int x = GamePanel.WIDTH - 300;
        int y = bottom_y + 8 - 200;
        graphics2D.drawRect(x, y, 200, 200);

        graphics2D.setFont(new Font("Arial", Font.BOLD, 30));
        graphics2D.drawString("NEXT", x + 60, y + 50);

        //drawing the block
        if(block != null){
            block.draw(graphics2D);
        }
    }


}
