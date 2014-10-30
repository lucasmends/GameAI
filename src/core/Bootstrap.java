/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.mediator.Game;
import game.logic.HandPieces;
import game.logic.PiecesStack;
import game.logic.interfaces.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import jpl.Atom;
import jpl.Query;
import jpl.Term;
import jpl.Util;
import jpl.Variable;
import model.Piece;
import model.ConcretePiece;

/**
 *
 * @author lucas
 */
public class Bootstrap {

    private Hand handPlayer[];
    private PiecesStack stack;
    private Query domino;

    public Bootstrap(int qtdJogadores) {
        handPlayer = new HandPieces[qtdJogadores];
        stack = new PiecesStack();
        initSWI(qtdJogadores);
    }

    private void initSWI(int qtdJogadores) {
        domino = new Query("consult", new Atom(getClass().getResource("/Resources/domino.pl").getFile()));
        if (domino.hasSolution()) {
            System.out.println("Lógica carregada.");

            Variable X = new Variable("X");
            Query qpecas = new Query("iniciar_pecas", X);
            
            while (qpecas.hasMoreSolutions()) {
                Hashtable binding = qpecas.nextSolution();
                Term px = (Term) binding.get("X");
		List<Piece> lista = new ArrayList<>(Bootstrap.getPieceFromTerm(Util.listToTermArray(px)));
		int j;
                for (j = 0; j < qtdJogadores; j++) {
		    handPlayer[j] = new HandPieces(lista.subList(7*j, 7*(j+1)));
		}
		stack = new PiecesStack();
		stack.populate(lista.subList(7*j, lista.size()));
            }
        }
        
        Game.getInstance().setStack(stack);
    }

    static List<Piece> getPieceFromTerm(Term[] t) {
	List<Piece> lista = new ArrayList<>(t.length);
	for (Term elem: t) {
	    lista.add(new ConcretePiece(elem));
	}
	return lista;
    }
}
