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
public interface Pilha {
    public int qtdRestantes();
    public Peca getProxima();
}
