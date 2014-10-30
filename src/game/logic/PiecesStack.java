/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic;

import game.logic.interfaces.Stack;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;
import model.Piece;

/**
 *
 * @author lucas
 */
public class PiecesStack implements Stack<Piece>{

    private final Queue<Piece> pilha;
    
    public PiecesStack(){
        pilha = new SynchronousQueue<>();
    }
    
    @Override
    public void populate(List<Piece> list) {
	pilha.addAll(list);
    }
    
    public void addPeca(Piece peca){
        pilha.add(peca);
    }
    
    @Override
    public int qtdRemaining() {
        return pilha.size();
    }

    @Override
    public Piece getNext() {
        return pilha.remove();
    }
    
}
