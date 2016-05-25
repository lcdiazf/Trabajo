/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Estudiante
 */
public class Carro {

    public int x;
    public int y;
    private int moveSpeed = 1;

    public Carro() {
        x = 00;
        y = 00;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    protected void dibujar(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillOval(x + 100, y + 300, 50, 50);
        g.fillOval(x + 200, y + 300, 50, 50);
        g.setColor(Color.WHITE);
        g.fillOval(x + 115, y + 315, 20, 20);
        g.fillOval(x + 215, y + 315, 20, 20);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x + 50, y + 250, 250, 50);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x + 250, y + 275, 50, 10);
        g.setColor(Color.LIGHT_GRAY);
        Polygon p = new Polygon();
        p.addPoint(x + 100, y + 250);
        p.addPoint(x + 150, y + 200);
        p.addPoint(x + 200, y + 200);
        p.addPoint(x + 250, y + 250);
        g.fillPolygon(p);
        g.drawRect(x + 50, y + 200, 250, 150);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                moveSpeed += 1;
                break;
            case KeyEvent.VK_DOWN:
                
                moveSpeed -= 1;
                if(moveSpeed<1){
                    moveSpeed =1;
                }
                break;
            case KeyEvent.VK_SPACE:
                moveSpeed = 0;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void move() {
        if (x > (1024 - 300)) {
            x = 0;
        }

        x += moveSpeed;
    }
}
