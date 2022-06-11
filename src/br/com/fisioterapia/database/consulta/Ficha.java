package br.com.fisioterapia.database.consulta;


import br.com.fisioterapia.database.utilitarios.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ficha {

    private String descricao;
    private int idFicha;
    private int idConsulta;
    private int codExercicio;

    public Ficha(String descricao) {
        this.descricao = descricao;
    }

    public Ficha(String descricao, int idConsulta, int codExercicio) {
        this.descricao = descricao;
        this.idConsulta = idConsulta;
        this.codExercicio = codExercicio;
    }

    public Ficha(String descricao, int idFicha, int idConsulta, int codExercicio) {
        this.descricao = descricao;
        this.idFicha = idFicha;
        this.idConsulta = idConsulta;
        this.codExercicio = codExercicio;
    }

    public Ficha() {

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getCodExercicio() {
        return codExercicio;
    }

    public void setCodExercicio(int codExercicio) {
        this.codExercicio = codExercicio;
    }
    
/////////////////Cadastrar ficha    
    public void cadastrarFicha() {

        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("INSERT INTO ficha(descricao,idconsulta,codexercicios) VALUES('" + this.getDescricao() + "'," + this.getIdConsulta() + "," + this.getCodExercicio() + ")");
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/////////////////////////////////////

/////////////////////////Verificar ficha
    public boolean verificarFicha() {
        int qtdFicha = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT COUNT(codficha) from ficha WHERE ficha.idconsulta=" + this.getIdConsulta();
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdFicha1 = resultado.getString(1);
            qtdFicha = Integer.valueOf(qtdFicha1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return qtdFicha != 0;
    }
////////////////////////////////////
    
//////////////////Buscar ficha pelo id da consulta
public static Ficha buscarFichaIdConsulta(int idConsulta){
    
        
        int codFicha = 0;
        String descricao = "";
        int codExercicios = 0;
        
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT * FROM ficha WHERE idconsulta = " + idConsulta;
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            
            String codFicha1 = resultado.getString(1);
            codFicha = Integer.valueOf(codFicha1);

            descricao = resultado.getString(2);            

            String codExercicios1 = resultado.getString(4);
            codExercicios = Integer.valueOf(codExercicios1);

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        Ficha ficha = new Ficha(descricao, codFicha, idConsulta, codExercicios);
        return ficha;    
    
    }        
///////////////////////////////////////////////
    
}
