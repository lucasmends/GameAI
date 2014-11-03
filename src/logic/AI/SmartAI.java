/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.AI;

import GUI.Board;
import GUI.model.Domino;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import jpl.Query;
import jpl.Term;
import jpl.Util;
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
    public synchronized Piece putOnBoard() {
        Variable pecaVar = new Variable("P");
	boolean possiblePlay = true;
	int[] sides = Board.getInstance().sidesPossible();
	Query movimento;
        List<Domino> dominosPlaced = Board.getInstance().dominosPlaced();
	Term[] pecasJogadas = new Term[dominosPlaced.size()];
	for (int i = 0; i < dominosPlaced.size(); i++) {
	    pecasJogadas[i] = dominosPlaced.get(i).getPiece().getTerm();
	}
	Term listaJogadas = Util.termArrayToList(pecasJogadas);
	
	int menormao = 8;
	for (Player p: Game.getInstance().getPlayers()) {
	    if (!p.equals(this)) {
		if (p.remaining() < menormao)
		    menormao = p.remaining();
	    }
	}
	
	while (possiblePlay) {
	    movimento = new Query("smart", new Term[]{hand.getTerm(), listaJogadas, new jpl.Integer(sides[0]), new jpl.Integer(sides[1]), new jpl.Integer(menormao), new jpl.Integer(Game.getInstance().getNumberOfPlayers()), pecaVar});
	
	    if (movimento.hasSolution()) {
	        Hashtable resposta = movimento.oneSolution();
		Term peca = (Term)resposta.get("P");
                //System.out.println(peca);
		return new ConcretePiece(peca, peca.args()[0].intValue());
	    } else {
                System.out.println("Não teve peça.");
		possiblePlay = this.takeFromStack();
	    }
	}
	return null;
    }


    
}
