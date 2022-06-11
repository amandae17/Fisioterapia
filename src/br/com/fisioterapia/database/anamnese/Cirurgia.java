package br.com.fisioterapia.database.anamnese;

import br.com.fisioterapia.database.utilitarios.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Icaro
 */
public class Cirurgia {

    private int idCirurgia;
    private int idAnamnese;
    private String causa;
    private LocalDate data;
    private String local;

    public Cirurgia(int idCirurgia, int idAnamnese, String causa, LocalDate data, String local) {
        this.idCirurgia = idCirurgia;
        this.idAnamnese = idAnamnese;
        this.causa = causa;
        this.data = data;
        this.local = local;
    }

    public Cirurgia(int idAnamnese, String causa, LocalDate data, String local) {
        this.idAnamnese = idAnamnese;
        this.causa = causa;
        this.data = data;
        this.local = local;
    }

    public int getIdCirurgia() {
        return idCirurgia;
    }

    public void setIdCirurgia(int idCirurgia) {
        this.idCirurgia = idCirurgia;
    }

    public int getIdAnamnese() {
        return idAnamnese;
    }

    public void setIdAnamnese(int idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    ////////////Método para cadastrar cirurgia
    public void cadastrarCirurgia() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("INSERT INTO cirurgia(idanamnese,causa,data,local) VALUES(" + this.getIdAnamnese() + ",'" + this.getCausa() + "','" + this.getData().toString() + "','" + this.getLocal() + "')");
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//////////////////

//////////////Método para buscar as cirurgias pelo id da anamnese    
    public static Cirurgia buscarCirurgiaIdAnamnese(int idAnamnese) {
        Banco b = new Banco();
        int idCirurgia = 0;
        LocalDate dataCirurgia = LocalDate.now();
        String causaCirurgia = "";
        String localCirurgia = "";

        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT * FROM cirurgia WHERE '" + idAnamnese + "'=idanamnese";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();

            String idCirurgia1 = resultado.getString(1);
            idCirurgia = Integer.valueOf(idCirurgia1);

            causaCirurgia = resultado.getString(3);

            String dataCirurgia1 = resultado.getString(4);
            dataCirurgia = LocalDate.parse(dataCirurgia1, DateTimeFormatter.ofPattern("uuuu-MM-dd"));

            localCirurgia = resultado.getString(5);

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        Cirurgia c1 = new Cirurgia(idCirurgia, idAnamnese, causaCirurgia, dataCirurgia, localCirurgia);
        return c1;
    }
//////////////////////

////////////Método para atualizar a cirurgia
    public void atualizarCirurgia() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("UPDATE cirurgia SET causa='" + this.getCausa() + "',data='" + this.getData().toString() + "',local= '" + this.getLocal() + "' WHERE idanamnese=" + this.getIdAnamnese());
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//////////////////    
}
