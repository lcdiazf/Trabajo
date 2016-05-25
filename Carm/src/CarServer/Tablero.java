/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Estudiante
 */
public class Tablero extends JPanel implements ActionListener {

    javax.swing.Timer timer;
    private Carro[] cars;
    private ArrayList<Moneda> monedas;
    Random rnd;

    public Tablero() {
        monedas= new ArrayList<>();
        cars = new Carro[2];
        this.rnd = new Random();
        rnd.setSeed(new Date().getTime());
        timer = new javax.swing.Timer(50, this);
        for (int a = 0; a < 20; a++) {
            monedas.add(new Moneda(rnd.nextInt()%650,(rnd.nextInt()%900)+300));
        }
        timer.start();
    }

    public ArrayList<Moneda> getMonedas() {
        return monedas;
    }

    public Carro[] getCars() {
        return cars;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Carro a : cars) {
            a.dibujar(g);
        }
        g.setColor(Color.RED);
        g.drawString("Jugador 1: " + cars[0].getPuntaje(), 20, 20);
        g.drawString("Jugador 2: " + cars[1].getPuntaje(), 20, 50);
    }

    public void validarColisiones() {
        for (Carro c : cars) {
            Rectangle rc = c.getRectangle();
            for (Moneda m : monedas) {
                Rectangle rm = m.getRectangle();
                if (rc.intersects(rm)) {
                    c.setPuntaje(c.getPuntaje()+1);
                    monedas.remove(m);
                }
            }
        }
    }

    public void addPlayer(Carro a) {
        if (cars[0] == null) {
            cars[0] = a;
        } else if (cars[1] == null) {
            cars[1] = a;
        }
    }

    public int ganador(){
        if(cars[0].getPuntaje()==cars[1].getPuntaje()){
            return 0;
        }else if(cars[0].getPuntaje()<cars[1].getPuntaje()){
        return 1;
        }else{
        return 2;
        }
    }
    

    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
