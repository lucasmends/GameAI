/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.game;

import GUI.Board;
import GUI.GameScreen;
import GUI.model.Domino;
import model.interfaces.Player;
import java.util.List;
import model.interfaces.Hand;
import model.interfaces.Piece;

/**
 *
 * @author lucas
 */
public class RoundLogic {

    private static final RoundLogic instance = new RoundLogic();

    private final List<Player> players;
    private int actualPlayer;
    private GameScreen screen;

    private RoundLogic() {
        players = Game.getInstance().getPlayers();
        actualPlayer = checkFirstPlayer()[0];
        players.get(actualPlayer).placePiece(checkFirstPlayer()[1]);
        //actualPlayer = 0;
        screen = null;
    }

    public static RoundLogic getInstance() {
        return instance;
    }

    public void setBoard(GameScreen board) {
        this.screen = board;
        players.get(actualPlayer).doMove();
    }

    public void repaint() {
        this.screen.repaint();
    }

    public void nextPlayerTurn() {
        if (checkWin() == false) {
            actualPlayer = (actualPlayer + 1) % players.size();
            players.get(actualPlayer).doMove();
        } else {
            if (movePossible()) {
                //o jogador ganhou
                
            }else{
               
                int winnerPlayer = 0;
                int pontuation = 100;
                for (int i = 0; i < players.size(); i++) {
                    if(players.get(i).getPoint() < pontuation){
                        pontuation = players.get(i).getPoint();
                        winnerPlayer = i;
                    }
                }
                //o jogador winnerPlayer ganhou
            }
        }
    }

    private int[] checkFirstPlayer() {
        int count = 0;
        int first[] = new int[2];
        int doublePiece = 0;
        for (Player player : players) {
            Hand<Piece> hand = player.showHand();
            for (int i = 0; i < hand.qtdHand(); i++) {
                if (hand.show(i).values()[0] == hand.show(i).values()[1]) {
                    if (hand.show(i).values()[0] == 6) {
                        //System.out.println( hand.show(i).values()[1]);
                        first[0] = count;
                        first[1] = i;
                        return first;
                    }
                    if (hand.show(i).values()[0] > doublePiece) {
                        //System.out.println( hand.show(i).values()[1]);
                        doublePiece = hand.show(i).values()[0];
                        first[0] = count;
                        first[1] = i;
                    }
                }
            }
            count++;
        }
        return first;
    }

    private boolean checkWin() {
        if (players.get(actualPlayer).showHand().qtdHand() < 1) {
            return true;
        } else {
            return !movePossible();
        }
    }

    private boolean movePossible() {
        if(Game.getInstance().stackRemaining() > 0)
            return true;
        for(Player player: players)
        {
            for(Domino domino: player.getDominos()){
                if(Board.getInstance().checkPossible(domino))
                    return true;
            }
        }
        return false;
    }
}
