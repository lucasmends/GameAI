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
public class MouseDominoBoard implements MouseListener {

    private final int self;
    private final int other;

    private final Domino[] dominos;
    private final int side;
    private final Player player;

    public MouseDominoBoard(Domino[] dominos, boolean backward, int side, Player player) {
        if (backward) {
            self = 1;
            other = 0;
        } else {
            self = 0;
            other = 1;
        }
        this.dominos = dominos;
        this.side = side;
        this.player = player;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (dominos[self].isActive()) {
            HandPlayer human = (HandPlayer) player;
            dominos[self].setActive(false);

            human.putOnBoard(dominos[self], side);

            dominos[other].setActive(false);
            dominos[other].removeMouseListener(dominos[other].getMouseListeners()[0]);

            dominos[self].removeMouseListener(dominos[self].getMouseListeners()[0]);
        }
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
