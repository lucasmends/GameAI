/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jpl.Compound;
import jpl.Term;

/**
 *
 * @author lucas
 */
public class ConcretePiece implements Piece{

    private int lado[];
    
    
    /**
     * 
     * @param lados Vetor de tamanho 2 que contém as pontas da peca
     */
    public ConcretePiece(int lados[]){
        this.lado = new int[2];
	if (lados[0] < lados[1]) {
	    this.lado[0] = lados[0];
	    this.lado[1] = lados[1];
	} else {
	    this.lado[0] = lados[1];
	    this.lado[1] = lados[0];
	}
    }
    
    public ConcretePiece(Term pl) {
	this.lado = new int[2];
	lado[0] = pl.arg(0).intValue();
	lado[1] = pl.arg(1).intValue();
    }
    
    @Override
    public int[] values() {
        return lado;
    }

    @Override
    public Term getTerm() {
	return new Compound("peca", new Term[]{new jpl.Integer(lado[0]), new jpl.Integer(lado[1])});
    }
    
}
