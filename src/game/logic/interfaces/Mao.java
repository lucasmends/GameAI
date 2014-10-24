/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic.interfaces;

import jpl.Term;

/**
 *
 * @author lucas
 */
public interface Mao<T> {
    
    public T removePeca(int i);
    public T removePeca(T p);
    public int qtdMao();
    public void addPeca(T p);
    public T verPeca(int i);
    
    public Term getTerm();
}
