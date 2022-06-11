package br.com.fisioterapia.database.consulta;


import br.com.fisioterapia.database.utilitarios.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercicio {

    private String nome;
    private String descricao;
    private int codExercicio;

    public Exercicio(String nome) {
        this.nome = nome;
    }

    public Exercicio(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Exercicio(String nome, String descricao, int codExercicio) {
        this.nome = nome;
        this.descricao = descricao;
        this.codExercicio = codExercicio;
    }

    public Exercicio(int codExercicio) {
        this.codExercicio = codExercicio;
    }

    public Exercicio() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodExercicio() {
        return codExercicio;
    }

    public void setCodExercicio(int codExercicio) {
        this.codExercicio = codExercicio;
    }

//////////////////////Cadastrar exercicio
    public void cadastrarExercicio() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("INSERT INTO exercicios(nomeexercicio,descricao) VALUES('" + this.getNome() + "','" + this.getDescricao() + "')");
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//////////////////////////////////////////

    //////////////////////Buscar exercicio
    public static Exercicio buscarExercicio(String nome1) {
        int codExercicio = 0;
        String nome = "";
        String descricao = "";

        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT * FROM exercicios WHERE '" + nome1 + "'=nomeexercicio";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();

            String codPessoa1 = resultado.getString(1);
            codExercicio = Integer.valueOf(codPessoa1);

            nome = resultado.getString(2);

            descricao = resultado.getString(3);

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }

        Exercicio e1 = new Exercicio(nome, descricao, codExercicio);
        return e1;
    }
////////////////////////////////

    ////////////////Busca exercicio pelo id
    public static Exercicio buscarExercicioId(int codExercicio1) {

        int codExercicio = 0;
        String nome = "";
        String descricao = "";

        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT * FROM exercicios WHERE '" + codExercicio1 + "'=codexercicios";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();

            String codExercicio2 = resultado.getString(1);
            codExercicio = Integer.valueOf(codExercicio2);

            nome = resultado.getString(2);

            descricao = resultado.getString(3);

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }

        Exercicio e1 = new Exercicio(nome, descricao, codExercicio);
        return e1;
    }
    ////////////////

/////////////////Verficar nome do exercicio
    public boolean verificarNomeExercicio() {
        int qtdExercicio = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT count(codexercicios) FROM exercicios WHERE '" + this.getNome() + "'=nomeexercicio";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdExercicio1 = resultado.getString(1);
            qtdExercicio = Integer.valueOf(qtdExercicio1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return qtdExercicio != 0;
    }
////////////////////////////////////////////   

///////////////////Update Exercicio
    public void updateExercicio() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("UPDATE exercicios SET nomeexercicio = '" + this.getNome() + "',descricao = '" + this.getDescricao() + "' WHERE codexercicios=" + this.getCodExercicio());
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/////////////////////////////////////////    

}
