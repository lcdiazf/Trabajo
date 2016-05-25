/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarClient;

import static java.awt.Color.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class Main {

    static DataInputStream input;
    static DataOutputStream output;
    static ObjectOutputStream Ooutput;
    static Carro Jugador;
    static JFrame frame;
    static JFrame frame2;
    static Tablero tablero;
    static Pantalla1 pant;

    public static void main(String[] args) throws IOException, InterruptedException {
        frame = new JFrame();
         pant = new Pantalla1();
        frame.setTitle("Cliente");
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(pant);
        //frame.add(tablero);
    }

    public static boolean conectar(String ip, int port) throws ClassNotFoundException {
        try {
            Socket socket = new Socket(ip, port);
            Comunicacion com = new Comunicacion(socket);
            com.start();
            System.out.println("Conectado");
            frame.remove(pant);
            tablero=com.getTablero();
            JOptionPane.showMessageDialog(null, "Conectado exitosamente");
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

}
