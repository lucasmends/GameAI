/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import GUI.Hand.HandPlayer;
import model.interfaces.Player;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.interfaces.Piece;

/**
 *
 * @author lucas
 */
public final class Domino extends JPanel implements MouseListener{

    private Image image;
    private final Piece piece;
    public Player player;
    private boolean active;

    public Domino(String file, Piece piece) {
        this.piece = piece;
        this.active = false;
        image = new ImageIcon(file).getImage();
        setSize();

        addMouseListener(this);
    }

    public Domino(String file, Piece piece, Player player) {

        this.player = player;
        this.piece = piece;
        this.active = false;
        image = new ImageIcon(file).getImage();
        setSize();
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public void rotate(double graus) {
        image = Utils.ImageTool.rotate(image, graus);
        setSize();
        repaint();
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
        if (isActive) {
            setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(170, 170, 170), 5, true));
            repaint();
        } else {
            setBorder(null);
        }
    }

    public boolean isActive() {
        return this.active;
    }

    public Piece getPiece() {
        return this.piece;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println(me);
        if (isActive()) {
            HandPlayer hand = (HandPlayer) player;
            hand.putOnBoard(this);
            this.player = null;
        }
    }

    /*public void mouseReleased(MouseEvent e) {
     if (objectWithListener.contains(e.getPoint())) {
     doClickAction();
     }
     }*/

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println(e);]
        ;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ;
    }
}
