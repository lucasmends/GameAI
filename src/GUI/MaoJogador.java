package GUI;

import GUI.model.Domino;
import core.mediator.Game;
import core.mediator.MediatorGame;
import game.logic.interfaces.Jogador;
import game.logic.interfaces.Mao;
import java.util.ArrayList;
import java.util.List;
import model.Peca;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class MaoJogador extends javax.swing.JPanel implements Jogador {

    /**
     * Creates new form MaoJogador
     */
    private Mao<Peca> mao;
    private List<Domino> dominos;
    private MediatorGame mediator = Game.getInstance();

    public MaoJogador(Mao<Peca> mao) {
        initComponents();

        this.mao = mao;
        pecaToDomino();

        for (Domino domino : dominos) {
            add(domino);
        }
    }

    private void pecaToDomino() {
        dominos = new ArrayList<>();
        dominos.add(new Domino(getClass().getResource("/Resources/r-domino0-1.png").getFile()));
        dominos.add(new Domino(getClass().getResource("/Resources/r-domino0-2.png").getFile()));
        dominos.add(new Domino(getClass().getResource("/Resources/r-domino0-3.png").getFile()));
    }

    private void addDomino(Peca peca) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void pegarPilha() {
        Peca peca = mediator.pegarPilha();
        mao.addPeca(peca);
        addDomino(peca);
    }

    @Override
    public Peca colcarTabulero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fazerJogada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mao<Peca> mostrarMao() {
        return mao;
    }
}
