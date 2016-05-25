/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Juan Camargo, Luis Diaz, Juan Huertas
 */
public class Tablero extends JPanel implements ActionListener  {

    private javax.swing.Timer timer;
    private Hangman hangman;
    int delay = 100;
    public Tablero() throws Exception{
        initBoard();
    }
    private void initBoard() throws Exception {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        hangman = new Hangman();
        timer = new javax.swing.Timer(delay, new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {repaint();}});
        timer.start();        
    }
    
    protected void paintComponent(Graphics g) {
        
        
        super.paintComponent(g);
        hangman.dibujar(g);
        addKeyListener(new TAdapter());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
    public void keyPressed(KeyEvent e) {
     		switch (e.getKeyCode()) {
     			case KeyEvent.VK_DOWN: delay += 10; break;
     			case KeyEvent.VK_UP: delay -= 10;        
                        if (delay < 0)
                            delay = 10; 
                            timer.setDelay(delay); break;
     			case KeyEvent.VK_S: timer.stop(); break;
     			case KeyEvent.VK_R: timer.start(); break;
     		}
    }
    }
}


