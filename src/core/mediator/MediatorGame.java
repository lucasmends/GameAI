/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.mediator;

import game.logic.interfaces.Jogador;
import game.logic.interfaces.Pilha;
import model.Peca;

/**
 *
 * @author lucas
 */
public interface MediatorGame {
 
    
    public void addJogador(Jogador jogador);
    public void setPilha(Pilha pilha);
    public Peca pegarPilha();
}
