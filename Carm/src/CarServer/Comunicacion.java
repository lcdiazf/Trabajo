/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuisCarlos
 */
public class Comunicacion extends Thread {

    private DataInputStream input;
    private DataOutputStream output;
    private ObjectOutputStream Ooutput;
    private Carro player;
    private Tablero tablero;
    private int id;

    public Comunicacion(DataInputStream input, DataOutputStream output, ObjectOutputStream Ooutput, Carro player, Tablero tablero, int id) {
        this.input = input;
        this.output = output;
        this.Ooutput = Ooutput;
        this.player = player;
        this.tablero = tablero;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            boolean juego = true;
            enviarObjeto(player);
            enviarObjeto(obtenerPlayer2());
            enviarMonedas();
            

            while (juego) {
                enviarMonedas();
                enviarPuntaje();

                if (tablero.getMonedas().isEmpty()) {
                    output.writeInt(tablero.ganador());
                    juego = false;
                }
            }
        } catch (IOException ex) {
        }
    }

    private void enviarCoordenadas() {
        try {
            output.writeInt(player.getX());
            output.writeInt(player.getY());
            for (Carro a : tablero.getCars()) {
                if (!player.equals(a)) {
                    output.writeInt(a.getX());
                    output.writeInt(a.getY());
                }
            }
        } catch (IOException ex) {
        }
    }

    /* private void enviarCoordenadas(Carro p) {
        try {
            for(Carro a:tablero.getCars()){
            if(!p.equals(a)){
            output.writeInt(a.getX());
            output.writeInt(a.getY());
            }
            }
        } catch (IOException ex) {
        }
    }
     */
    private void enviarMonedas() {
        try {
            output.writeInt(tablero.getMonedas().size());
            for (Moneda m : tablero.getMonedas()) {
                Ooutput.writeObject(m);
            }
            
        } catch (IOException ex) {
        }

    }

    private void enviarPuntaje() {
        try {
            output.writeInt(player.getY());
        } catch (IOException ex) {
        }
    }

    private void enviarObjeto(Object o) {
        try {
            Ooutput.writeObject(o);
        } catch (IOException ex) {
        }

    }
    private Carro obtenerPlayer2(){
        for (Carro a : tablero.getCars()) {
                if (!player.equals(a)) {
                    return a;
                }
            }
        return null;
    }
}
