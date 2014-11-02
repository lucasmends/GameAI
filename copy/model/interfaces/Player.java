/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import GUI.model.Domino;
import java.util.List;
import model.interfaces.Hand;

/**
 *
 * @author lucas
 */
public interface Player {

    
    public boolean takeFromStack();
    public Piece putOnBoard();
    public void doMove();
    public int getPoint();
    public int remaining();
    public void piecePlaced(Piece piece);
    public Hand<Piece> showHand();
    public List<Domino> getDominos();
    
    public void placePiece(int i);
    
}
