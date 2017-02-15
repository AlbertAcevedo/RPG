/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import rpg.game.Handler;
import rpg.gfx.Animation;
import rpg.gfx.Assets;

/**
 *
 * @author Alberto pc
 */
public class Pikachu extends Creature{
    
    private Player player;
    private final Animation animation;
    
    public Pikachu(Handler handler, float x, float y, Player player){
        super(handler, x, y, 28, 28);
        this.player=player;
        bounds.x = 12;
        bounds.y = 23;
        bounds.width = 7;
        bounds.height = 5;
        animation = new Animation(100, Assets.pikachu);
    }
    
    @Override
    public void tick() {
        animation.tick();
        followPlayer();
        move();
    }
    
    public void followPlayer(){
        xMove = 0;
        yMove = 0;
        animation.setMoving(false);
        if(x < player.x - 15){
            xMove = speed;
            animation.setMoving(true);
            animation.setDirection(2);
        }
        else if(x > player.x +15){
            xMove = -speed;
            animation.setMoving(true);
            animation.setDirection(1);
        }
        if(y < player.y-15){
            yMove = speed;
            animation.setMoving(true);
            animation.setDirection(0);
        }
        else if(y > player.y+15){
            yMove = -speed;
            animation.setMoving(true);
            animation.setDirection(3);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
    }
    
    
    private BufferedImage getCurrentAnimation(){
        return animation.getCurrentFrame();
    }
    
}
