/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.AI;

import java.util.Hashtable;
import jpl.Query;
import jpl.Term;
import jpl.Variable;
import logic.game.Game;
import model.ConcretePiece;
import model.interfaces.Hand;
import model.interfaces.Piece;

/**
 *
 * @author rafaelpaiva
 */
public class DumbAI extends PlayerAI {

    public DumbAI(Hand hand, Query ai, boolean upDirection) {
	super(hand, ai, upDirection);
    }

    @Override
    public void doMove() {
	//handGUI.remove(putOnBoard());
        //mediator.informPiecePlaced(putOnBoard(), this);
        //RoundLogic.getInstance().nextPlayerTurn();
	Variable pecaVar = new Variable("P");
	int[] pontas = Game.getInstance().checkFreeSlots();
	Query movimento = new Query("dumb", new Term[]{hand.getTerm(), new jpl.Integer(pontas[0]), new jpl.Integer(pontas[1]), pecaVar});
	
	if (movimento.hasSolution()) {
	    Hashtable resposta = movimento.oneSolution();
	    Term peca = (Term)resposta.get("P");
	    Piece piece = new ConcretePiece(peca);
	}
    }
    
}
