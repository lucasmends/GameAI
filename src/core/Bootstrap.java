/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import game.logic.MaoPecas;
import game.logic.PilhaPecas;
import game.logic.interfaces.*;
import java.util.Hashtable;
import jpl.Atom;
import jpl.Query;
import jpl.Term;
import jpl.Util;
import jpl.Variable;

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
                for (Term elem : Util.listToTermArray(px)) {
                    System.out.println(elem);
                }
            }
        }
    }
    
    private void adicionarMao(String peca){
        
    }
    
    private void adicionarPilha(String peca){
        
    }

}
