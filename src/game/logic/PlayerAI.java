/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic;

import GUI.Hand.HandPlayerAI;
import GUI.model.Domino;
import GUI.model.HandGUI;
import core.RoundLogic;
import core.mediator.Game;
import core.mediator.MediatorGame;
import game.logic.interfaces.Player;
import game.logic.interfaces.Hand;
import jpl.Query;
import model.Piece;

/**
 *
 * @author lucas
 */
public class PlayerAI implements Player{

    private final Hand<Piece> hand;
    private final Query ai;      
    private final MediatorGame mediator = Game.getInstance();
    private final HandPlayerAI handGUI;
    private int point;
    
    public PlayerAI(Hand hand, Query ai, boolean upDirection){
        this.hand = hand;
        this.ai = ai;
        this.handGUI = new GUI.Hand.HandPlayerAI(hand, 0, upDirection);
        this.point = 0;
        for(int i = 0; i < hand.qtdHand(); i++)
        {
            Piece piece = (Piece) hand.show(i);
            this.point += piece.getPoint();
        }
    }
    
    
    public HandGUI getHand(){
        return this.handGUI;
    }
    
    @Override
    public void takeFromStack() {
        Piece pecaPilha = mediator.takeStack();
        if(pecaPilha != null){
            //Colocar a logica em prolog para a pilha
            ;
            this.point += pecaPilha.getPoint();
            hand.add(pecaPilha);
            handGUI.addDomino(pecaPilha);
        }
        
    }

    @Override
    public Piece putOnBoard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doMove() {
        
        //handGUI.remove(putOnBoard());
        //mediator.informPiecePlaced(putOnBoard(), this);
        //RoundLogic.getInstance().nextPlayerTurn();
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
    public void piecePlaced(Piece pice){
        ;
    }

    @Override
    public int remaining() {
        return hand.qtdHand();
    }
}
