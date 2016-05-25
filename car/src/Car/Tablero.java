/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Estudiante
 */
public class Tablero extends JPanel implements ActionListener  {

    private javax.swing.Timer timer;
    private Carro car1;

    public Tablero() throws Exception{
        initBoard();
    }
    private void initBoard() throws Exception {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        car1 = new Carro();
        timer = new javax.swing.Timer(50, this);
        timer.start();        
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        car1.dibujar(g);
        addKeyListener(new TAdapter());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        repaint();
        car1.move();
    }
        private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            car1.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            car1.keyPressed(e);
        }
    }
}


