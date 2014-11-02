/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.interfaces.Stack;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import model.interfaces.Piece;

/**
 *
 * @author lucas
 */
public class PiecesStack implements Stack<Piece>{

    private final Queue<Piece> pilha;
    
    public PiecesStack(){
        pilha = new ArrayDeque<>();
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
