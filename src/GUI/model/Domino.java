/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.Piece;

/**
 *
 * @author lucas
 */
public final class Domino extends JPanel {

    private Image image;
    private final Piece piece;

    public Domino(String file, Piece piece) {
        this.piece = piece;
        image = new ImageIcon(file).getImage();
        setSize();
    }

    private void setSize() {
        Dimension d = new Dimension();
        d.width = image.getWidth(null);
        d.height = image.getHeight(null);
        setPreferredSize(d);
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 1, 1, null);
        
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
    
    public void rotate(double graus){
        image = Utils.ImageTool.rotate(image, graus);
        setSize();
        repaint();
    }
}
