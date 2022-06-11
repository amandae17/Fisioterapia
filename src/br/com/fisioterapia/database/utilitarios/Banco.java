package br.com.fisioterapia.database.utilitarios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Banco {   

    private Connection con;
    private String host = "jdbc:mysql://localhost:3306/fisioterapia";
    private String user = "root";
    private String password = "12345678";

    public Banco() {        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.con = (Connection) DriverManager.getConnection(host, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.con;
    }
}
