package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {

    public boolean upPressed, downPressed, rightPressed, leftPressed;

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            upPressed = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            upPressed = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
