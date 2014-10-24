/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import game.logic.MaoPecas;
import game.logic.PilhaPecas;
import game.logic.interfaces.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import jpl.Atom;
import jpl.Query;
import jpl.Term;
import jpl.Util;
import jpl.Variable;
import model.Peca;
import model.PecaConcreta;

/**
 *
 * @author lucas
 */
public class Bootstrap {

    private Mao maoJogador[];
    private PilhaPecas pilha;
    private Query domino;

    public Bootstrap(int qtdJogadores) {
        maoJogador = new MaoPecas[qtdJogadores];
        pilha = new PilhaPecas();
        iniciarSWI(qtdJogadores);
    }

    private void iniciarSWI(int qtdJogadores) {
        domino = new Query("consult", new Atom(getClass().getResource("/Resources/domino.pl").getFile()));
        if (domino.hasSolution()) {
            System.out.println("Lógica carregada.");

            Variable X = new Variable("X");
            Query qpecas = new Query("iniciar_pecas", X);
            
            int pecasAdicionadas = 0;
            while (qpecas.hasMoreSolutions()) {
                Hashtable binding = qpecas.nextSolution();
                Term px = (Term) binding.get("X");
		List<Peca> lista = new ArrayList<>(Bootstrap.getPecaFromTerm(Util.listToTermArray(px)));
		int j;
                for (j = 0; j < qtdJogadores; j++) {
		    maoJogador[j] = new MaoPecas(lista.subList(7*j, 7*(j+1)));
		}
		pilha = new PilhaPecas();
		pilha.popular(lista.subList(7*j, lista.size()));
            }
        }
    }

    static List<Peca> getPecaFromTerm(Term[] t) {
	List<Peca> lista = new ArrayList<>(t.length);
	for (Term elem: t) {
	    lista.add(new PecaConcreta(elem));
	}
	return lista;
    }
}
