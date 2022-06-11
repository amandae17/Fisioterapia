package br.com.fisioterapia.database.consulta;

import br.com.fisioterapia.database.utilitarios.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {

    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private int idConsulta;
    private int codPessoa;
    private int codFisioterapeuta;

    public Consulta() {

    }

    public Consulta(LocalDate dataConsulta, LocalTime horaConsulta) {
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
    }

    public Consulta(LocalDate dataConsulta, LocalTime horaConsulta, int codPessoa, int codFisioterapeuta) {
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.codPessoa = codPessoa;
        this.codFisioterapeuta = codFisioterapeuta;
    }

    public Consulta(LocalDate dataConsulta, LocalTime horaConsulta, int idConsulta, int codPessoa, int codFisioterapeuta) {
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.idConsulta = idConsulta;
        this.codPessoa = codPessoa;
        this.codFisioterapeuta = codFisioterapeuta;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    public int getCodFisioterapeuta() {
        return codFisioterapeuta;
    }

    public void setCodFisioterapeuta(int codFisioterapeuta) {
        this.codFisioterapeuta = codFisioterapeuta;
    }

/////////////////Cadastrar Consulta
    public void cadastrarConsulta() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("INSERT INTO consulta(codpessoa,codfisioterapeuta,dataconsulta,horario) VALUES(" + this.getCodPessoa() + "," + this.getCodFisioterapeuta() + ",'" + this.getDataConsulta().toString() + "','" + this.getHoraConsulta().toString() + "')");
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
////////////////////////////

/////////////////Verificar consulta    
    public boolean verificarConsulta() {
        int qtdConsulta = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT count(idconsulta) FROM consulta WHERE '" + this.getDataConsulta().toString() + "'= dataconsulta AND '" + this.getHoraConsulta().toString() + "' = horario";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdConsulta1 = resultado.getString(1);
            qtdConsulta = Integer.valueOf(qtdConsulta1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return qtdConsulta != 0;
    }
///////////////////////////////////////////////    

/////////////////Verificar se é a mesma data da consulta    
    public boolean verificarConsultaIsSameDate() {
        int qtdConsulta = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT count(idconsulta) FROM consulta WHERE '" + this.getDataConsulta().toString() + "'= dataconsulta AND '" + this.getHoraConsulta().toString() + "' = horario AND " + this.getIdConsulta() + "=idconsulta";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdConsulta1 = resultado.getString(1);
            qtdConsulta = Integer.valueOf(qtdConsulta1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return qtdConsulta != 0;
    }
///////////////////////////////////////////////     

//////////////////Buscar Consulta
    public static Consulta buscarConsulta(LocalDate dataConsulta, LocalTime horarioConsulta) {
        int idConsulta = 0;
        int idPessoa = 0;
        int idFisioterapeuta = 0;

        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT * FROM consulta WHERE '" + dataConsulta.toString() + "'= dataconsulta AND '" + horarioConsulta.toString() + "' = horario";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String idConsulta1 = resultado.getString(1);
            idConsulta = Integer.valueOf(idConsulta1);

            String idPessoa1 = resultado.getString(2);
            idPessoa = Integer.valueOf(idPessoa1);

            String idFisioterapeuta1 = resultado.getString(3);
            idFisioterapeuta = Integer.valueOf(idFisioterapeuta1);

            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        Consulta c1 = new Consulta(dataConsulta, horarioConsulta, idConsulta, idPessoa, idFisioterapeuta);
        return c1;
    }
///////////////////////////////Update Consulta

    public void updateConsulta() {
        Banco b = new Banco();
        Statement comando;
        try {
            comando = b.getConnection().createStatement();
            comando.executeUpdate("UPDATE consulta SET codpessoa = " + this.getCodPessoa() + ",codfisioterapeuta = " + this.getCodFisioterapeuta() + ",dataconsulta = '" + this.getDataConsulta().toString() + "', horario = '" + this.getHoraConsulta().toString() + "' WHERE idconsulta= " + this.getIdConsulta());
            b.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/////////////////////////////////

    /////////////////Verificar consulta    
    public static int countConsulta(LocalDate t1, LocalDate t2) {
        int qtdConsulta = 0;
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "select count(idconsulta) from consulta where dataconsulta between '" + t1.toString() + "' AND '" + t2.toString() + "'";
            ResultSet resultado = comando.executeQuery(sql);
            resultado.next();
            String qtdConsulta1 = resultado.getString(1);
            qtdConsulta = Integer.valueOf(qtdConsulta1);
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return qtdConsulta;
    }
/////////////////////////////////////////////// 

///////////Método para pegar as consultas e os dados dos pacientes e fisioterapeutas
    public static String[][] obterConsultas(int qtdConsulta, LocalDate dataInicial, LocalDate dataFinal) {
        String dados[][] = new String[qtdConsulta][6];
        Banco b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT * FROM consulta,pessoa where dataconsulta between '" + dataInicial.toString() + "' AND '" + dataFinal.toString() + "' AND pessoa.codpessoa=consulta.codpessoa order by dataconsulta asc ,horario asc";
            ResultSet resultado = comando.executeQuery(sql);
            int l = 0;
            while (resultado.next()) {//Pega todas linhas retornadas
                dados[l][0] = resultado.getString(4);
                dados[l][1] = resultado.getString(5);
                dados[l][2] = resultado.getString(7);
                dados[l][3] = resultado.getString(8);
                l += 1;
            }
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }

        b = new Banco();
        try {
            Statement comando = b.getConnection().createStatement();
            String sql = "SELECT * from consulta,pessoa,fisioterapeuta WHERE dataconsulta between '" + dataInicial.toString() + "' AND '" + dataFinal.toString() + "' AND consulta.codfisioterapeuta=fisioterapeuta.codfisioterapeuta AND pessoa.codpessoa=fisioterapeuta.codpessoa";
            ResultSet resultado = comando.executeQuery(sql);
            int l = 0;
            while (resultado.next()) {//Pega todas linhas retornadas
                dados[l][4] = resultado.getString(7);
                dados[l][5] = resultado.getString(8);
                l += 1;
            }
            b.getConnection().close();
        } catch (SQLException e) {//JDBC 8
            e.printStackTrace();
        }
        return dados;
    }
/////////////////////////////////////////////
    
}
