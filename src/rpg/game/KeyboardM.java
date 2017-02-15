/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Alberto pc
 */
public class KeyboardM implements KeyListener{
    private boolean[] keys;
    public int currentDirection=-1;
    public KeyboardM(){
        
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case KeyEvent.VK_UP:{
                    currentDirection=3;
                    break;
            }
            case KeyEvent.VK_LEFT:{
                    currentDirection=1;
                    break;
            }
            case KeyEvent.VK_RIGHT:{
                    currentDirection=2;
                    break;
            }
            case KeyEvent.VK_DOWN:{
                    currentDirection=0;
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case KeyEvent.VK_UP:{
                    if(currentDirection==3)
                    currentDirection=-1;
                    break;
            }
            case KeyEvent.VK_LEFT:{
                    if(currentDirection==1)
                    currentDirection=-1;
                    break;
            }
            case KeyEvent.VK_RIGHT:{
                    if(currentDirection==2)
                    currentDirection=-1;
                    break;
            }
            case KeyEvent.VK_DOWN:{
                    if(currentDirection==0)
                    currentDirection=-1;
                    break;
            }
        }
    }
    public void tick(){
    }
    public int getDirection(){
        return currentDirection;
    }
}
