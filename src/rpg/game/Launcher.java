/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.game;

/**
 *
 * @author Alberto pc
 */
public class Launcher {
    public static void main(String[] args) {
        Game g = new Game(800,640, "Game");
        g.start();
    }
}
