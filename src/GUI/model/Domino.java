/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import model.interfaces.Player;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.interfaces.Piece;

/**
 *
 * @author lucas
 */
public final class Domino extends JPanel {

    private Image image;
    private final Piece piece;
    public Player player;
    private boolean active;

    public Domino(Piece piece, boolean back) {
        if (back) {
            //image = new ImageIcon(getClass().getResource("/Resources/r-back.png").getFile()).getImage();
            try {
                image = ImageIO.read(new File(getClass().getResource("/Resources/r-back.png").getFile()));
            } catch (Exception e) {
                System.out.println("Erro");
            }
        } else {
            String file = getClass().getResource(new StringBuilder("/Resources/").append(piece.getFileName()).toString()).getFile();
            try {
                image = ImageIO.read(new File(file));
            } catch (Exception e) {
                System.out.println("Erro");
            }
        }

        this.piece = piece;
        this.active = false;
        //image = new ImageIcon(file).getImage();
        setSize();
    }

    /*public Domino(Piece piece, Player player) {
     String file = new StringBuilder("/Resources/").append(piece.getFileName()).toString();
     trueImage = new ImageIcon(file).getImage();

     if (player instanceof PlayerAI) {
     image = new ImageIcon(getClass().getResource("/Resources/r-back.png").getFile()).getImage();
     } else {
     image = trueImage;
     }
     this.piece = piece;
     this.active = false;
     image = new ImageIcon(file).getImage();
     setSize();
     }*/
    
    public void setPlayer(Player player) {
        this.player = player;

    }

    public void changeImage() {
        String file = getClass().getResource(new StringBuilder("/Resources/").append(piece.getFileName()).toString()).getFile();
        try {
            image = ImageIO.read(new File(file));
        } catch (Exception e) {
            System.out.println("Erro");
        }
        setSize();
        repaint();
        //repaint(100);
    }

    public Player getPlayer() {
        return this.player;
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
    public String toString() {
        return piece.getFileName().substring(2, 11);
    }
}
