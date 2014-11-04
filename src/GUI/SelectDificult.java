/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.interfaces.Player;
import logic.AI.*;
import logic.game.Game;
import model.interfaces.Hand;

/**
 *
 * @author lucas
 */
public class SelectDificult extends javax.swing.JDialog {


    public SelectDificult(int qtdAI, GameScreen boardGame, Hand[] handPlayer) {
        super();
        setModal(true);
        this.boardGame = boardGame;
        this.qtdAI = qtdAI;
        this.handPlayer = handPlayer;
        initComponents();
        initPanel();
        java.awt.GridBagConstraints gridBagConstraints;
        for (int i = 0; i < qtdAI; i++) {
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i;
            jPanel1.add(AIPanel[i], gridBagConstraints);
        }
        pack();
        setResizable(false);
    }

    private void initPanel() {
        AIPanel = new JPanel[4];
        AILabel = new JLabel[4];
        AIsBox = new JComboBox[4];
        for(int i = 0; i < 4; i++){
            AIPanel[i] = new JPanel();
            AILabel[i] = new JLabel();
            AILabel[i].setFont(new java.awt.Font("Arial", 1, 18));
            AIsBox[i] = new JComboBox();
            AIsBox[i].setFont(new java.awt.Font("Arial", 1, 16));
        }
        String[] m = new String[3];
        m[0] = "DumbAI";
        m[1] = "PointAI";
        m[2] = "SmartAI";
        DefaultComboBoxModel model;
        for (int i = 0; i < 4; i++) {
            model = new DefaultComboBoxModel(m);
            AIsBox[i].setModel(model);
            AILabel[i].setText("Computador " + (i + 1) + ": ");
            AIPanel[i].add(AILabel[i]);
            AIPanel[i].add(AIsBox[i]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        OK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Selecionar Dificuldade");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jLabel1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(jPanel1, gridBagConstraints);

        OK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(OK, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        boolean upDirection = false;
        PlayerAI AI;
        for(int i = 0; i < qtdAI; i++){
            switch(AIsBox[i].getSelectedIndex()){
                case 0:
                    AI = new DumbAI(handPlayer[i], upDirection);
                    break;
                case 1:
                    AI = new PointAI(handPlayer[i], upDirection);
                    break;
                default:
                    AI = new SmartAI(handPlayer[i], upDirection);
                    break;
            }
            Game.getInstance().addPlayer(AI);
            boardGame.addAIPlayer(AI.getHand(), (String) AIsBox[i].getSelectedItem(), i);
            upDirection = (i == 0 || i == 1);
        }
        this.dispose();
    }//GEN-LAST:event_OKActionPerformed

    private final Hand handPlayer[];
    private final GameScreen boardGame;
    private final int qtdAI;
    private JComboBox[] AIsBox;
    private JPanel[] AIPanel;
    private JLabel[] AILabel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
