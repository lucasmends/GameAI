/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lucas
 */
public class PecaConcreta implements Peca{

    private int lado[];
    
    
    /**
     * 
     * @param lados Vetor de tamanho 2 que contém as pontas da peca
     */
    public PecaConcreta(int lados[]){
        this.lado = new int[2];
        this.lado[0] = lados[0];
        this.lado[1] = lados[1];
    }
    
    @Override
    public int[] valores() {
        return lado;
    }
    
}
