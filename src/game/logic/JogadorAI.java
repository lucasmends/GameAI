/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic;

import core.mediator.Game;
import core.mediator.MediatorGame;
import game.logic.interfaces.Jogador;
import game.logic.interfaces.Mao;
import jpl.Query;
import model.Peca;

/**
 *
 * @author lucas
 */
public class JogadorAI implements Jogador{

    private final Mao<Peca> mao;
    private final Query ai;      
    private final MediatorGame mediator = Game.getInstance();
    
    public JogadorAI(Mao mao, Query ai){
        this.mao = mao;
        this.ai = ai;
    }
    
    
    
    
    @Override
    public void pegarPilha() {
        Peca pecaPilha = mediator.pegarPilha();
        if(pecaPilha != null)
            //Colocar a logica em prolog para a pilha
            ;
    }

    @Override
    public Peca colcarTabulero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fazerJogada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mao<Peca> mostrarMao() {
        return mao;
    }
    
}
