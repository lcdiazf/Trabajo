/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarServer;

import java.awt.*;
import static java.awt.Color.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

/**
 *
 * @author Estudiante
 */
public class Main {

    static Tablero tablero;
    
    static DataInputStream inputA;
    static DataOutputStream outputA;
    static ObjectOutputStream OoutputA;
    static Carro JugadorA;

    static DataInputStream inputB;
    static DataOutputStream outputB;
    static ObjectOutputStream OoutputB;
    static Carro JugadorB;

    public static void main(String[] args) throws IOException, InterruptedException {
        JFrame frame = new JFrame();
        frame.setTitle("Servidor");
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        tablero = new Tablero();
        JPanel pant = new Pantalla1();
        pant.setVisible(false);

        ServerSocket server = new ServerSocket(8080);

        frame.add(pant);
        pant.setVisible(true);

        agregarJugadores(server);
        tablero.addPlayer(JugadorA);
        tablero.addPlayer(JugadorB);
        pant.setVisible(false);
        
        frame.add(tablero);
    }

    public static void agregarJugadores(ServerSocket server) throws IOException {
        Socket A = server.accept();
        inputA = new DataInputStream(A.getInputStream());
        outputA = new DataOutputStream(A.getOutputStream());
        OoutputA = new ObjectOutputStream(A.getOutputStream());
        JugadorA = new Carro(0, 0, BLUE, WHITE);
        Comunicacion ComA = new Comunicacion(inputA, outputA, OoutputA, JugadorA,tablero,1);//tablero
        ComA.start();

        System.out.println("Player 1 Conectado");
        
        Socket B = server.accept();
        inputB = new DataInputStream(B.getInputStream());
        outputB = new DataOutputStream(B.getOutputStream());
        OoutputB = new ObjectOutputStream(B.getOutputStream());
        JugadorB = new Carro(0, 200, RED, GRAY);
        Comunicacion ComB = new Comunicacion(inputB, outputB, OoutputB, JugadorB,tablero,2);//tablero
        ComB.start();
        System.out.println("Player 2 Conectado");
    }
}
