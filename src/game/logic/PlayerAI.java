/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic;

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
    
    public PlayerAI(Hand mao, Query ai){
        this.mao = mao;
        this.ai = ai;
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
