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
public class Assets {
    private static final int size = 32;
    public static BufferedImage[][] player, pikachu, water;
    public static BufferedImage dirt, grass, wall, rock, grass2, tallgrass, ground, wood, bwfloor;
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Player.png"));
        player = new BufferedImage[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                player[i][j] = sheet.crop(192 + size*j, size*i, size, size);
            }
        }
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Terrain.png"));
        dirt = sheet.crop(32,32,32,32);
        wall = sheet.crop(64,32,32,32);
        grass = sheet.crop(32,64,32,32);
        rock = sheet.crop(32,96,32,32);
        bwfloor = sheet.crop(0,32,32,32);
        grass2 = sheet.crop(0,64,32,32);
        tallgrass = sheet.crop(64,64,32,32);
        ground = sheet.crop(0,96,32,32);
        wood = sheet.crop(64,96,32,32);
        water = new BufferedImage[1][3];
        for (int i = 0; i < 3; i++) {
            water[0][i] = sheet.crop(32*i, 0, 32, 32);
        }
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/pikachu.png"));
        
        pikachu = new BufferedImage[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                pikachu[i][j] = sheet.crop(size*j, size*i, size, size);
            }
        }
    }
}
