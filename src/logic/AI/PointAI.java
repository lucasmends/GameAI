/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.AI;

import GUI.Board;
import java.util.Hashtable;
import jpl.Query;
import jpl.Term;
import jpl.Variable;
import model.ConcretePiece;
import model.interfaces.Hand;
import model.interfaces.Piece;

/**
 *
 * @author lucas
 */
public class PointAI extends PlayerAI {

    public PointAI(Hand hand, boolean upDirection) {
        super(hand, upDirection);
    }

    @Override
    public Piece putOnBoard() {
        Variable pecaVar = new Variable("P");
        boolean possiblePlay = true;
        int[] sides = Board.getInstance().sidesPossible();
        Query movimento;

        while (possiblePlay) {
            movimento = new Query("pointAI", new Term[]{hand.getTerm(), new jpl.Integer(sides[0]), new jpl.Integer(sides[1]), pecaVar});

            if (movimento.hasSolution()) {
                Hashtable resposta = movimento.oneSolution();
                Term peca = (Term) resposta.get("P");
                return new ConcretePiece(peca, peca.args()[0].intValue());
            } else {
                System.out.println("Não temos pecas disponiveis");
                possiblePlay = this.takeFromStack();
            }
        }
        return null;
    }
}
