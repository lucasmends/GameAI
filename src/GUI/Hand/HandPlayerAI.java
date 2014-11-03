/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Hand;

import GUI.Board;
import GUI.model.Domino;
import java.util.List;
import logic.game.RoundLogic;
import model.interfaces.Hand;
;
import model.interfaces.Piece;
import model.interfaces.Player;

/**
 *
 * @author lucas
 */


public class HandPlayerAI extends GUI.model.HandGUI {

    private final double angleOrientation;

    public HandPlayerAI(Hand<Piece> hand, double angleOrientation, boolean upDirection, Player player) {
        super(hand);
        this.angleOrientation = angleOrientation;

        piecesToDomino(true);

        if (upDirection) {
            setLayout(new java.awt.GridLayout(0, 2));
        }

        for (Domino domino : dominos) {
            domino.setPlayer(player);
            setOrientation(domino);
            add(domino);
        }

        this.hand = null;
    }

    private void setOrientation(Domino domino) {
        domino.rotate(angleOrientation);
    }

    @Override
    public void addDomino(Piece piece) {
        ;
    }

    public void addDomino(Piece piece, Player player) {
        Domino domino = piecesToDomino(piece, true);
        domino.setPlayer(player);
        this.dominos.add(domino);
        setOrientation(domino);
        add(domino);
    }

    public void remove(Piece piece) {
        //ThreadUtils.sleep(1500);
        for (int i = 0; i < dominos.size(); i++) {
            if (dominos.get(i).getPiece().values()[0] == piece.values()[0] && dominos.get(i).getPiece().values()[1] == piece.values()[1]) {
                Board.getInstance().addDomino(dominos.get(i));
                removeFromHand(dominos.get(i));
                break;
            }
        }
        RoundLogic.getInstance().nextPlayerTurn();
    }

    public List<Domino> getDominos() {
        return dominos;
    }

}
