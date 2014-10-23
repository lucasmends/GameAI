/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Hashtable;
import jpl.*;
/**
 *
 * @author lucas
 */
public class Main {
    
    public static void main(String args[]){
        Query domino = new Query("consult", new Atom("/home/rafaelpaiva/Documentos/Prolog/domino.pl"));
	
	if (domino.hasSolution()) {
	    System.out.println("Arquivo carregado com sucesso.");
	    
	    Variable X = new Variable("X");
	    Query qpecas = new Query("iniciar_pecas", X);
	    while ( qpecas.hasMoreSolutions() ) {
		Hashtable binding = qpecas.nextSolution();
		Term px = (Term) binding.get("X");
		for (Term elem: Util.listToTermArray(px))
		    System.out.println( elem );
	    }
	}
    }
}
