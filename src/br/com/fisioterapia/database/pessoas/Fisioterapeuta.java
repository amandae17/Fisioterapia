package br.com.fisioterapia.database.pessoas;


import br.com.fisioterapia.database.utilitarios.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Icaro
 */
public class Fisioterapeuta extends Pessoa {

    private int codFisioterapeuta;
    private String crefito;
    private String usuario;
    private String senha;

    public Fisioterapeuta(int codFisioterapeuta, String crefito, String usuario, String senha, int codPessoa, String nome, long cpf, String rg, long telefone, String email, String endereco) {
        super(codPessoa, nome, cpf, rg, telefone, email, endereco);
        this.codFisioterapeuta = codFisioterapeuta;
        this.crefito = crefito;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Fisioterapeuta(String crefito, String usuario, String senha, String nome, long cpf, String rg, long telefone, String email, String endereco) {
        super(nome, cpf, rg, telefone, email, endereco);
        this.crefito = crefito;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Fisioterapeuta(String crefito, String usuario, String senha, int codPessoa, String nome, long cpf, String rg, long telefone, String email, String endereco) {
        super(codPessoa, nome, cpf, rg, telefone, email, endereco);
        this.crefito = crefito;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Fisioterapeuta(long cpf) {
        super(cpf);
    }

    public int getCodFisioterapeuta() {
        return codFisioterapeuta;
    }

    public void setCodFisioterapeuta(int codFisioterapeuta) {
        this.codFisioterapeuta = codFisioterapeuta;
    }

    public String getCrefito() {
        return crefito;
    }

    public void setCrefito(String crefito) {
        this.crefito = crefito;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

///////////////Verificar CPF
    public boolean verificarCpf() {
        int qtdPessoa = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT count(codpessoa) FROM pessoa WHERE '" + this.getCpf() + "'=cpf";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdPessoa1 = resultado.getString(1);
            qtdPessoa = Integer.valueOf(qtdPessoa1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return qtdPessoa != 0;
    }
///////////////////////////

///////////////Verificar usuario
    public boolean verificarUsuario() {
        int qtdUsuario = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT(SELECT COUNT(usuario) FROM fisioterapeuta WHERE usuario='" + this.getUsuario() + "')+(SELECT COUNT(usuario) FROM proprietario WHERE usuario='" + this.getUsuario() + "')";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdUsuario1 = resultado.getString(1);
            qtdUsuario = Integer.valueOf(qtdUsuario1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return qtdUsuario != 0;
    }
/////////////////////////////////////////     

////////////////////Verificar Crefito
    public boolean verificarCrefito() {
        int qtdCrefito = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT count(crefito) FROM fisioterapeuta WHERE crefito = '" + this.getCrefito() + "'";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdCrefito1 = resultado.getString(1);
            qtdCrefito = Integer.valueOf(qtdCrefito1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return qtdCrefito != 0;
    }
/////////////////////////     

//////////Cadastrar pessoa fisioterapeuta
    public void cadastrarPessoaFisioterapeuta() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("INSERT INTO pessoa(nome,cpf,rg,telefone,email,endereco) VALUES('" + this.getNome() + "'," + this.getCpf() + ",'" + this.getRg() + "'," + this.getTelefone() + ",'" + this.getEmail() + "','" + this.getEndereco() + "')");
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
///////////////////////////////////////////

////////////////Buscar Código da pessoa:
    public int buscarCodPessoa(long cpf) {
        int codPessoa = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT codpessoa FROM pessoa WHERE '" + this.getCpf() + "'=cpf";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String codPessoa1 = resultado.getString(1);
            codPessoa = Integer.valueOf(codPessoa1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return codPessoa;
    }

/////////////////
///////////////////Cadastrar Fisioterapeuta    
    public void cadastrarFisioterapeuta() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("INSERT INTO fisioterapeuta(codpessoa,crefito,usuario,senha) VALUES(" + this.getCodPessoa() + ",'" + this.getCrefito() + "','" + this.getUsuario() + "','" + this.getSenha() + "')");
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
////////////////////////    

//////////////////////Verificar fisioterapeuta
    public boolean verificarFisioterapeuta() {
        int qtdFisioterapeuta = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "select count(cpf) from pessoa,fisioterapeuta where pessoa.cpf=" + this.getCpf() + " and pessoa.codpessoa=fisioterapeuta.codpessoa;";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdFisioterapeuta1 = resultado.getString(1);
            qtdFisioterapeuta = Integer.valueOf(qtdFisioterapeuta1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return qtdFisioterapeuta != 0;
    }
////////////////////////////////////////

/////////////////////Buscar fisioterapeuta
    public static Fisioterapeuta buscarFisioterapeuta(long cpf) {
        int codFisioterapeuta = 0;
        String crefito = "";
        String usuario = "";
        String senha = "";
        int codPessoa = 0;
        String nome = "";
        String rg = "";
        long telefone = 0;
        String email = "";
        String endereco = "";

        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = " select * from pessoa,fisioterapeuta where pessoa.cpf=" + cpf + " and pessoa.codpessoa=fisioterapeuta.codpessoa;";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();

            String codPessoa1 = resultado.getString(1);
            codPessoa = Integer.valueOf(codPessoa1);

            nome = resultado.getString(2);

            rg = resultado.getString(4);

            String telefone1 = resultado.getString(5);
            telefone = Long.valueOf(telefone1);

            email = resultado.getString(6);

            endereco = resultado.getString(7);

            String codFisioterapeuta1 = resultado.getString(8);
            codFisioterapeuta = Integer.valueOf(codFisioterapeuta1);

            crefito = resultado.getString(10);

            usuario = resultado.getString(11);

            senha = resultado.getString(12);

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        Fisioterapeuta f1 = new Fisioterapeuta(codFisioterapeuta, crefito, usuario, senha, codPessoa, nome, cpf, rg, telefone, email, endereco);
        return f1;
    }
///////////////////////////

    /////////////////////Buscar fisioterapeuta
    public static Fisioterapeuta buscarFisioterapeutaId(int id) {
        int codFisioterapeuta = 0;
        String crefito = "";
        String usuario = "";
        String senha = "";
        int codPessoa = 0;
        String nome = "";
        String rg = "";
        long telefone = 0;
        String email = "";
        String endereco = "";
        long cpf = 0;

        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = " select * from pessoa,fisioterapeuta where fisioterapeuta.codfisioterapeuta=" + id + " and pessoa.codpessoa=fisioterapeuta.codpessoa;";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();

            String codPessoa1 = resultado.getString(1);
            codPessoa = Integer.valueOf(codPessoa1);

            nome = resultado.getString(2);

            String cpf1 = resultado.getString(3);
            cpf = Long.valueOf(cpf1);

            rg = resultado.getString(4);

            String telefone1 = resultado.getString(5);
            telefone = Long.valueOf(telefone1);

            email = resultado.getString(6);

            endereco = resultado.getString(7);

            String codFisioterapeuta1 = resultado.getString(8);
            codFisioterapeuta = Integer.valueOf(codFisioterapeuta1);

            crefito = resultado.getString(10);

            usuario = resultado.getString(11);

            senha = resultado.getString(12);

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        Fisioterapeuta f1 = new Fisioterapeuta(codFisioterapeuta, crefito, usuario, senha, codPessoa, nome, cpf, rg, telefone, email, endereco);
        return f1;
    }
///////////////////////////

//////////Update do fisioterapeuta
    public void updateFisioterapeuta() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("UPDATE pessoa SET nome = '" + this.getNome() + "',cpf = " + this.getCpf() + ",rg = '" + this.getRg() + "',telefone = " + this.getTelefone() + ",email = '" + this.getEmail() + "',endereco = '" + this.getEndereco() + "' WHERE codpessoa = " + this.getCodPessoa());
            comando.executeUpdate("UPDATE fisioterapeuta SET crefito = '" + this.getCrefito() + "',usuario = '" + this.getUsuario() + "',senha = '" + this.getSenha() + "' WHERE codpessoa = " + this.getCodPessoa());
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

////////////   
////////////Verificar se o login existe na tabela fisioterapeuta    
    public static boolean verfificarLogin(String login) {
        int qtdFisioterapeuta = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "select count(usuario) from fisioterapeuta where usuario='" + login + "'";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdFisioterapeuta1 = resultado.getString(1);
            qtdFisioterapeuta = Integer.valueOf(qtdFisioterapeuta1);
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qtdFisioterapeuta != 0;
    }
/////////////////////////////  

//////////Método para verificar a senha
    public static boolean verfificarSenha(String login, String senha) {
        int qtdProprietario = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT COUNT(codfisioterapeuta) from fisioterapeuta where usuario='" + login + "' and senha='" + senha + "'";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdProprietario1 = resultado.getString(1);
            qtdProprietario = Integer.valueOf(qtdProprietario1);
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qtdProprietario != 0;
    }
////////////////////////////////////////    
}
