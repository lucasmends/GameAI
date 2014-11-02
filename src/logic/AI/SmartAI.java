/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.AI;

import GUI.Board;
import java.util.Hashtable;
import jpl.Query;
import jpl.Term;
import jpl.Variable;
import logic.game.Game;
import logic.game.RoundLogic;
import model.ConcretePiece;
import model.interfaces.Hand;
import model.interfaces.Piece;
import model.interfaces.Player;

/**
 *
 * @author rafaelpaiva
 */
public class SmartAI extends PlayerAI{

    public SmartAI(Hand hand, boolean upDirection) {
	super(hand, upDirection);
    }

    @Override
    public Piece putOnBoard() {
        Variable pecaVar = new Variable("P");
	boolean possiblePlay = true;
	int[] sides = Board.getInstance().sidesPossible();
	Query movimento; 
	// ALGO AQUI PARA COLOCAR AS PEÇAS QUE AINDA NÃO FORAM JOGADAS
	Term listaInimigos = null;
	
	int menormao = 8;
	for (Player p: Game.getInstance().getPlayers()) {
	    if (!p.equals(this)) {
		if (p.remaining() < menormao)
		    menormao = p.remaining();
	    }
	}
	
	while (possiblePlay) {
	    movimento = new Query("smart", new Term[]{hand.getTerm(), listaInimigos, new jpl.Integer(sides[0]), new jpl.Integer(sides[1]), new jpl.Integer(menormao), new jpl.Integer(Game.getInstance().getNumberOfPlayers()), pecaVar});
	
	    if (movimento.hasSolution()) {
	        Hashtable resposta = movimento.oneSolution();
		Term peca = (Term)resposta.get("P");
		return new ConcretePiece(peca);
	    } else {
		possiblePlay = this.takeFromStack();
	    }
	}
	return null;
    }


    
}
