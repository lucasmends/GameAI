/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.game;

import GUI.Board;
import model.interfaces.Player;
import model.interfaces.Stack;
import java.util.ArrayList;
import java.util.List;
import model.interfaces.Piece;

/**
 *
 * @author lucas
 */
public class Game implements MediatorGame {

    private final static Game instance = new Game();
    private Stack stack;
    private final List<Player> players;
    //private final int[] pontas;
    //private final List<Piece> allPieces;

    private Game() {
        players = new ArrayList<>();
        stack = null;
	//pontas = new int[2];
	//allPieces = new ArrayList<>(28);
    }

    public static Game getInstance() {
        return instance;
    }

    @Override
    public void setStack(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() < 4) {
            this.players.add(player);
        }
    }

    @Override
    public Piece takeStack() {
        if (stack.qtdRemaining() > 0) {
            RoundLogic.getInstance().stackRemaining(stack.qtdRemaining());
            return (Piece) stack.getNext();
        }
        return null;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    /*@Override
    public void informPiecePlaced(Piece piece, Player player) {

        for (Player play : players) {
            if (!play.equals(player)) {
                play.piecePlaced(piece);
            }
        }
    }*/

    @Override
    public int[] checkPiecesRemainig(Player player) {
        int[] remaining = new int[players.size()];

        for (int i = 0; i < players.size(); i++) {
            Player play = players.get(i);
            if (!play.equals(player)) {
                remaining[i] = play.remaining();
            }
        }

        return remaining;
    }


    public int stackRemaining() {
        return stack.qtdRemaining();
    }
    
    @Override
    public int[] checkFreeSlots() {
	return Board.getInstance().sidesPossible();
    }

    @Override
    public int getNumberOfPlayers() {
	return players.size();
    }

}
