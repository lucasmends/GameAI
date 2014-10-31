/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic;

import GUI.model.HandGUI;
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

    private final Hand<Piece> mao;
    private final Query ai;      
    private final MediatorGame mediator = Game.getInstance();
    private final HandGUI handGUI;
    
    public PlayerAI(Hand hand, Query ai, boolean upDirection){
        this.mao = hand;
        this.ai = ai;
        this.handGUI = new GUI.Hand.HandPlayerAI(mao, 0, upDirection);
    }
    
    
    public HandGUI getHand(){
        return this.handGUI;
    }
    
    @Override
    public void takeFromStack() {
        Piece pecaPilha = mediator.takeStack();
        if(pecaPilha != null)
            //Colocar a logica em prolog para a pilha
            ;
    }

    @Override
    public Piece putOnBoard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hand<Piece> showHand() {
        return mao;
    }
    
}
