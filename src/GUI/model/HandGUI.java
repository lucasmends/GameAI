/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import logic.game.RoundLogic;
import logic.game.Game;
import logic.game.MediatorGame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import model.interfaces.Piece;

/**
 *
 * @author lucas
 */
public abstract class HandGUI extends JPanel {

    protected model.interfaces.Hand<Piece> hand;
    protected final List<Domino> dominos;
    protected final MediatorGame mediator = Game.getInstance();

    public HandGUI(model.interfaces.Hand<Piece> hand) {
        this.hand = hand;
        dominos = new ArrayList<>(7);
    }

    protected void piecesToDomino(boolean back) {
        if (back == false) {
            for (int i = 0; i < hand.qtdHand(); i++) {
                Piece piece = hand.show(i);
                String file = new StringBuilder("/Resources/").append(piece.getFileName()).toString();
                dominos.add(new Domino(getClass().getResource(file).getFile(), piece));
            }
        } else {
            for (int i = 0; i < hand.qtdHand(); i++) {
                Piece piece = hand.show(i);
                dominos.add(new Domino(getClass().getResource("/Resources/r-back.png").getFile(), piece));
            }
        }

    }

    protected Domino piecesToDomino(Piece piece, boolean back) {
        if (back == false) {
            String file = new StringBuilder("/Resources/").append(piece.getFileName()).toString();
            return new Domino(getClass().getResource(file).getFile(), piece);
        } else {
            return new Domino(getClass().getResource("/Resources/r-back.png").getFile(), piece);
        }
    }

    protected void removeFromHand(Domino domino) {
        remove(domino);
        dominos.remove(domino);
        revalidate();
        RoundLogic.getInstance().repaint();
    }

    public abstract void addDomino(Piece piece);

}
