package br.com.techAT.dal;

import java.sql.*;

/**
 *
 * @author Renan Marques
 */
public class ModuloConexao {

    //estabelecer conexão banco de dados
    public static Connection conector() {
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        //salvar infos do banco
        String url = "jdbc:mysql://localhost:3306/dbsistema";
        String user = "root";
        String password = "";
        //conectar ao banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //erro de banco de dados
            System.out.println(e);
            return null;
        }
    }
}