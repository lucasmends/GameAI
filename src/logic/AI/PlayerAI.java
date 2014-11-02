/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.AI;

import GUI.Hand.HandPlayerAI;
import GUI.model.Domino;
import GUI.model.HandGUI;
import java.util.List;
import logic.game.Game;
import logic.game.MediatorGame;
import model.interfaces.Player;
import model.interfaces.Hand;
import jpl.Query;
import logic.game.RoundLogic;
import model.interfaces.Piece;

/**
 *
 * @author lucas
 */
public abstract class PlayerAI implements Player {

    protected Hand<Piece> hand;
    protected MediatorGame mediator = Game.getInstance();
    protected HandPlayerAI handGUI;
    protected int point;

    public PlayerAI(Hand hand, boolean upDirection) {
        this.hand = hand;
        this.handGUI = new GUI.Hand.HandPlayerAI(hand, 0, upDirection, this);
        this.point = 0;
        for (int i = 0; i < hand.qtdHand(); i++) {
            Piece piece = (Piece) hand.show(i);
            this.point += piece.getPoint();
        }
    }

    public HandGUI getHand() {
        return this.handGUI;
    }

    @Override
    public boolean takeFromStack() {
        Piece pecaPilha = mediator.takeStack();
        if (pecaPilha != null) {
            //Colocar a logica em prolog para a pilha
            this.point += pecaPilha.getPoint();
            hand.add(pecaPilha);
            handGUI.addDomino(pecaPilha);
            return true;
        }
        return false;
    }

    @Override
    public void doMove() {
        Piece piece = putOnBoard();
        if (piece != null) {
            handGUI.remove(piece);
            mediator.informPiecePlaced(piece, this);
        }
        RoundLogic.getInstance().nextPlayerTurn();
    }

    @Override
    public Hand<Piece> showHand() {
        return hand;
    }

    @Override
    public int getPoint() {
        return this.point;
    }

    @Override
    public void piecePlaced(Piece pice) {
        ;
    }

    @Override
    public int remaining() {
        return hand.qtdHand();
    }

    @Override
    public List<Domino> getDominos() {
        return this.handGUI.getDominos();
    }

    @Override
    public void placePiece(int i) {
        ;
    }
}
