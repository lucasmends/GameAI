/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.interfaces.Piece;
import jpl.Compound;
import jpl.Term;

/**
 *
 * @author lucas
 */
public class ConcretePiece implements Piece{

    private int sizes[];
    
    
    /**
     * 
     * @param lados Vetor de tamanho 2 que contém as pontas da peca
     */
    public ConcretePiece(int lados[]){
        this.sizes = new int[2];
	if (lados[0] < lados[1]) {
	    this.sizes[0] = lados[0];
	    this.sizes[1] = lados[1];
	} else {
	    this.sizes[0] = lados[1];
	    this.sizes[1] = lados[0];
	}
    }
    
    public ConcretePiece(Term pl) {
	this.sizes = new int[2];
        
 	sizes[0] = pl.args()[0].intValue();
	sizes[1] = pl.args()[1].intValue();
    }
    
    @Override
    public int[] values() {
        return sizes;
    }

    @Override
    public Term getTerm() {
	return new Compound("peca", new Term[]{new jpl.Integer(sizes[0]), new jpl.Integer(sizes[1])});
    }

    @Override
    public String getFileName() {
        return new StringBuilder("r-domino").
                append(sizes[0]).append("-").append(sizes[1]).append(".png").toString();
    }

    @Override
    public int getPoint() {
        return sizes[0] + sizes[1];
    }
    
}
