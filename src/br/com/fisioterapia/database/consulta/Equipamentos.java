package br.com.fisioterapia.database.consulta;


import br.com.fisioterapia.database.utilitarios.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Equipamentos {

    private String nome;
    private int quantidade;
    private int codEquipamento;
    private int codExercicio;
    private String descricao;

    public Equipamentos(String nome) {
        this.nome = nome;
    }

    public Equipamentos(String nome, int quantidade, int codEquipamento, int codExercicio, String descricao) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.codEquipamento = codEquipamento;
        this.codExercicio = codExercicio;
        this.descricao = descricao;
    }

    public Equipamentos(String nome, int quantidade, int codExercicio, String descricao) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.codExercicio = codExercicio;
        this.descricao = descricao;
    }

    public Equipamentos() {

    }

    public Equipamentos(String nome, int quantidade, String descricao) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodEquipamento() {
        return codEquipamento;
    }

    public void setCodEquipamento(int codEquipamento) {
        this.codEquipamento = codEquipamento;
    }

    public int getCodExercicio() {
        return codExercicio;
    }

    public void setCodExercicio(int codExercicio) {
        this.codExercicio = codExercicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    ///////////Método para cadastrar Equipamentos
    public void cadastrarEquipamentos() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("INSERT INTO equipamentos(codexercicios, nomeequipamento, quantidade,descricao) VALUES(" + this.getCodExercicio() + ",'" + this.getNome() + "'," + this.getQuantidade() + ",'" + this.getDescricao() + "')");
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    ///////////////////////////////

    /////////////Buscar Equipamentos pelo nome
    public static Equipamentos buscarEquipamento(String nome1) {
        int codEquipamento = 0;
        int codExercicio = 0;
        String nome = "";
        String descricao = "";
        int quantidade = 0;

        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT * FROM equipamentos WHERE '" + nome1 + "'=nomeequipamento";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();

            String codEquipamento1 = resultado.getString(1);
            codEquipamento = Integer.valueOf(codEquipamento1);

            String codExercicio1 = resultado.getString(2);
            codExercicio = Integer.valueOf(codExercicio1);

            nome = resultado.getString(3);

            String quantidade1 = resultado.getString(4);
            quantidade = Integer.valueOf(quantidade1);

            descricao = resultado.getString(5);

            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Equipamentos e1 = new Equipamentos(nome, quantidade, codEquipamento, codExercicio, descricao);
        return e1;
    }
////////////////////////////////////////

////////////////////////////////Verificar equipamento
    public boolean verificarNomeEquipamento() {
        int qtdEquipamento = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT count(idequipamento) FROM equipamentos WHERE '" + this.getNome() + "'=nomeequipamento";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdEquipamento1 = resultado.getString(1);
            qtdEquipamento = Integer.valueOf(qtdEquipamento1);
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qtdEquipamento != 0;
    }
////////////////////////////////////////////////////////////////qqq

/////////////////////////Update equipamento    
    public void updateEquipamento() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("UPDATE equipamentos SET nomeequipamento = '" + this.getNome() + "',quantidade = " + this.getQuantidade() + ",descricao = '" + this.getDescricao() + "' WHERE idequipamento=" + this.getCodEquipamento());
            comando.executeUpdate("UPDATE equipamentos SET codexercicios = " + this.getCodExercicio() + " WHERE idequipamento=" + this.getCodEquipamento());
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
////////////////////////////////////////////
}
