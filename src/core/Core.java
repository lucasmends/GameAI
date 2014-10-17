/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelpaiva
 */
public class Core {
    
    private static final Core INSTANCE = new Core();
    private int avaliableHouses;
    private int avaliableHotels;
    
    private final List<Player> jogadores = new ArrayList<>();
    
    
    private Core() {
	avaliableHouses = 32;
	avaliableHotels = 12;
    }
    
    public static Core getInstance() {
	return INSTANCE;
    }
    
    static class GotoEffect implements CardEffect {

	@Override
	public void Execute(int player, int effect) {
	    INSTANCE.jogadores.get(player).setPos(effect);
	}
	
    }
    
    private static class GotoRelativeEffect implements CardEffect {

	@Override
	public void Execute(int player, int effect) {
	    int old = INSTANCE.jogadores.get(player).getPos();
	    INSTANCE.jogadores.get(player).setPos(old+effect);
	}
	
    }
    
    private static class CashEffect implements CardEffect {

	@Override
	public void Execute(int player, int effect) {
	    INSTANCE.jogadores.get(player).addCash(effect);
	}
	
    }
}
