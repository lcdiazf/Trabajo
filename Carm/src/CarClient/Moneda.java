/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarClient;

import CarServer.*;
import java.awt.*;

/**
 *
 * @author Estudiante
 */
public class Moneda {
    int x,y;

    public Moneda(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void dibujar(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(x, y, 50, 50);
    }
    public Rectangle getRectangle(){
        return new Rectangle(x,y,50,50);
    }
}
