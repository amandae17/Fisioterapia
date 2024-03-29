package br.com.fisioterapia.jframe.buscar;

import br.com.fisioterapia.database.consulta.Ficha;
import br.com.fisioterapia.database.consulta.Exercicio;
import br.com.fisioterapia.database.consulta.Consulta;
import br.com.fisioterapia.database.pessoas.Paciente;
import java.beans.PropertyVetoException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
/**
 *
 * @author aevan
 */
public class BuscarFichaJF extends javax.swing.JInternalFrame {

    /**
     * Creates new form BuscarAnameneseJF
     */
    public BuscarFichaJF() {
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

        lblTituloDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        lblTituloNomePaciente = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblBuscarHorario = new javax.swing.JLabel();
        txtBuscarHorario = new javax.swing.JFormattedTextField();
        lblBuscarData = new javax.swing.JLabel();
        txtBuscarData = new javax.swing.JFormattedTextField();
        lblExercicio = new javax.swing.JLabel();
        txtExercicio = new javax.swing.JTextField();
        lblSaida = new javax.swing.JLabel();
        txtNomePaciente = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Última Ficha");
        setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        lblTituloDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTituloDescricao.setText("Descrição:");
        getContentPane().add(lblTituloDescricao);
        lblTituloDescricao.setBounds(20, 200, 65, 40);

        txtDescricao.setEditable(false);
        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 210, 300, 130);

        lblTituloNomePaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTituloNomePaciente.setText("Paciente:");
        getContentPane().add(lblTituloNomePaciente);
        lblTituloNomePaciente.setBounds(20, 160, 60, 30);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(190, 120, 80, 30);

        lblBuscarHorario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBuscarHorario.setText("Horário da consulta:");
        getContentPane().add(lblBuscarHorario);
        lblBuscarHorario.setBounds(20, 60, 130, 41);

        try {
            txtBuscarHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtBuscarHorario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarHorarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscarHorario);
        txtBuscarHorario.setBounds(160, 60, 80, 40);

        lblBuscarData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBuscarData.setText("Data da consulta:");
        getContentPane().add(lblBuscarData);
        lblBuscarData.setBounds(20, 10, 120, 41);

        try {
            txtBuscarData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtBuscarData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarDataActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscarData);
        txtBuscarData.setBounds(150, 20, 90, 30);

        lblExercicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblExercicio.setText("Exercicio:");
        getContentPane().add(lblExercicio);
        lblExercicio.setBounds(10, 360, 70, 25);

        txtExercicio.setEditable(false);
        getContentPane().add(txtExercicio);
        txtExercicio.setBounds(100, 360, 241, 30);
        getContentPane().add(lblSaida);
        lblSaida.setBounds(50, 440, 330, 20);

        txtNomePaciente.setEditable(false);
        getContentPane().add(txtNomePaciente);
        txtNomePaciente.setBounds(100, 160, 241, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        LocalDate dataConsulta;
        Duration duracao;
        long diferencaData;

        String t1 = txtBuscarHorario.getText();
        LocalTime horarioConsulta;
        try {
            dataConsulta = LocalDate.parse(txtBuscarData.getText(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
            try {
                horarioConsulta = LocalTime.parse(t1);
                Consulta c1 = new Consulta(dataConsulta, horarioConsulta);
                if (c1.verificarConsulta()) {//Método para verificar se já existe consulta marcada nesse horário
                    c1 = Consulta.buscarConsulta(dataConsulta, horarioConsulta);
                    Paciente p1 = Paciente.buscarPacienteId(c1.getCodPessoa());
                    txtNomePaciente.setText(p1.getNome());
                    Ficha f1 = Ficha.buscarFichaIdConsulta(c1.getIdConsulta());
                    Exercicio e1 = Exercicio.buscarExercicioId(f1.getCodExercicio());
                    txtDescricao.setText(f1.getDescricao());
                    txtExercicio.setText(e1.getNome());
                    lblSaida.setText("ficha encontrada");
                } else {
                    lblSaida.setText("Não existe uma consulta marcada nesse dia e horário.");
                }
            } catch (DateTimeParseException e) {
                lblSaida.setText("Horário inválido");
            }
        } catch (DateTimeParseException e) {
            lblSaida.setText("Data inválida");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarHorarioActionPerformed

    private void txtBuscarDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscarData;
    private javax.swing.JLabel lblBuscarHorario;
    private javax.swing.JLabel lblExercicio;
    private javax.swing.JLabel lblSaida;
    private javax.swing.JLabel lblTituloDescricao;
    private javax.swing.JLabel lblTituloNomePaciente;
    private javax.swing.JFormattedTextField txtBuscarData;
    private javax.swing.JFormattedTextField txtBuscarHorario;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtExercicio;
    private javax.swing.JTextField txtNomePaciente;
    // End of variables declaration//GEN-END:variables
}
