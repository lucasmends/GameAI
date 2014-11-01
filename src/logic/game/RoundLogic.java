/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.game;

import GUI.Board;
import logic.game.Game;
import model.interfaces.Player;
import java.util.List;
import model.interfaces.Piece;

/**
 *
 * @author lucas
 */
public class RoundLogic {

    private static final RoundLogic instance = new RoundLogic();

    private final List<Player> players;
    private int actualPlayer;
    private Board board;

    private RoundLogic() {
        players = Game.getInstance().getPlayers();
        //actualPlayer = checkFirstPlayer();
        actualPlayer = 0;
        board = null;
    }

    public static RoundLogic getInstance() {
        return instance;
    }

    public void setBoard(Board board) {
        this.board = board;
        players.get(actualPlayer).doMove();
    }

    public void repaint(){
        this.board.repaint();
    }
    
    public void nextPlayerTurn() {
        if (checkWin() != false) {
            actualPlayer = (actualPlayer + 1) % players.size();
            players.get(actualPlayer).doMove();
        } else{
            if(movePossible()){
                //o jogador ganhou
                ;
            }else{
                //verificando pelos pontos
                int[] pontuation = new int[players.size()];
                for(int i = 0; i < players.size(); i++){
                    pontuation[i] = players.get(i).getPoint();
                }
                
                int winnerPlayer = 0;
                for(int i = 1; i < players.size(); i++)
                    if(pontuation[i] < players.get(winnerPlayer).getPoint())
                        winnerPlayer = i;
            }
        }
    }

    private int checkFirstPlayer() {
        //verificar u=quem possui a maior dupla
        return 0;
    }

    private boolean checkWin() {
        if (players.get(actualPlayer).showHand().qtdHand() < 1) {
            return true;
        } else {
            return movePossible();
        }
    }
    
    private boolean movePossible(){
        
        return true;
    }
}
