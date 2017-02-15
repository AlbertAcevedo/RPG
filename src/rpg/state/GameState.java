/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.state;


import java.awt.Graphics;
import rpg.entities.Pikachu;
import rpg.entities.Player;
import rpg.game.Handler;
import rpg.map.World;

/**
 *
 * @author Alberto pc
 */
public class GameState extends State {
    private Player player;
    private Pikachu pikachu;
    private World world;
    
    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "res/worlds/world.txt");
        handler.setWorld(world);
        player = new Player(handler, 96, 96);
        pikachu = new Pikachu(handler, 81, 111, player);
    }
    @Override
    public void tick() {
        world.tick();
        player.tick();
        pikachu.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        if(pikachu.getY() > player.getY()+14){
        player.render(g);
        pikachu.render(g);
        }
        else{
        pikachu.render(g);
        player.render(g);
        }
    }
    
}
