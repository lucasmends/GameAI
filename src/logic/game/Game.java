/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.game;

import logic.AI.PlayerAI;
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
    private final int[] pontas;
    private final List<Piece> allPieces;

    private Game() {
        players = new ArrayList<>();
        stack = null;
	pontas = new int[2];
	allPieces = new ArrayList<>(28);
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
            return (Piece) stack.getNext();
        }
        return null;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public void informPiecePlaced(Piece piece, Player player) {
        atualizarPontasSoltas(piece);
        for (Player play : players) {
            if (!play.equals(player)) {
                play.piecePlaced(piece);
            }
        }
    }

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
    
    @Override
    public int[] checkFreeSlots() {
	return pontas;
    }
    
    private void atualizarPontasSoltas(Piece peca) {
	int[] lados = peca.values();
	
	if (pontas[0] == lados[0])
	    pontas[0] = lados[1];
	else if (pontas[0] == lados[1])
	    pontas[0] = lados[0];
	else if (pontas[1] == lados[0])
	    pontas[1] = lados[1];
	else if (pontas[1] == lados[1])
	    pontas[1] = lados[0];
    }
}
