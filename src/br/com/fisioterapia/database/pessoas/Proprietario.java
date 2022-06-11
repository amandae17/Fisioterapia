package br.com.fisioterapia.database.pessoas;


import br.com.fisioterapia.database.utilitarios.Banco;
import br.com.fisioterapia.database.pessoas.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Proprietario extends Pessoa {

    private long cnpj;
    private int codProprietario;
    private String login;
    private String senha;

    public Proprietario(long cnpj, String login, String senha, String nome, long cpf, String rg, long telefone, String email, String endereco) {
        super(nome, cpf, rg, telefone, email, endereco);
        this.cnpj = cnpj;
        this.login = login;
        this.senha = senha;
    }

    public Proprietario(long cnpj, String login, String senha) {
        this.cnpj = cnpj;
        this.login = login;
        this.senha = senha;
    }

    public Proprietario(long cnpj, int codProprietario, String login, String senha, int codPessoa, String nome, long cpf, String rg, long telefone, String email, String endereco) {
        super(codPessoa, nome, cpf, rg, telefone, email, endereco);
        this.cnpj = cnpj;
        this.codProprietario = codProprietario;
        this.login = login;
        this.senha = senha;
    }

    public Proprietario(long cnpj, String login, String senha, int codPessoa, String nome, long cpf, String rg, long telefone, String email, String endereco) {
        super(codPessoa, nome, cpf, rg, telefone, email, endereco);
        this.cnpj = cnpj;
        this.login = login;
        this.senha = senha;
    }

    public Proprietario(long cpf) {
        super(cpf);
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCodProprietario() {
        return codProprietario;
    }

    public void setCodProprietario(int codProprietario) {
        this.codProprietario = codProprietario;
    }

    //////////////Verifica se o cpf já existe no banco
    public boolean verificarCpf() {
        int qtdPessoa = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT count(codpessoa) FROM pessoa WHERE " + this.getCpf() + "=cpf";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdPessoa1 = resultado.getString(1);
            qtdPessoa = Integer.valueOf(qtdPessoa1);
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qtdPessoa != 0;
    }
////////////////////////////////

    ///////////Verifica se exite o cnpj já cadastrado no banco
    public boolean verificarCNPJ() {
        int qtdCnpj = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT count(CNPJ) FROM proprietario WHERE " + this.getCnpj() + "=CNPJ";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdCnpj1 = resultado.getString(1);
            qtdCnpj = Integer.valueOf(qtdCnpj1);
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qtdCnpj != 0;
    }
///////////////////

///////////Verifica se existe este usuário
    public boolean verificarUsuario() {
        int qtdUsuario = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT(SELECT COUNT(usuario) FROM fisioterapeuta WHERE usuario='" + this.getLogin() + "')+(SELECT COUNT(usuario) FROM proprietario WHERE usuario='" + this.getLogin() + "')";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdUsuario1 = resultado.getString(1);
            qtdUsuario = Integer.valueOf(qtdUsuario1);
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qtdUsuario != 0;
    }
//////////////////////////

///////////Cadastra o proprietário    
    public void cadastrarPessoaProprietario() {
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
///////////////////////////

//////////////////Busca a pessoa pelo cpf
    public int buscarCodPessoa(long cpf) {
        int codPessoa = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT codpessoa FROM pessoa WHERE " + this.getCpf() + "=cpf";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String codPessoa1 = resultado.getString(1);
            codPessoa = Integer.valueOf(codPessoa1);
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return codPessoa;
    }
//////////////////////

////////////////Cadastra um proprietário
    public void cadastrarProprietario() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("INSERT INTO proprietario(codpessoa, usuario, senha,CNPJ) VALUES(" + this.getCodPessoa() + ",'" + this.getLogin() + "','" + this.getSenha() + "'," + this.getCnpj() + ")");
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    ////////////////////////// 

    //////////////Verificar se a pessoa é um proprietario
    public boolean verificarProprietario() {
        int qtdProprietario = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "select count(cpf) from pessoa,proprietario where pessoa.cpf=" + this.getCpf() + " and pessoa.codpessoa=proprietario.codpessoa;";
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
///////////////////////////////////q

////////////////Update Proprietario
    public void updateProprietario() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("UPDATE pessoa SET nome = '" + this.getNome() + "',cpf = " + this.getCpf() + ",rg = '" + this.getRg() + "',telefone = " + this.getTelefone() + ",email = '" + this.getEmail() + "',endereco = '" + this.getEndereco() + "' WHERE codpessoa = " + this.getCodPessoa());
            comando.executeUpdate("UPDATE proprietario SET CNPJ = " + this.getCnpj() + ",usuario = '" + this.getLogin() + "',senha = '" + this.getSenha() + "' WHERE codpessoa = " + this.getCodPessoa());
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/////////////////////////////////////////

///////////////////Buscar Proprietario
    public static Proprietario buscarProprietario(long cpf) {
        int codProprietario = 0;
        long cnpj = 0;
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
            String sql = " select * from pessoa,proprietario where pessoa.cpf=" + cpf + " and pessoa.codpessoa=proprietario.codpessoa";
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

            String codProprietario1 = resultado.getString(8);
            codProprietario = Integer.valueOf(codProprietario1);

            String cnpj1 = resultado.getString(12);
            cnpj = Long.valueOf(cnpj1);

            usuario = resultado.getString(10);

            senha = resultado.getString(11);

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        Proprietario p1 = new Proprietario(cnpj, codProprietario, usuario, senha, codPessoa, nome, cpf, rg, telefone, email, endereco);
        return p1;
    }
/////////////////////////////////////////////

/////////////Verificar login do proprietario
    public static boolean verfificarLogin(String login) {
        int qtdProprietario = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "select count(usuario) from proprietario where usuario='" + login + "'";
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
/////////////////////// 

//////////Método para verificar a senha
    public static boolean verfificarSenha(String login, String senha) {
        int qtdProprietario = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT COUNT(codproprietario) from proprietario where usuario='" + login + "' and senha='" + senha + "'";
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
