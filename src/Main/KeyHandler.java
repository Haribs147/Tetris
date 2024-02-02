package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public static boolean w,a,s,d;
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            w = true;
        }
        if (code == KeyEvent.VK_A){
            a = true;
        }
        if (code == KeyEvent.VK_S){
            s = true;
        }if (code == KeyEvent.VK_D){
            d = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
