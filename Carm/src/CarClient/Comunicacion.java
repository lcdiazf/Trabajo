/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author USER
 */
public class Comunicacion extends Thread{
    Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private ObjectInputStream Oinput;
    private Carro player;
    private Tablero tablero;
    private int id;

    public Comunicacion(Socket socket)  {
        this.socket = socket;
        try{
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.Oinput = new ObjectInputStream(socket.getInputStream());
        }catch (IOException e){
        }
    }
    
    @Override
    public void run(){
        try{
            
            this.player=(Carro) Oinput.readObject();
            Carro player2=(Carro) Oinput.readObject();
            ArrayList<Moneda> monedas= recibirMonedas();
            this.tablero=new Tablero(player,player2,monedas);
            //tablero.setVisible(true);
            
        }catch (IOException | ClassNotFoundException e){
        }
    }
    
    private ArrayList<Moneda> recibirMonedas(){
        ArrayList<Moneda> m=new ArrayList<>();
        try {
            int cantidad = input.readInt();
            
            for(int a=0; a<cantidad; a++){
                m.add((Moneda)Oinput.readObject());
                
            }
            
        } catch (IOException | ClassNotFoundException ex) {}
        return m;
    }
    public Tablero getTablero(){
        return this.tablero;
    }
    
}
