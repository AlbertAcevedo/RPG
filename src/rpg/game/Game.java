/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.game;

import java.awt.Color;
import rpg.display.Window;
import rpg.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import rpg.gfx.GameCamera;
import rpg.state.GameState;
import rpg.state.MenuState;
import rpg.state.State;

/**
 *
 * @author Alberto pc
 */
public class Game implements Runnable {
    
    private Window window;
    private final int width, height;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    public State gameState;
    public State menuState;
    
    //KeyListener
    private KeyboardM keyManager;
    
    //Camera
    private GameCamera gameCamera;
    //Handler
    private Handler handler;
    
    public Game(int width, int height, String title){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyboardM();
    }
    public void init(){
        window = new Window(width, height, title);
        window.getFrame().addKeyListener(keyManager);
        Assets.init();
        
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0,0);
               
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(gameState);
    }
    private void tick(){
        keyManager.tick();
        if (State.getState()!=null) {
            State.getState().tick();
        }
    }
    private void render(){
        bs = window.getCanvas().getBufferStrategy();
        if(bs == null){
        window.getCanvas().createBufferStrategy(2);
        return;
        }
        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0, 0, width, width);
        // Draw here
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, width, height);
        if (State.getState()!=null) {
            State.getState().render(g);
        }
        // End drawing
        bs.show();
        g.dispose();
    }

    /**
     * 
     */
    @Override
    public void run(){     
        init();
        int fps = 60;
        double timePerTick =1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        while(running){
            now = System.nanoTime();
            delta+= (now - lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if(delta >= 1){
            tick();
            render();
            ticks++;
            delta--;
            }
            if (timer >= 1000000000) {
//            System.out.println("FPS "+ticks);
            ticks=0;
            timer=0;
        }
        }   
        stop();
    }
    public KeyboardM getKeyboardM(){
        return keyManager;
    }
    
    public GameCamera getGameCamera(){
        return gameCamera;
    }
    
    public synchronized void start(){
        if(running)return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
}
