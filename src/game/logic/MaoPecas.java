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
public class MaoPecas implements Pilha, Mao{

    private List<Peca> mao;
    
    public MaoPecas(){
        mao = new ArrayList<>();
    }
       
    @Override
    public int qtdRestantes() {
        return mao.size();
    }

    @Override
    public Peca getProxima() {
        return mao.get(0);
    }

    @Override
    public void addPeca(Peca peca) {
        mao.add(peca);
    }

    @Override
    public Peca getPeca(int i) {
        try{
            return mao.remove(i);
        }catch(IndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    
}
