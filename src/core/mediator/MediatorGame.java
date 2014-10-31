/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.mediator;

import game.logic.interfaces.Player;
import game.logic.interfaces.Stack;
import model.Piece;

/**
 *
 * @author lucas
 */
public interface MediatorGame {
 
    
    public void addPlayer(Player player);
    public void setStack(Stack stack);
    public Piece takeStack();
    public void informPiecePlaced(Piece piece, Player player);
    public int[] checkPiecesRemainig(Player player);
}
