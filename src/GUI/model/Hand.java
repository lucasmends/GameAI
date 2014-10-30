/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import core.mediator.Game;
import core.mediator.MediatorGame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import model.Piece;

/**
 *
 * @author lucas
 */
public abstract class Hand extends JPanel {

    protected final game.logic.interfaces.Hand<Piece> hand;
    protected List<Domino> dominos;
    protected final MediatorGame mediator = Game.getInstance();

    
    public Hand(game.logic.interfaces.Hand<Piece> hand){
        this.hand = hand;
        dominos = new ArrayList<>(7);
    }
    
    protected void pieceToDomino(boolean back) {
        if (back == false) {
            for(int i = 0; i < hand.qtdHand(); i++){
                Piece piece = hand.show(i);
                String file = new StringBuilder("/Resources/").append(piece.getFileName()).toString();
                dominos.add(new Domino( getClass().getResource(file).getFile() , piece));
            }
        } else{
            for(int i = 0; i < hand.qtdHand(); i++){
                Piece piece = hand.show(i);
                dominos.add(new Domino(getClass().getResource("/Resources/r-back.png").getFile(), piece));
            }
        }

    }

    public abstract void addDomino(Piece piece);

}
