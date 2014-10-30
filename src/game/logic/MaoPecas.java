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
import model.Peca;

/**
 *
 * @author lucas
 */
public class MaoPecas implements Mao<Peca>{

    private List<Peca> mao;
    
    public MaoPecas(){
        mao = new ArrayList<>();
    }
    
    public MaoPecas(List<Peca> lista) {
	mao = new ArrayList<>(lista);
    }

    @Override
    public void addPeca(Peca peca) {
        mao.add(peca);
    }

    @Override
    public Peca removePeca(int i) {
	return mao.remove(i);
    }

    @Override
    public Peca removePeca(Peca p) {
	mao.remove(p);
	return p;
    }

    @Override
    public int qtdMao() {
	return mao.size();
    }

    @Override
    public Peca verPeca(int i) {
	return mao.get(i);
    }

    @Override
    public Term getTerm() {
	Term[] lista = new Term[qtdMao()];
	for (int i = 0; i < lista.length; i++) {
	    lista[i] = verPeca(i).getTerm();
	}
	return Util.termArrayToList(lista);
    }
    
}
