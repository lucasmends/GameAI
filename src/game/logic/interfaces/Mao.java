/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic.interfaces;

import model.Peca;

/**
 *
 * @author lucas
 */
public interface Mao {
    
    public Peca removePeca(int i);
    public Peca removePeca(Peca p);
    public int qtdMao();
    public void addPeca(Peca p);
    public Peca verPeca(int i);
}
