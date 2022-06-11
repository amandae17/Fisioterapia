package br.com.fisioterapia.database.anamnese;

import br.com.fisioterapia.database.utilitarios.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Anamnese {

    private int idAnamnese;
    private int idPessoa;
    private float peso;
    private float altura;
    private String tabagista;
    private String etilista;
    private String doencaInfancia;
    private String doencaPrevia;

    public Anamnese(int idPessoa, float peso, float altura, String tabagista, String etilista, String doencaInfancia, String doencaPrevia) {
        this.idPessoa = idPessoa;
        this.peso = peso;
        this.altura = altura;
        this.tabagista = tabagista;
        this.etilista = etilista;
        this.doencaInfancia = doencaInfancia;
        this.doencaPrevia = doencaPrevia;
    }

    public Anamnese(int idAnamnese, int idPessoa, float peso, float altura, String tabagista, String etilista, String doencaInfancia, String doencaPrevia) {
        this.idAnamnese = idAnamnese;
        this.idPessoa = idPessoa;
        this.peso = peso;
        this.altura = altura;
        this.tabagista = tabagista;
        this.etilista = etilista;
        this.doencaInfancia = doencaInfancia;
        this.doencaPrevia = doencaPrevia;
    }

    public int getIdAnamnese() {
        return idAnamnese;
    }

    public void setIdAnamnese(int idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getTabagista() {
        return tabagista;
    }

    public void setTabagista(String tabagista) {
        this.tabagista = tabagista;
    }

    public String getEtilista() {
        return etilista;
    }

    public void setEtilista(String etilista) {
        this.etilista = etilista;
    }

    public String getDoencaInfancia() {
        return doencaInfancia;
    }

    public void setDoencaInfancia(String doencaInfancia) {
        this.doencaInfancia = doencaInfancia;
    }

    public String getDoencaPrevia() {
        return doencaPrevia;
    }

    public void setDoencaPrevia(String doencaPrevia) {
        this.doencaPrevia = doencaPrevia;
    }

/////////Verificar se anamnese existe
    public boolean verificarAnamnese() {
        int idPessoa2 = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT COUNT(idanamnese) from anamnese WHERE anamnese.codpessoa=" + this.idPessoa;
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String idPessoa1 = resultado.getString(1);
            idPessoa2 = Integer.valueOf(idPessoa1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return idPessoa2 != 0;
    }
/////////////////    
//////////////////////////Cadastrar Anamnese

    public void cadastrarAnamnese() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("INSERT INTO anamnese(codpessoa,peso,altura,tabagista,etilista,doencainf,doencaprev) VALUES(" + this.getIdPessoa() + "," + this.getPeso() + "," + this.getAltura() + ",'" + this.getTabagista() + "','" + this.getEtilista() + "','" + this.getDoencaInfancia() + "','" + this.getDoencaPrevia() + "')");
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//////////////////////////

    /////////////////Buscar Anamnese pelo id da pessoa
    public static Anamnese buscarAnamneseIdPessoa(int idPessoa) {
        int idAnamnese = 0;
        float peso = 0;
        float altura = 0;
        String tabagista = "";
        String etilista = "";
        String doencaInf = "";
        String doencaPre = "";

        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT * FROM anamnese WHERE '" + idPessoa + "'=codpessoa";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();

            idAnamnese = Integer.valueOf(resultado.getString(1));
            peso = Float.valueOf(resultado.getString(3));
            altura = Float.valueOf(resultado.getString(4));
            tabagista = resultado.getString(5);
            etilista = resultado.getString(6);
            doencaInf = resultado.getString(7);
            doencaPre = resultado.getString(8);

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }

        Anamnese a1 = new Anamnese(idAnamnese, idPessoa, peso, altura, tabagista, etilista, doencaInf, doencaPre);
        return a1;
    }
////////////////////////

///////////Verificar Cirurgia
    public boolean verificarCirurgia() {
        int qtdIdAnamnese = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "select count(idanamnese) from cirurgia where idanamnese=" + this.idAnamnese;
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String idPessoa1 = resultado.getString(1);
            qtdIdAnamnese = Integer.valueOf(idPessoa1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return qtdIdAnamnese != 0;
    }
///////////////////

//////////Verificar se o paciente possui anamnese
    public static boolean verificarAnamnese(long cpfB) {
        int qtdIdAnamnese = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "select count(anamnese.codpessoa) from pessoa,anamnese where pessoa.codpessoa=anamnese.codpessoa AND cpf=" + cpfB;
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String idPessoa1 = resultado.getString(1);
            qtdIdAnamnese = Integer.valueOf(idPessoa1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return qtdIdAnamnese != 0;
    }
///////////

/////////////////////Atualizar Anamnese
    public void atualizarAnamnese() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("UPDATE anamnese SET peso=" + this.getPeso() + ",altura=" + this.getAltura() + ",tabagista='" + this.getTabagista() + "',etilista='" + this.getEtilista() + "',doencainf='" + this.getDoencaInfancia() + "',doencaprev= '" + this.getDoencaPrevia() + "' WHERE codpessoa = " + this.getIdPessoa());
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//////////////////////////// 
}
