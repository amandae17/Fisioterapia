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
public class Etilista {

    private int idEtilista;
    private int idAnamnese;
    private LocalDate dataEtilista;
    private String tipo;

    public Etilista(int idEtilista, int idAnamnese, LocalDate dataEtilista, String tipo) {
        this.idEtilista = idEtilista;
        this.idAnamnese = idAnamnese;
        this.dataEtilista = dataEtilista;
        this.tipo = tipo;
    }

    public Etilista(int idAnamnese, LocalDate dataEtilista, String tipo) {
        this.idAnamnese = idAnamnese;
        this.dataEtilista = dataEtilista;
        this.tipo = tipo;
    }

    public int getIdEtilista() {
        return idEtilista;
    }

    public void setIdEtilista(int idEtilista) {
        this.idEtilista = idEtilista;
    }

    public int getIdAnamnese() {
        return idAnamnese;
    }

    public void setIdAnamnese(int idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    public LocalDate getDataEtilista() {
        return dataEtilista;
    }

    public void setDataEtilista(LocalDate dataEtilista) {
        this.dataEtilista = dataEtilista;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    ///////////Cadastrar Etilista
    public void cadastrarEtilista() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("INSERT INTO etilista(idanamnese,desde,tipo) VALUES(" + this.getIdAnamnese() + ",'" + this.getDataEtilista().toString() + "','" + this.getTipo() + "')");
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
///////////////////

    /////////////// Buscar etilista pelo id da anamnese
    public static Etilista buscarEtilistaIdAnamnese(int idAnamnese) {
        Banco b = new Banco();
        int idEtilista = 0;
        LocalDate dataEtilista = LocalDate.now();
        String tipoEtilista = "";

        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT * FROM etilista WHERE '" + idAnamnese + "'=idanamnese";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();

            String idTabagismo1 = resultado.getString(1);
            idEtilista = Integer.valueOf(idTabagismo1);

            String dataEtilismo1 = resultado.getString(3);
            dataEtilista = LocalDate.parse(dataEtilismo1, DateTimeFormatter.ofPattern("uuuu-MM-dd"));

            tipoEtilista = resultado.getString(4);

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        Etilista e1 = new Etilista(idEtilista, idAnamnese, dataEtilista, tipoEtilista);
        return e1;
    }
//////////////////////////    

///////////////Atualizar os dados do Etilista
    public void atualizarEtilista() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("UPDATE etilista SET desde='" + this.getDataEtilista().toString() + "',tipo='" + this.getTipo() + "' WHERE idanamnese=" + this.getIdAnamnese());
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
////////////////////////////
}
