/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.entities;

import java.awt.Color;
import java.awt.Graphics;
import rpg.game.Handler;
import rpg.gfx.Animation;
import rpg.gfx.Assets;
import java.awt.image.BufferedImage;

/**
 *
 * @author Alberto pc
 */
public class Player extends Creature{

    private final Animation animation;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x = 10;
        bounds.y = 19;
        bounds.width = 12;
        bounds.height = 12;
        
        animation = new Animation(100, Assets.player);
    }

    @Override
    public void tick() {
        animation.tick();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    
    private void getInput(){
        xMove = 0;
        yMove = 0;
        switch(handler.getKeyboardM().getDirection()){
            case 0:{
                yMove = speed;
                animation.setMoving(true);
                animation.setDirection(0);
                break;
            }
            case 1:{
                xMove = -speed;
                animation.setMoving(true);
                animation.setDirection(1);
                break;
            }
            case 2:{
                xMove = speed;
                animation.setMoving(true);
                animation.setDirection(2);
                break;
            }
            case 3:{
                yMove = -speed;
                animation.setMoving(true);
                animation.setDirection(3);
                break;
            }
            default:
                animation.setMoving(false);
                break;
        }
    }
    

    @Override
    public void render(Graphics g) {
                g.drawImage(getCurrentAnimation(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), 32, 32, null);
//                g.setColor(Color.RED);
//                g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }
    
    private BufferedImage getCurrentAnimation(){
        return animation.getCurrentFrame();
    }
    
}
