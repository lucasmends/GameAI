/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.mediator;

import game.logic.interfaces.Jogador;
import game.logic.interfaces.Pilha;
import java.util.List;
import model.Peca;

/**
 *
 * @author lucas
 */
public class Game implements MediatorGame{
    
    private final static Game instance = new Game();
    private Pilha pilha;
    private List<Jogador> jogadores;
    
    
    private Game(){
        pilha = null;
    }
    
    public static Game getInstance(){
        return instance;
    }
    
    @Override
    public void setPilha(Pilha pilha){
        this.pilha = pilha;
    }
    
    @Override
    public void addJogador(Jogador jogador){
        if(this.jogadores.size() < 4){
            this.jogadores.add(jogador);
        }
    }

    @Override
    public Peca pegarPilha() {
        if(pilha.qtdRestantes() > 0){
            return (Peca) pilha.getProxima();
        }
        return null;
    }
    
}
