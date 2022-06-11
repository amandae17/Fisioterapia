package br.com.fisioterapia.jframe.buscar;

import br.com.fisioterapia.database.pessoas.Paciente;
import java.beans.PropertyVetoException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
/**
 *
 * @author aevan
 */
public class BuscarPacienteJF extends javax.swing.JInternalFrame {

    /**
     * Creates new form BuscarPacienteJF
     */
    public BuscarPacienteJF() {
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

        lblCpfPacienteBuscaTitulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblNomeTitulo = new javax.swing.JLabel();
        lblCpfTitulo = new javax.swing.JLabel();
        lblRgTitulo = new javax.swing.JLabel();
        lblEnderecoTitulo = new javax.swing.JLabel();
        lblTelefoneTitulo = new javax.swing.JLabel();
        lblEmailTitulo = new javax.swing.JLabel();
        txtCpfPacienteBusca = new javax.swing.JFormattedTextField();
        lblSaida = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCpfPaciente = new javax.swing.JFormattedTextField();
        txtRg = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Buscar Paciente");
        setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        lblCpfPacienteBuscaTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCpfPacienteBuscaTitulo.setText("CPF do Paciente:");
        getContentPane().add(lblCpfPacienteBuscaTitulo);
        lblCpfPacienteBuscaTitulo.setBounds(10, 30, 120, 32);

        jButton1.setText("Procurar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 80, 100, 30);

        lblNomeTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomeTitulo.setText("Nome:");
        getContentPane().add(lblNomeTitulo);
        lblNomeTitulo.setBounds(20, 120, 60, 30);

        lblCpfTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCpfTitulo.setText("CPF:");
        getContentPane().add(lblCpfTitulo);
        lblCpfTitulo.setBounds(20, 170, 40, 20);

        lblRgTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRgTitulo.setText("RG:");
        getContentPane().add(lblRgTitulo);
        lblRgTitulo.setBounds(20, 210, 30, 20);

        lblEnderecoTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEnderecoTitulo.setText("Endereço:");
        getContentPane().add(lblEnderecoTitulo);
        lblEnderecoTitulo.setBounds(20, 250, 63, 20);

        lblTelefoneTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTelefoneTitulo.setText("Telefone:");
        getContentPane().add(lblTelefoneTitulo);
        lblTelefoneTitulo.setBounds(20, 290, 60, 20);

        lblEmailTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmailTitulo.setText("E-mail:");
        getContentPane().add(lblEmailTitulo);
        lblEmailTitulo.setBounds(20, 330, 50, 20);

        try {
            txtCpfPacienteBusca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfPacienteBusca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCpfPacienteBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfPacienteBuscaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCpfPacienteBusca);
        txtCpfPacienteBusca.setBounds(140, 30, 120, 30);
        getContentPane().add(lblSaida);
        lblSaida.setBounds(20, 360, 400, 20);

        txtNome.setEditable(false);
        getContentPane().add(txtNome);
        txtNome.setBounds(110, 120, 248, 29);

        txtEndereco.setEditable(false);
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });
        getContentPane().add(txtEndereco);
        txtEndereco.setBounds(110, 240, 360, 29);

        txtEmail.setEditable(false);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail);
        txtEmail.setBounds(110, 320, 248, 29);

        txtCpfPaciente.setEditable(false);
        try {
            txtCpfPaciente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfPaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCpfPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfPacienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtCpfPaciente);
        txtCpfPaciente.setBounds(110, 160, 120, 30);

        txtRg.setEditable(false);
        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AA.AAA.AAA-A")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtRg);
        txtRg.setBounds(110, 200, 120, 30);

        txtTelefone.setEditable(false);
        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(110, 280, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpfPacienteBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfPacienteBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfPacienteBuscaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cpfB1[] = txtCpfPacienteBusca.getText().split("-");
        String cpfB2[] = cpfB1[0].split("\\.");
        String testeCpfB = cpfB2[0] + cpfB2[1] + cpfB2[2] + cpfB1[1];
        long cpfB;

        if (!testeCpfB.isBlank()) {
            cpfB = Long.parseLong(testeCpfB);
            Paciente p1 = new Paciente(cpfB);
            if (p1.verificarCpf()) {
                p1 = Paciente.BuscarPaciente(cpfB);
                txtNome.setText(p1.getNome());
                txtCpfPaciente.setText(String.valueOf(p1.getCpf()));
                txtRg.setText(p1.getRg());
                txtEndereco.setText(p1.getEndereco());
                txtTelefone.setText(String.valueOf(p1.getTelefone()));
                txtEmail.setText(p1.getEmail());
                lblSaida.setText("Paciente encontrado");
            } else {
                lblSaida.setText("Cpf não encontrado");
            }

        } else {
            lblSaida.setText("Campo em branco");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtCpfPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfPacienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCpfPacienteBuscaTitulo;
    private javax.swing.JLabel lblCpfTitulo;
    private javax.swing.JLabel lblEmailTitulo;
    private javax.swing.JLabel lblEnderecoTitulo;
    private javax.swing.JLabel lblNomeTitulo;
    private javax.swing.JLabel lblRgTitulo;
    private javax.swing.JLabel lblSaida;
    private javax.swing.JLabel lblTelefoneTitulo;
    private javax.swing.JFormattedTextField txtCpfPaciente;
    private javax.swing.JFormattedTextField txtCpfPacienteBusca;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}