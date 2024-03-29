package br.com.fisioterapia.jframe.cadastro;

import br.com.fisioterapia.database.consulta.Exercicio;
import br.com.fisioterapia.database.consulta.Equipamentos;
import java.beans.PropertyVetoException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
/**
 *
 * @author aevan
 */
public class EquipamentosJF extends javax.swing.JInternalFrame {

    /**
     * Creates new form EquipamentosJF
     */
    public EquipamentosJF() {
        initComponents();
        try {
            this.setMaximum(true);
        } catch (PropertyVetoException p) {
            lblSaida.setText("Ocorreu um erro ao maximizar o JInternal Frame");
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

        lblNome = new javax.swing.JLabel();
        txtExercicio = new javax.swing.JTextField();
        lblExercicio = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();
        lblDescricao = new javax.swing.JLabel();
        lblSaida = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        spQuantidade = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Inserir Equipamentos");
        setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("Nome");
        getContentPane().add(lblNome);
        lblNome.setBounds(20, 20, 48, 25);
        getContentPane().add(txtExercicio);
        txtExercicio.setBounds(90, 270, 250, 30);

        lblExercicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblExercicio.setText("Exercicio:");
        getContentPane().add(lblExercicio);
        lblExercicio.setBounds(10, 270, 80, 30);

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        getContentPane().add(btnInserir);
        btnInserir.setBounds(170, 310, 71, 35);

        lblDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescricao.setText("Descrição:");
        getContentPane().add(lblDescricao);
        lblDescricao.setBounds(10, 70, 70, 30);
        getContentPane().add(lblSaida);
        lblSaida.setBounds(10, 370, 380, 20);

        lblQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuantidade.setText("Quantidade:");
        getContentPane().add(lblQuantidade);
        lblQuantidade.setBounds(10, 220, 80, 30);
        getContentPane().add(txtNome);
        txtNome.setBounds(75, 22, 249, 30);

        spQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(spQuantidade);
        spQuantidade.setBounds(90, 220, 60, 30);

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(90, 80, 220, 130);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed

        String nome = txtNome.getText();
        String descricao = txtDescricao.getText();
        int quantidade = Integer.valueOf(String.valueOf(spQuantidade.getValue()));
        String exercicio = "";

        if (!nome.isBlank() && !descricao.isBlank() && quantidade > 0) {
            Equipamentos e1 = new Equipamentos(nome, quantidade, descricao);
            if (!e1.verificarNomeEquipamento()) {
                exercicio = txtExercicio.getText();
                Exercicio e2 = new Exercicio(exercicio);
                if (e2.verificarNomeExercicio()) {
                    e2 = Exercicio.buscarExercicio(exercicio);
                    e1.setCodExercicio(e2.getCodExercicio());
                    e1.cadastrarEquipamentos();
                    lblSaida.setText("Equipamento cadastrado com sucesso");
                } else {
                    lblSaida.setText("Exercício não encontrado.");
                }
            } else {
                lblSaida.setText("Equipamento já existente");
            }
        } else {
            lblSaida.setText("Campos em branco ou quantidade de equipamentos inválida");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInserirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInserir;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblExercicio;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblSaida;
    private javax.swing.JSpinner spQuantidade;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtExercicio;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
