/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hangman;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Juan Camargo, Luis Diaz, Juan Huertas
 */
public class Main  {

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        
        frame.setTitle("Ejercicio Hangman");
        frame.setSize(new Dimension(400, 400));
        frame.add(new Tablero());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);   
        frame.setResizable(false);
    }
    
    
}
