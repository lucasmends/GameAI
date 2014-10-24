/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.logic.interfaces;

import java.util.List;

/**
 *
 * @author lucas
 * @param <T>
 */
public interface Pilha<T> {
    public int qtdRestantes();
    public T getProxima();
    public void popular(List<T> list);
}
