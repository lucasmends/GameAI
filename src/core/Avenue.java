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
public class Avenue extends Place {

    private int houses;
    private final String name;
    private final int[] rent;
    private final int mortgage;
    private final int housePrice;
    
    private Player owner;
    
    Avenue (String name, int[] rent, int mortgage, int housePrice) {
	houses = 0;
	this.name = name;
	this.rent = rent;
	this.mortgage = mortgage;
	this.housePrice = housePrice;
	
	owner = null;
    }
    
    public int getHouseQuantity() {
	return houses;
    }
    
    public void addHouse() {
	this.houses++;
    }
    
    public int getRentValue() {
	return rent[houses];
    }
    
    public void setOwner(Player np) {
	owner = np;
    }
    
    public Player getOwner() {
	return owner;
    }
}