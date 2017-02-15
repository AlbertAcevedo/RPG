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
public class WoodTile extends Tile {
    
    public WoodTile(int id) {
        super(Assets.wood, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
    
}
