/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.map;

import java.awt.Graphics;
import rpg.game.Handler;
import rpg.gfx.Assets;
import rpg.utils.Utils;

/**
 *
 * @author Alberto pc
 */
public class World {
    
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    public int waterindex = 0, cont=0;
    
    public World(Handler handler, String path){
        this.handler = handler;
        loadWorld(path);
    }
    
    public void tick(){
        cont++;
        if(cont>=10){
        waterindex++;
        waterindex%=3;
        cont=0;
        }
        Tile.waterTile.texture = Assets.water[0][waterindex];
    }
    
    public void render(Graphics g){
        int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset()/Tile.twidth);
        int xEnd = (int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.twidth)+1;
        int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset()/Tile.theight);    
        int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight())/Tile.theight)+1;
        
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(y,x).render(g, (int)(x* Tile.twidth - handler.getGameCamera().getxOffset()), (int)(y*Tile.theight -handler.getGameCamera().getyOffset()));
            }
        }
        
    }
    
    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height){
            return Tile.grassTile;
        }
        
        Tile t = Tile.tiles[tiles[x][y]];
        if (t==null) {
            return Tile.dirtTile;
        }
        return t;
    }
    
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        
        tiles = new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = Utils.parseInt(tokens[x + y*width + 4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
}
