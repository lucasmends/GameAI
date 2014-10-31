/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Hand;

import GUI.model.Domino;
import game.logic.interfaces.Hand;;
import model.Piece;

/**
 *
 * @author lucas
 */
public class HandPlayerAI extends GUI.model.HandGUI{
    
    private final double angleOrientation;
    
    
    public HandPlayerAI(Hand<Piece> hand, double angleOrientation, boolean upDirection){
        super(hand);
        this.angleOrientation = angleOrientation;
        
        piecesToDomino(true);
        
        if(upDirection)
            setLayout(new java.awt.GridLayout(0, 2));
        
        for(Domino domino: dominos){
            setOrientation(domino);
            add(domino);
        }       
    }

    private void setOrientation(Domino domino){
        domino.rotate(angleOrientation);
    }
    
    @Override
    public void addDomino(Piece piece) {
        this.hand.add(piece);
        Domino domino = piecesToDomino(piece, true);
        this.dominos.add(domino);
        setOrientation(domino);
        add(domino);
        
    }
}
