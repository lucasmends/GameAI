/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic.interfaces;

import model.Piece;

/**
 *
 * @author lucas
 */
public interface Player {

    
    public void takeFromStack();
    public Piece putOnBoard();
    public void doMove();
    
    public Hand<Piece> showHand();
    
}
