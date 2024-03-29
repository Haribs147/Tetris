package Main;

import Blocks.Block;
import Blocks.*;
import Blocks.Square;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Board {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;
    //BLOCK
    Block block;
    Block nextBlock;
    final int starting_x;
    final int starting_y;
    public static int dropTime = 60;

    //Collisons
    public static ArrayList<Square> staticSquares = new ArrayList<>();

    //SLIDING

    //TEST
    public Block blocks[];

    //SCORING
    public int [] lines;

    //ARENA
    public Board(){
        left_x = GamePanel.WIDTH/2 - WIDTH/2;
        right_x = left_x + WIDTH;
        top_y = GamePanel.HEIGHT/2 - HEIGHT/2;
        bottom_y = top_y + HEIGHT;

        starting_x = GamePanel.WIDTH/2-30;
        starting_y = top_y + Square.SIZE;
        block = randBlock();
        block.setXY(starting_x, starting_y);
        nextBlock = randBlock();
        nextBlock.setXY(starting_x, starting_y);
        lines = new int [20];
        for (int i = 0; i<20; i++)
            lines[i] = 0;
    }

    private Block randBlock(){
        Random random = new Random();
        int random_number = random.nextInt(7) + 1;
        if(random_number == 1){
            block = new L1();
        }
        if(random_number == 2){
            block = new L2();
        }
        if(random_number == 3){
            block = new s();
        }
        if(random_number == 4){
            block = new l();
        }
        if(random_number == 5){
            block = new z1();
        }
        if(random_number == 6){
            block = new z2();
        }
        if(random_number == 7){
            block = new t();
        }
        return block;
    }

    public void update(){

        block.update();
        if (block.s[0].y == 670 || block.s[1].y == 670 || block.s[2].y == 670 || block.s[3].y == 670 || block.downCollision){
            if (block.sliding == 0) {
                block.sliding = 1;
            }
            if(block.sliding == 2) {
                staticSquares.add(block.s[0]);
                staticSquares.add(block.s[1]);
                staticSquares.add(block.s[2]);
                staticSquares.add(block.s[3]);

                deleteLines();

                block = nextBlock;
                nextBlock = randBlock();
                nextBlock.setXY(starting_x, starting_y);
            }
        }
        checkBorders();
    }

    private void deleteLines(){
        lines[ (block.s[0].y - 100) / 30 ]++;
        lines[ (block.s[1].y - 100) / 30 ]++;
        lines[ (block.s[2].y - 100) / 30 ]++;
        lines[ (block.s[3].y - 100) / 30 ]++;
        int y = 0;
        for (int i = 0; i < 20 ; i++){
            if(lines[i] == 10){
                y = i * 30 + 100;
                for(int j = staticSquares.size()-1; j >= 0; j--){
                    if (staticSquares.get(j).y == y){
                        staticSquares.remove(j);
                    }
                }
                lines[i] = 0;
                for(int j = 0; j < staticSquares.size(); j++) {
                    if (staticSquares.get(j).y < y){
                        int newY = staticSquares.get(j).y + 30;
                        staticSquares.get(j).setY(newY);
                        lines[ ( newY - 100 ) / 30 ]++;
                        lines[ (newY - 130 ) / 30 ]--;
                    }
                }
            }
        }
    }

    private void checkBorders(){
        if (block.s[0].x <= 390 || block.s[1].x <= 390 || block.s[2].x <= 390 || block.s[3].x <= 390){
            while(block.s[0].x <= 390 || block.s[1].x <= 390 || block.s[2].x <= 390 || block.s[3].x <= 390){
                block.s[0].x += 30;
                block.s[1].x += 30;
                block.s[2].x += 30;
                block.s[3].x += 30;
            }
        }

        if (block.s[0].x >= 690 || block.s[1].x >= 690 || block.s[2].x >= 690 || block.s[3].x >= 690){
            while(block.s[0].x >= 690 || block.s[1].x >= 690 || block.s[2].x >= 690 || block.s[3].x >= 690){
                block.s[0].x -= 30;
                block.s[1].x -= 30;
                block.s[2].x -= 30;
                block.s[3].x -= 30;
            }
        }
    }

    public void draw(Graphics2D graphics2D){
        //Main area
        graphics2D.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke(4f));
        graphics2D.drawRect(left_x - 4, top_y - 8, WIDTH + 8, HEIGHT + 8); // -4 i +8 �eby obs�ugiwa� kolizje tutaj by�o -8
        //Next block
        int x = GamePanel.WIDTH - 300;
        int y = bottom_y + 8 - 200;
        graphics2D.drawRect(x, y, 200, 200);

        graphics2D.setFont(new Font("Arial", Font.BOLD, 30));
        graphics2D.drawString("NEXT", x + 60, y + 50);

        //drawing the block
        if(block != null) {
            block.draw(graphics2D);
        }

        for (Square staticSquare : staticSquares) {
            staticSquare.draw(graphics2D);
        }
    }

}
