/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import model.interfaces.Piece;
import jpl.Compound;
import jpl.Term;

/**
 *
 * @author lucas
 */
public class ConcretePiece implements Piece {

    private final int sizes[];
    private final int prefer;

    /**
     *
     * @param lados Vetor de tamanho 2 que contém as pontas da peca
     */
    public ConcretePiece(int lados[]) {
        this.sizes = new int[2];
        if (lados[0] < lados[1]) {
            this.sizes[0] = lados[0];
            this.sizes[1] = lados[1];
        } else {
            this.sizes[0] = lados[1];
            this.sizes[1] = lados[0];
        }
        prefer = -1;
    }

    @Override
    public int getPreference() {
        return prefer;
    }
    
    public ConcretePiece(Term pl) {
        this.sizes = new int[2];
        if (pl.args()[0].intValue() < pl.args()[1].intValue()) {
            this.sizes[0] = pl.args()[0].intValue();
            this.sizes[1] = pl.args()[1].intValue();
        } else {
            this.sizes[0] = pl.args()[1].intValue();
            this.sizes[1] = pl.args()[0].intValue();
        }

        prefer = -1;
    }
    
    public ConcretePiece(Term pl, int preferibable) {
        this.sizes = new int[2];
        if (pl.args()[0].intValue() < pl.args()[1].intValue()) {
            this.sizes[0] = pl.args()[0].intValue();
            this.sizes[1] = pl.args()[1].intValue();
        } else {
            this.sizes[0] = pl.args()[1].intValue();
            this.sizes[1] = pl.args()[0].intValue();
        }

        prefer = preferibable;
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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Piece) {
            Piece peca = (Piece)o;
            return (peca.values()[0] == this.values()[0] && peca.values()[1] == this.values()[1]);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Arrays.hashCode(this.sizes);
        return hash;
    }

    @Override
    public String getPieceName() {
        return (new StringBuilder("").append(sizes[0]).append("-").append(sizes[1])).toString();
    }

    
}
