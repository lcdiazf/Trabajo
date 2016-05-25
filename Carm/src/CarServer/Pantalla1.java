/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarServer;

import static java.awt.Color.*;
import java.awt.Font;
import java.awt.Graphics;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author LuisCarlos
 */
public class Pantalla1 extends JPanel {

    InetAddress ip;

    public Pantalla1() throws UnknownHostException {
        this.ip = InetAddress.getLocalHost();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("", 50, 50));
        g.setColor(BLUE);
        g.drawString("Esperando jugadores", (getWidth() - 400) / 2, (getHeight() - 50) / 2);
        g.setFont(new Font("", 25, 25));
        g.setColor(black);
        g.drawString("Ip:" + ip.getHostAddress(), (getWidth() - 370) / 2, (getHeight() + 25) / 2);
        g.drawString("Port: " + 8080, (getWidth() - 370) / 2, (getHeight() + 100) / 2);
    }
}
