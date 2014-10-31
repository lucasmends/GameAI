/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.mediator;

import game.logic.interfaces.Player;
import game.logic.interfaces.Stack;
import java.util.ArrayList;
import java.util.List;
import model.Piece;

/**
 *
 * @author lucas
 */
public class Game implements MediatorGame{
    
    private final static Game instance = new Game();
    private Stack stack;
    private final List<Player> players;
    
    
    private Game(){
        players = new ArrayList<>();
        stack = null;
    }
    
    public static Game getInstance(){
        return instance;
    }
    
    @Override
    public void setStack(Stack stack){
        this.stack = stack;
    }
    
    @Override
    public void addPlayer(Player player){
        if(this.players.size() < 4){
            this.players.add(player);
        }
    }

    @Override
    public Piece takeStack() {
        if(stack.qtdRemaining() > 0){
            return (Piece) stack.getNext();
        }
        return null;
    }
    
}
