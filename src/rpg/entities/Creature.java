/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.entities;

import rpg.game.Handler;
import rpg.map.Tile;



/**
 *
 * @author Alberto pc
 */
public abstract class Creature extends Entity {
    public static final int DEFAULT_HEALTH = 100;
    public static final float DEFAULT_SPEED= 2.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 32, DEFAULT_CREATURE_HEIGHT = 32;                              
    protected int health;
    protected float speed, xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health= DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move(){
                 moveX();
                 moveY();
    }
    
    public void moveX(){
        if(xMove > 0 ){
        
            int tx = (int)(x + xMove + bounds.x + bounds.width) / Tile.twidth;
            if(!collisionWithTile(tx,(int)(y+bounds.y) / Tile.theight) && !collisionWithTile(tx,(int)(y+bounds.y + bounds.height) / Tile.theight)){
                x += xMove;
            }
            else{
                x = tx * Tile.twidth -bounds.x - bounds.width-1;
            }
        }
        else if(xMove < 0){
            
            int tx = (int)(x + xMove + bounds.x) / Tile.twidth;
            if(!collisionWithTile(tx,(int)(y+bounds.y) / Tile.theight) && !collisionWithTile(tx,(int)(y+bounds.y + bounds.height) / Tile.theight)){
                x += xMove;
            }
            else{
                x = tx* Tile.twidth + Tile.twidth - bounds.x;
            }
        }
    }
    
    public void moveY(){
        if (yMove < 0) {
            int ty = (int)(y + yMove + bounds.y) / Tile.theight;
            if (!collisionWithTile((int)(x + bounds.x) / Tile.twidth, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.twidth, ty)) {
                y +=yMove;
            }
            else{
                y = ty * Tile.theight + Tile.theight - bounds.y;
            }
        }else if(yMove > 0) {
            int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.theight;
            if (!collisionWithTile((int)(x + bounds.x) / Tile.twidth, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.twidth, ty)) {
                y +=yMove;
            }
            else{
                y = ty * Tile.theight - bounds.y - bounds.height - 1;
            }
        }
    }
    
    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(y, x).isSolid();
    }
    
    public int getHealth() {
        return health;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
