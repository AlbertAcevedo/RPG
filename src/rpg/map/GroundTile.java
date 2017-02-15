/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.map;


import rpg.gfx.Assets;

/**
 *
 * @author Alberto pc
 */
public class GroundTile extends Tile {
    
    public GroundTile(int id) {
        super(Assets.ground, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
