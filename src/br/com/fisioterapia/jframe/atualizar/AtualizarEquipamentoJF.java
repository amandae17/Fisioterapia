package br.com.fisioterapia.jframe.atualizar;

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
public class AtualizarEquipamentoJF extends javax.swing.JInternalFrame {

    public static int codEquipamento = 0;

    /**
     * Creates new form AtualizarEquipamentoJF
     */
    public AtualizarEquipamentoJF() {
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

        lblBuscarNome = new javax.swing.JLabel();
        txtBuscarNome = new javax.swing.JTextField();
        lblQuantidade = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        btnAtualizar = new javax.swing.JButton();
        lblDescricao = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblSaida = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtExercicio = new javax.swing.JTextField();
        lblExercicio = new javax.swing.JLabel();
        spQuantidade = new javax.swing.JSpinner();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Atualizar Equipamento");
        setPreferredSize(new java.awt.Dimension(500, 500));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                zerarVariaveis(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(null);

        lblBuscarNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBuscarNome.setText("Nome");
        getContentPane().add(lblBuscarNome);
        lblBuscarNome.setBounds(20, 20, 48, 25);
        getContentPane().add(txtBuscarNome);
        txtBuscarNome.setBounds(75, 17, 249, 30);

        lblQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuantidade.setText("Quantidade:");
        getContentPane().add(lblQuantidade);
        lblQuantidade.setBounds(20, 290, 80, 30);

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 170, 236, 100);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar);
        btnAtualizar.setBounds(140, 380, 83, 35);

        lblDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescricao.setText("Descrição:");
        getContentPane().add(lblDescricao);
        lblDescricao.setBounds(20, 170, 70, 30);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(140, 60, 80, 30);
        getContentPane().add(lblSaida);
        lblSaida.setBounds(20, 430, 350, 20);

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("Nome");
        getContentPane().add(lblNome);
        lblNome.setBounds(30, 120, 48, 25);
        getContentPane().add(txtNome);
        txtNome.setBounds(90, 115, 249, 30);
        getContentPane().add(txtExercicio);
        txtExercicio.setBounds(100, 340, 249, 30);

        lblExercicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblExercicio.setText("Exercicio:");
        getContentPane().add(lblExercicio);
        lblExercicio.setBounds(20, 340, 80, 30);

        spQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(spQuantidade);
        spQuantidade.setBounds(100, 290, 60, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String buscarNome = txtBuscarNome.getText();

        if (!buscarNome.isBlank()) {
            Equipamentos e1 = new Equipamentos(buscarNome);
            if (e1.verificarNomeEquipamento()) { //Para saber se é um fisioterapeuta,paciente ou Proprietario.  
                e1 = Equipamentos.buscarEquipamento(buscarNome);
                txtNome.setText(e1.getNome());
                txtDescricao.setText(e1.getDescricao());
                spQuantidade.setValue(e1.getQuantidade());
                Exercicio e2 = Exercicio.buscarExercicioId(e1.getCodExercicio());
                txtExercicio.setText(e2.getNome());
                AtualizarEquipamentoJF.codEquipamento = e1.getCodEquipamento();
                lblSaida.setText("Equipamento encontrado");

            } else {
                lblSaida.setText("Equipamento não encontrado!!!");
            }

        } else {
            lblSaida.setText("Campo de busca em branco");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void zerarVariaveis(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_zerarVariaveis
        AtualizarEquipamentoJF.codEquipamento = 0;
        // TODO add your handling code here:
    }//GEN-LAST:event_zerarVariaveis

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        String nome = txtNome.getText();
        String descricao = txtDescricao.getText();
        int quantidade = Integer.valueOf(String.valueOf(spQuantidade.getValue()));
        String exercicio = "";

        if (AtualizarEquipamentoJF.codEquipamento > 0) {
            if (!nome.isBlank() && !descricao.isBlank() && quantidade > 0) {
                Equipamentos e1 = new Equipamentos(nome, quantidade, descricao);
                exercicio = txtExercicio.getText();
                Exercicio e2 = new Exercicio(exercicio);
                if (e2.verificarNomeExercicio()) {
                    e2 = Exercicio.buscarExercicio(exercicio);
                    e1.setCodExercicio(e2.getCodExercicio());
                    e1.setCodEquipamento(AtualizarEquipamentoJF.codEquipamento);
                    e1.updateEquipamento();
                    AtualizarEquipamentoJF.codEquipamento = 0;
                    lblSaida.setText("Equipamento atualizado com sucesso");
                } else {
                    lblSaida.setText("Exercício não encontrado.");
                }
            } else {
                lblSaida.setText("Campos em branco ou quantidade inválida");
            }
        } else {
            lblSaida.setText("Pesquise um equipamento antes de atualizar");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscarNome;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblExercicio;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblSaida;
    private javax.swing.JSpinner spQuantidade;
    private javax.swing.JTextField txtBuscarNome;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtExercicio;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
