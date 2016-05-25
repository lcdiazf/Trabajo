/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarClient;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class Tablero extends JPanel implements ActionListener {


    javax.swing.Timer timer;
    private Carro[] cars;
    private ArrayList<Moneda> monedas;
    private int i = 0;

    public Tablero(Carro a,Carro b,ArrayList<Moneda> monedas) {
        
        this.monedas= new ArrayList<>();//hice
        cars = new Carro[2];
        cars[0]=a;
        cars[1]=b;
        this.monedas=monedas;
        timer = new javax.swing.Timer(50, this);
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
        g.drawString("Jugador 1" + cars[0].getPuntaje(), 20, 20);
        g.drawString("Jugador 2" + cars[1].getPuntaje(), 20, 50);
    }

    public void addPlayer(Carro a) {
        if (cars[0] == null) {
            cars[0] = a;
        } else if (cars[1] == null) {
            cars[1] = a;
        }
    }

    public void setMonedas(ArrayList<Moneda> monedas) {
        this.monedas = monedas;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
