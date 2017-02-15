/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Alberto pc
 */
public class Window {
    private JFrame JF;  
    private Canvas c;
    private String title;
    private final int width, height;
    public Window(int w, int h, String title){
    this.width = w;
    this.height = h;
    this.title = title;
    createWindow();
    }

    private void createWindow() {
        JF = new JFrame(title);
        JF.setSize(width, height);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JF.setResizable(false  );
        JF.setLocationRelativeTo(null);
        JF.setVisible(true);
        c = new Canvas();
        c.setPreferredSize(new Dimension(width,height));
        c.setMaximumSize(new Dimension(width,height));
        c.setMinimumSize(new Dimension(width,height));
        c.setFocusable(false);
        JF.add(c);
        JF.pack();
    }
    public Canvas getCanvas(){
        return c;
    }
    public JFrame getFrame(){
        return JF;
    }
}
