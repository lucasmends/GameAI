/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic;

import game.logic.interfaces.Pilha;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;
import model.Peca;

/**
 *
 * @author lucas
 */
public class PilhaPecas implements Pilha<Peca>{

    private final Queue<Peca> pilha;
    
    public PilhaPecas(){
        pilha = new SynchronousQueue<>();
    }
    
    @Override
    public void popular(List<Peca> list) {
	pilha.addAll(list);
    }
    
    public void addPeca(Peca peca){
        pilha.add(peca);
    }
    
    @Override
    public int qtdRestantes() {
        return pilha.size();
    }

    @Override
    public Peca getProxima() {
        return pilha.remove();
    }
    
}
