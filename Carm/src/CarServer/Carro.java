/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarServer;

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
    private int puntaje;
    private Color Color1;
    private Color Color2;

    public Carro(int x, int y, Color Color1, Color Color2) {
        this.x = x;
        this.y = y;
        puntaje = 0;
        this.Color1 = Color1;
        this.Color2 = Color2;
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

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    protected void dibujar(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillOval(x + 100, y + 300, 50, 50);
        g.fillOval(x + 200, y + 300, 50, 50);
        g.setColor(Color.WHITE);

        g.fillOval(x + 115, y + 315, 20, 20);
        g.fillOval(x + 215, y + 315, 20, 20);
        g.setColor(Color1);
        g.fillRect(x + 50, y + 250, 250, 50);
        g.setColor(Color2);
        g.fillRect(x + 250, y + 275, 50, 10);
        g.setColor(Color2);
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

    public Rectangle getRectangle() {
        return new Rectangle(x, y, 250, 150);
    }

    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_S:
                y += 5;
                break;
            case KeyEvent.VK_W:
                y -= 5;
                break;
            case KeyEvent.VK_A:
                x -= 5;
                break;
            case KeyEvent.VK_D:
                x += 5;
                break;
            case KeyEvent.VK_SPACE:
                y -= 200;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                y += 200;
                break;
        }
    }

    public int getPuntaje() {
        return puntaje;
    }

}
