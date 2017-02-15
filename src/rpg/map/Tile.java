/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import rpg.gfx.Assets;

/**
 *
 * @author Alberto pc
 */
public class Tile {
    
    public static Tile[] tiles = new Tile[64];
    public static Tile grassTile = new GrassTile(2);
    public static Tile rockTile = new RockTile(3);
    public static Tile dirtTile = new DirtTile(0);
    public static Tile wallTile = new WallTile(1);
    public static Tile grass2Tile = new GrassTwoTile(4);
    public static Tile tallgrassTile = new TallGrassTile(5);
    public static Tile groundTile = new GroundTile(6);
    public static Tile bwfloorTile = new FloorTile(7);
    public static Tile woodTile = new WoodTile(8);
    public static Tile waterTile = new WaterTile(9);
    
    protected BufferedImage texture;
    protected final int id;
    public static int twidth = 32, theight = 32, watindex=0;
    
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        
        tiles[id] =this;
    }
    
    public int getId(){
        return id;
    }
    
    public boolean isSolid(){
        return false;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, twidth, theight, null);
    }


    
}
