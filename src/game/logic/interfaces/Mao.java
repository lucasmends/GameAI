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
    
    public void addPeca(Peca peca);
    public Peca getPeca(int i);
}
