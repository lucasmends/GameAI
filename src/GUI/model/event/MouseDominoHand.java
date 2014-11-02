/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model.event;

import GUI.Hand.HandPlayer;
import GUI.model.Domino;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.interfaces.Player;

/**
 *
 * @author lucas
 */
public class MouseDominoHand implements MouseListener{

    private final Domino domino;
    private final Player player;
    
    public MouseDominoHand(Domino domino, Player player){
        this.domino = domino;
        this.player = player;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
       ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //System.out.println(me);
        if (domino.isActive()) {
            HandPlayer hand = (HandPlayer) player;
            hand.putOnBoard(domino);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ; //To change body of generated methods, choose Tools | Templates.
    }
    
}
