/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model.event;

import GUI.Board;
import GUI.Hand.HandPlayer;
import GUI.model.Domino;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.interfaces.Player;

/**
 *
 * @author lucas
 */
public class MouseDominoHand implements MouseListener {

    private final Domino domino;
    private final Player player;
    private boolean clicked = false;

    public MouseDominoHand(Domino domino, Player player) {
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
            if (!clicked) {
                clicked = true;
                if (Board.getInstance().dominoPossibilities(domino) < 2) {
                    //System.out.println(me.toString());
                    Domino[] both = new Domino[2];
                    both[0] = Board.getInstance().corner()[0];
                    both[1] = Board.getInstance().corner()[1];
                    if (both[0].getMouseListeners() != null && both[0].getMouseListeners().length > 0) {
                        both[0].removeMouseListener(both[0].getMouseListeners()[0]);
                        both[1].removeMouseListener(both[1].getMouseListeners()[0]);
                    }
                    HandPlayer human = (HandPlayer) player;
                    human.putOnBoard(domino);
                } else {
                    if (Board.getInstance().dominosPlaced().size() < 2) {
                        HandPlayer human = (HandPlayer) player;
                        human.putOnBoard(domino);
                    } else {
                        Domino[] both = new Domino[3];
                        both[0] = Board.getInstance().corner()[0];
                        both[1] = Board.getInstance().corner()[1];
                        both[2] = domino;
                        //see if it was not selected before
                        if (both[0].getMouseListeners() != null && both[0].getMouseListeners().length > 0) {
                            both[0].removeMouseListener(both[0].getMouseListeners()[0]);
                            both[1].removeMouseListener(both[1].getMouseListeners()[0]);
                        }
                        both[0].setActive(true);
                        both[0].addMouseListener(new MouseDominoBoard(both, false, 0, player));
                        both[1].setActive(true);
                        both[1].addMouseListener(new MouseDominoBoard(both, true, 1, player));
                    }
                }
            } else {
                clicked = false;
                Domino[] both = Board.getInstance().corner();
                both[0].setActive(false);
                both[1].setActive(false);
                if (both[0].getMouseListeners() != null && both[0].getMouseListeners().length > 0) {
                    both[0].removeMouseListener(both[0].getMouseListeners()[0]);
                    both[1].removeMouseListener(both[1].getMouseListeners()[0]);
                }
            }

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
