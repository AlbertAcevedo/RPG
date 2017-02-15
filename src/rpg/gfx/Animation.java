/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Alberto pc
 */
public class Animation {
    
    private int speed, index, direction;
    private boolean moving;
    private long lastTime, timer;
    private BufferedImage[][] frames;
    
    public Animation(int speed, BufferedImage[][] frames){
        this.speed = speed;
        this.frames = frames;
        index=0;
        direction=0;
        timer=0;
        lastTime = System.currentTimeMillis();
    }
    
    public void tick(){
        timer+=System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if(moving){
        if (timer >= speed) {
            index++;
            timer=0;
            index= index%(frames[0].length);
        }
        }
        else{
            index=0;
        }
    }
    
    public BufferedImage getCurrentFrame(){
        return frames[direction][index];
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
    
    
    
}
