/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic;

import game.logic.interfaces.*;
import java.util.ArrayList;
import java.util.List;
import model.Peca;

/**
 *
 * @author lucas
 */
public class MaoPecas implements Mao{

    private List<Peca> mao;
    
    public MaoPecas(){
        mao = new ArrayList<>();
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
    
}
