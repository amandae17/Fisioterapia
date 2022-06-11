package br.com.fisioterapia.database.pessoas;


import br.com.fisioterapia.database.utilitarios.Banco;
import br.com.fisioterapia.database.pessoas.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Paciente extends Pessoa {

    public Paciente(int codPessoa, String nome, long cpf, String rg, long telefone, String email, String endereco) {
        super(codPessoa, nome, cpf, rg, telefone, email, endereco);

    }

    public Paciente(String nome, long cpf, String rg, long telefone, String email, String endereco) {
        super(nome, cpf, rg, telefone, email, endereco);
    }

    public Paciente(long cpf) {
        super(cpf);
    }

    public Paciente(int codPessoa) {
        super(codPessoa);
    }

//Cadastrar paciente///////////////////////    
    public void cadastrarPaciente() {
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
//////////////////////////////////////////

//////Update paciente////////////////////   
    public void UpdatePaciente() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("UPDATE pessoa SET nome = '"
                    + this.getNome()
                    + "',cpf = " + this.getCpf()
                    + ",rg = '" + this.getRg()
                    + "',telefone = " + this.getTelefone()
                    + ",email = '" + this.getEmail()
                    + "',endereco = '" + this.getEndereco()
                    + "' WHERE codpessoa = " + this.getCodPessoa());
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
///////////////////////////////////////////    

/////Buscar Paciente/////////////
    public static Paciente BuscarPaciente(long cpf) {
        int codPessoa = 0;
        String nome = "";
        String rg = "";
        long telefone = 0;
        String email = "";
        String endereco = "";

        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT codpessoa,nome,cpf,rg,telefone,email,endereco FROM pessoa WHERE '" + cpf + "'=cpf";
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

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }

        Paciente p1 = new Paciente(codPessoa, nome, cpf, rg, telefone, email, endereco);
        return p1;
    }
/////////////////////////

/////////Buscar Paciente pelo id/////////////
    public static Paciente buscarPacienteId(int id) {
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
            String sql = "SELECT * FROM pessoa WHERE '" + id + "'=codPessoa";
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

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }

        Paciente p1 = new Paciente(codPessoa, nome, cpf, rg, telefone, email, endereco);
        return p1;
    }
/////////////////////////

/////////////////////////Verificar CPF    
    public boolean verificarCpf() {
        int idPessoa = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT count(codpessoa) FROM pessoa WHERE '" + this.getCpf() + "'=cpf";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String idPessoa1 = resultado.getString(1);
            idPessoa = Integer.valueOf(idPessoa1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return idPessoa != 0;
    }
    /////////////////////

}
