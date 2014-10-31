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
public interface Hand<T>{
    
    public T remove(int i);
    public T remove(T p);
    public int qtdHand();
    public void add(T p);
    public T show(int i);
    
    public Term getTerm();

}
