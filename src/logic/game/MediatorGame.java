/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.game;

import model.interfaces.Player;
import model.interfaces.Stack;
import model.interfaces.Piece;

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
    public int[] checkFreeSlots();
    public int getNumberOfPlayers();
}
