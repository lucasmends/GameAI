/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author rafaelpaiva
 */
public class Player {
    
    private int pos;
    private int cash;
    
    Player () {
	cash = 1500;
    }
    
    int getPos () {
	return pos;
    }
    
    void setPos(int nPos) {
	pos = nPos;
    }
    
    int getCash () {
	return cash;
    }
    
    void addCash(int ammount) {
	cash += ammount;
    }
    
    boolean isJailed() {
	// if pos == ...
	return false;
    }
}
