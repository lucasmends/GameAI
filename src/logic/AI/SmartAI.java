/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.AI;

import jpl.Query;
import model.interfaces.Hand;
import model.interfaces.Piece;

/**
 *
 * @author rafaelpaiva
 */
public class SmartAI extends PlayerAI{

    public SmartAI(Hand hand, boolean upDirection) {
	super(hand, upDirection);
    }

    @Override
    public void doMove() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Piece putOnBoard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
