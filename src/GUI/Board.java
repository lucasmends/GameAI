/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.model.Domino;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import logic.game.RoundLogic;
import model.interfaces.Piece;

/**
 *
 * @author lucas
 */
public class Board extends JPanel {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    private int orientationLeft = -1;
    private int orientationRight = 1;
    private int countLeft = 0;
    private int countRight = 0;
    private int maxLeft = 6;
    private int maxRight = 6;

    private final int X = 0;
    private final int Y = 1;

    private static final Board instance = new Board();
    private final Deque<Domino> dominos;
    private final int[] ends;

    private final int left[];
    private final int right[];

    //private final JPanel board;

    private Board() {
        //board = new JPanel(new java.awt.GridLayout());
        dominos = new LinkedList<>();
        ends = new int[2];
        left = new int[2];
        left[X] = 5;
        left[Y] = 0;
        right = new int[2];
        right[X] = 4;
        right[Y] = 0;

        //board.setPreferredSize(new Dimension(820, 210));
        initComponents();
    }

    public static Board getInstance() {
        return instance;
    }

    private void initComponents() {

        //setViewportView(board);
        setLayout(new java.awt.FlowLayout(FlowLayout.CENTER));
        //setLayout(new java.awt.GridBagLayout());
        setMinimumSize(new Dimension(1040, 560));
        setPreferredSize(new Dimension(1040, 560));
    }

    public boolean addDomino(Domino domino) {
        if (dominos.isEmpty()) {
            addDominoBoard(domino, LEFT);
            dominos.add(domino);
            ends[LEFT] = domino.getPiece().values()[LEFT];
            ends[RIGHT] = domino.getPiece().values()[RIGHT];
            return true;
        }
        int side = -1;
        if (domino.getPiece().values()[LEFT] == ends[LEFT] || domino.getPiece().values()[RIGHT] == ends[LEFT]) {
            side = LEFT;
        } else {
            if (domino.getPiece().values()[LEFT] == ends[RIGHT] || domino.getPiece().values()[RIGHT] == ends[RIGHT]) {
                side = RIGHT;
            }
        }
        return addDomino(domino, side);

    }

    public int dominoPossibilities(Domino domino) {
        int count = 0;
        if (domino.getPiece().values()[LEFT] == ends[LEFT] || domino.getPiece().values()[RIGHT] == ends[LEFT]) {
            count++;
        }
        if (domino.getPiece().values()[LEFT] == ends[RIGHT] || domino.getPiece().values()[RIGHT] == ends[RIGHT]) {
            count++;
        }
        return count;

    }

    public boolean addDomino(Domino domino, int side) {
        if (side < LEFT || side > RIGHT) {
            return false;
        }
        if (side == LEFT) {
            addDominoBoard(domino, LEFT);
            dominos.addFirst(domino);
        } else {
            addDominoBoard(domino, RIGHT);
            dominos.addLast(domino);
        }
        return true;
    }

    private void addDominoBoard(Domino domino, int side) {

        //if (domino.getPlayer() instanceof PlayerAI) {
        domino.changeImage();
        //}
        domino.rotate(90);

        java.awt.GridBagConstraints gridBagConstraints;
        gridBagConstraints = new java.awt.GridBagConstraints();

        if (side == LEFT) {
            setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            if (domino.getPiece().values()[1] == ends[LEFT]) {
                ends[LEFT] = domino.getPiece().values()[0];
                    domino.rotate(180);
            } else {
                ends[LEFT] = domino.getPiece().values()[1];
            }
        } else {
            setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            if (domino.getPiece().values()[0] == ends[RIGHT]) {
                ends[RIGHT] = domino.getPiece().values()[1];
                    domino.rotate(180);
            } else {
                ends[RIGHT] = domino.getPiece().values()[0];
            }
        }

        add(domino);

        domino.setActive(false);
        MouseListener[] listeners = domino.getMouseListeners();
        if (listeners != null && listeners.length > 0) {
            domino.removeMouseListener(domino.getMouseListeners()[0]);
        }

        RoundLogic.getInstance().repaint();
    }

    public boolean checkPossible(Domino domino) {
        if (domino.getPiece().values()[LEFT] == ends[LEFT] || domino.getPiece().values()[LEFT] == ends[RIGHT]) {
            return true;
        }
        return domino.getPiece().values()[RIGHT] == ends[LEFT] || domino.getPiece().values()[RIGHT] == ends[RIGHT];
    }

    public boolean checkPossible(Piece domino) {
        if (domino.values()[LEFT] == ends[LEFT] || domino.values()[LEFT] == ends[RIGHT]) {
            return true;
        }
        return domino.values()[RIGHT] == ends[LEFT] || domino.values()[RIGHT] == ends[RIGHT];

    }

    public int[] sidesPossible() {
        return ends;
    }

    public List<Domino> dominosPlaced() {
        ArrayList<Domino> list = new ArrayList<>(dominos.size());
        list.addAll(dominos);

        return list;
    }

    public Domino[] corner() {
        Domino[] both = new Domino[2];
        both[0] = dominos.getFirst();
        both[1] = dominos.getLast();
        return both;
    }
}
