/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Estudiante
 */
public class Main  {

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        
        frame.setTitle("Ejercicio Carro");
        frame.setSize(new Dimension(1024, 512));
        frame.add(new Tablero());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);   
        frame.setResizable(false);
    }
    
    
}
