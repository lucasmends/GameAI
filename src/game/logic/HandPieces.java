/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic;

import game.logic.interfaces.*;
import java.util.ArrayList;
import java.util.List;
import jpl.Term;
import jpl.Util;
import model.Piece;

/**
 *
 * @author lucas
 */
public class HandPieces implements Hand<Piece>{

    private List<Piece> mao;
    
    public HandPieces(){
        mao = new ArrayList<>();
    }
    
    public HandPieces(List<Piece> lista) {
	mao = new ArrayList<>(lista);
    }

    @Override
    public void add(Piece peca) {
        mao.add(peca);
    }

    @Override
    public Piece remove(int i) {
	return mao.remove(i);
    }

    @Override
    public Piece remove(Piece p) {
	mao.remove(p);
	return p;
    }

    @Override
    public int qtdHand() {
	return mao.size();
    }

    @Override
    public Piece show(int i) {
	return mao.get(i);
    }

    @Override
    public Term getTerm() {
	Term[] lista = new Term[qtdHand()];
	for (int i = 0; i < lista.length; i++) {
	    lista[i] = show(i).getTerm();
	}
	return Util.termArrayToList(lista);
    }
    
}
