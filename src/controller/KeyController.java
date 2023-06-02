package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {

    public boolean upPressed, downPressed, rightPressed, leftPressed;

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_S) {
            downPressed = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_W) {
            upPressed = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_D) {
            rightPressed = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_A) {
            leftPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_S) {
            downPressed = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_W) {
            upPressed = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_D) {
            rightPressed = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_A) {
            leftPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
