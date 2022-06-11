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
public class Tabagismo {

    private int idTabagismo;
    private int idAnamnese;
    private LocalDate dataTabagismo;
    private String tipo;

    public Tabagismo(int idTabagismo, int idAnamnese, LocalDate dataTabagismo, String tipo) {
        this.idTabagismo = idTabagismo;
        this.idAnamnese = idAnamnese;
        this.dataTabagismo = dataTabagismo;
        this.tipo = tipo;
    }

    public Tabagismo(int idAnamnese, LocalDate dataTabagismo, String tipo) {
        this.idAnamnese = idAnamnese;
        this.dataTabagismo = dataTabagismo;
        this.tipo = tipo;
    }

    public int getIdTabagismo() {
        return idTabagismo;
    }

    public void setIdTabagismo(int idTabagismo) {
        this.idTabagismo = idTabagismo;
    }

    public int getIdAnamnese() {
        return idAnamnese;
    }

    public void setIdAnamnese(int idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    public LocalDate getDataTabagismo() {
        return dataTabagismo;
    }

    public void setDataTabagismo(LocalDate dataTabagismo) {
        this.dataTabagismo = dataTabagismo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    ///////////////Cadastra o tabagismo de uma anamnese
    public void cadastrarTabagismo() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("INSERT INTO tabagismo(idanamnese,desde,tipo) VALUES(" + this.getIdAnamnese() + ",'" + this.getDataTabagismo().toString() + "','" + this.getTipo() + "')");
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//////////////////////

/////////////////////// Busca os dados de tabagismo com base em um id de anamnese    
    public static Tabagismo buscarTabagismoIdAnamnese(int idAnamnese) {

        Banco b = new Banco();
        int idTabagismo = 0;
        LocalDate dataTabagismo = LocalDate.now();
        String tipoTabagismo = "";

        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT * FROM tabagismo WHERE '" + idAnamnese + "'=idanamnese";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();

            String idTabagismo1 = resultado.getString(1);
            idTabagismo = Integer.valueOf(idTabagismo1);

            String dataTabagismo1 = resultado.getString(3);
            dataTabagismo = LocalDate.parse(dataTabagismo1, DateTimeFormatter.ofPattern("uuuu-MM-dd"));

            tipoTabagismo = resultado.getString(4);

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        Tabagismo t1 = new Tabagismo(idTabagismo, idAnamnese, dataTabagismo, tipoTabagismo);
        return t1;
    }
    //////////////   

///////////////////////////Update do tabagismo
    public void atualizarTabagismo() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("UPDATE tabagismo SET desde='" + this.getDataTabagismo().toString() + "',tipo='" + this.getTipo() + "' WHERE idanamnese=" + this.getIdAnamnese());
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
///////////////////////////////////////
}
