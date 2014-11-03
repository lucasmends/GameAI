/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import java.awt.Dimension;
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
        for (int i = 0; i < hand.qtdHand(); i++) {
            Piece piece = hand.show(i);
            dominos.add(new Domino(piece, back));
        }

    }

    protected Domino piecesToDomino(Piece piece, boolean back) {
        return new Domino(piece, back);
    }

    protected void removeFromHand(int index) {
        Domino domino = dominos.get(index);
        remove(domino);
        dominos.remove(index);
        revalidate();
        RoundLogic.getInstance().repaint();
    }

    protected void removeFromHand(Domino domino) {
        remove(domino);
        dominos.remove(domino);
        revalidate();
        RoundLogic.getInstance().repaint();
    }

    public abstract void addDomino(Piece piece);

}
