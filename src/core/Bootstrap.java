/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import logic.game.RoundLogic;
import model.interfaces.Player;
import model.interfaces.Hand;
import GUI.GameScreen;
import GUI.Hand.HandPlayer;
import GUI.model.HandGUI;
import logic.game.Game;
import model.HandPieces;
import model.PiecesStack;
import logic.AI.PlayerAI;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import jpl.Atom;
import jpl.Query;
import jpl.Term;
import jpl.Util;
import jpl.Variable;
import logic.AI.DumbAI;
import logic.AI.SmartAI;
import model.interfaces.Piece;
import model.ConcretePiece;

/**
 *
 * @author lucas
 */
public class Bootstrap {

    private final Hand handPlayer[];
    private PiecesStack stack;
    private Query domino;

    public Bootstrap(int qtdPlayers, int qtdAI) {
        handPlayer = new HandPieces[qtdPlayers];
        stack = new PiecesStack();
        initSWI(qtdPlayers);
        GameScreen board = initBoard(qtdPlayers, qtdAI);
        board.setVisible(true);
        RoundLogic.getInstance().setBoard(board);
        new Thread(RoundLogic.getInstance()).start();
    }

    private void initSWI(int qtdJogadores) {
        domino = new Query("consult", new Atom(getClass().getResource("/Resources/domino.pl").getFile()));
        if (domino.hasSolution()) {
            System.out.println("Lógica carregada.");

            Variable X = new Variable("X");
            Query qpecas = new Query("iniciar_pecas", X);
            
            while (qpecas.hasMoreSolutions()) {
                Hashtable binding = qpecas.nextSolution();
                Term px = (Term) binding.get("X");
		List<Piece> lista = new ArrayList<>(Bootstrap.getPieceFromTerm(Util.listToTermArray(px)));
		int j;
                for (j = 0; j < qtdJogadores; j++) {
		    handPlayer[j] = new HandPieces(lista.subList(7*j, 7*(j+1)));
		}
		stack = new PiecesStack();
		stack.populate(lista.subList(7*j, lista.size()));
            }
        }
        
        Game.getInstance().setStack(stack);
    }
    
    static List<Piece> getPieceFromTerm(Term[] t) {
	List<Piece> lista = new ArrayList<>(t.length);
	for (Term elem: t) {
	    lista.add(new ConcretePiece(elem));
	}
	return lista;
    }

    private GameScreen initBoard(int qtdPlayers, int qtdAI){
        GameScreen boardGame = new GameScreen();
        List<HandGUI> AIsGUIs = new ArrayList<>(qtdAI);
        
        if(qtdPlayers - qtdAI > 0){
            Player human = new HandPlayer(handPlayer[0]);
            boardGame.addHumanPlayer((HandGUI) human);
            Game.getInstance().addPlayer(human);
        }
        boolean upDirection = false;
        for(int i = (qtdPlayers - qtdAI); i < qtdPlayers; i++){
            PlayerAI AI;
            if(i < 1)
               AI  = new SmartAI(handPlayer[i], upDirection);  
            else
                AI = new DumbAI(handPlayer[i], upDirection);  
            AIsGUIs.add(AI.getHand());
            Game.getInstance().addPlayer(AI);
            /*Player other = new HandPlayer(handPlayer[i]);
            ArrayList<HandGUI> l = new ArrayList<>();
            l.add((HandGUI) other);
            boardGame.addAIPlayer(l);
            Game.getInstance().addPlayer(other); */    
            upDirection = true;
        }
        
        boardGame.addAIPlayer(AIsGUIs);
        
        return boardGame;
    }
    
}
