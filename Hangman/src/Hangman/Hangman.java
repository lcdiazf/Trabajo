/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.sqrt;

/**
 *
 * @author Juan Camargo, Luis Diaz, Juan Huertas
 */
public class Hangman{

    public int x = 250;
    public int y = 225;
    int leftAngle = 150;
    int rightAngle = 30;
    int angle = leftAngle;
    int oscilationAngle = 1; 


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
      if (angle < rightAngle)
        oscilationAngle = 1; // oscila a la izquierda
      else if (angle > leftAngle)
        oscilationAngle = -1; // oscila a la derecha
      g.drawOval(10, 175, 50, 25);
      g.drawLine(35, 175, 35, 20);
      g.drawLine(35, 20, 160, 20);
      angle += oscilationAngle;
int x2;
      int y2;
      int x3;
      int y3;
      int x1 = 160;
      int y1 = 20;
      int radius = 20;
      int x = x1 + (int)(radius * Math.cos(Math.toRadians(angle)));
      int y = y1 + (int)(radius * Math.sin(Math.toRadians(angle)));
      double angle1;
      g.drawLine(160, 20, x, y);
      double lenght = 40;
      x = x1 + (int)(lenght * Math.cos(Math.toRadians(angle)));
      y = y1 + (int)(lenght * Math.sin(Math.toRadians(angle)));      
      g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

      lenght = 60;
      x2 = x1 + (int)(lenght * Math.cos(Math.toRadians(angle)));
      y2 = y1 + (int)(lenght * Math.sin(Math.toRadians(angle)));
      
      lenght = 120;
      x3 = x1 + (int)(lenght * Math.cos(Math.toRadians(angle)));
      y3 = y1 + (int)(lenght * Math.sin(Math.toRadians(angle)));
      
      g.drawLine(x2, y2, x3, y3);//
 
      lenght = distance(x1, y1, 120, radius + 160);     
      angle1 = Math.toDegrees(Math.asin(40.0 / lenght));
      int x4 = x1 + (int)(lenght * Math.cos(Math.toRadians(angle + angle1)));
      int y4 = y1 + (int)(lenght * Math.sin(Math.toRadians(angle + angle1)));
      
      g.drawLine(x3, y3, x4, y4);//


      angle1 = -Math.toDegrees(Math.asin(40.0 / lenght));
      x4 = x1 + (int)(lenght * Math.cos(Math.toRadians(angle + angle1)));
      y4 = y1 + (int)(lenght * Math.sin(Math.toRadians(angle + angle1)));    
      
      g.drawLine(x3, y3, x4, y4);//
    
      lenght = (int)distance(x1, y1, 100, radius + 100);
      angle1 = Math.toDegrees(Math.asin(60 / lenght));//Math.toDegrees(Math.asin(radius * Math.cos(Math.toRadians(45)) / lenght));
      x3 = x1 + (int)(lenght * Math.cos(Math.toRadians(angle + angle1)));
      y3 = y1 + (int)(lenght * Math.sin(Math.toRadians(angle + angle1)));           
     
      g.drawLine(x2, y2, x3, y3);//
      
   
      lenght = (int)distance(x1, y1, 220, radius + 100);
      angle1 = - Math.toDegrees(Math.asin(60 / lenght));
      x3 = x1 + (int)(lenght * Math.cos(Math.toRadians(angle + angle1)));
      y3 = y1 + (int)(lenght * Math.sin(Math.toRadians(angle + angle1))); 
      
      g.drawLine(x2, y2, x3, y3);//   

    }





    public static double distance(double x1, double y1, double x2, double y2) {
      return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
    
}
