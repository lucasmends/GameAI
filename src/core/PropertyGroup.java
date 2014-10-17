/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rafaelpaiva
 */
public abstract class PropertyGroup{
    
    private final Avenue[] avenues;
    private int maxHouses;
    
    PropertyGroup (Avenue[] av) {
	maxHouses = 0;
	this.avenues = av;
    }
    
    public List<Avenue> getAvaliableAvenueLand() {
	List<Avenue> result = new ArrayList<>();
	for (Avenue h: avenues) {
	    if (h.getHouseQuantity() < maxHouses)
		result.add(h);
	}
	if (result.isEmpty()) {
	    result.addAll(Arrays.asList(avenues));
	}
	return result;
    }
    
    public Player MonopolyPlayer() {
	Player p = avenues[0].getOwner();
	for (int i = 1; i < avenues.length; i++)
	    if (p != avenues[i].getOwner()) {
		p = null;
		break;
	    }
	return p;
    }
    
    void setMaxHouses(int qtd) {
	if (qtd > maxHouses) maxHouses = qtd;
    }
}
