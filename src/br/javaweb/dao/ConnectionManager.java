/*

Classe ConnectionManager - Classe com configuração inicial para acesso ao Banco;
Com tratamento de erros e fechamento de conexão.

fabricio.ayres@gmail.com  - Fabrício Ayres Vieira

*/

package br.javaweb.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.javaweb.util.JavaWebException;

public class ConnectionManager {

    /*
     * 1) Coloque o valor adequado nas constantes DATABASE, USER e PASSWORD 
     * 2) Teste esta classe para garantir que esteja funcionando
     */
    private static final String STR_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE = "jw";
    private static final String IP = "localhost"; //"192.168.0.1";
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE;
    private static final String USER = "jw";
    private static final String PASSWORD = "jw";

    public static Connection getConexao() throws JavaWebException {
        Connection conn = null;
        try {
            Class.forName(STR_DRIVER);
            conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            System.out.println("[ConnectionManager]: Obtendo conexao");
            return conn;
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver nao encontrado";
            throw new JavaWebException(errorMsg, e);
        } catch (SQLException e) {
            String errorMsg = "Erro ao obter a conexao";
            throw new JavaWebException(errorMsg, e);
        }
    }

    public static void closeAll(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null || stmt != null) {
                closeAll(conn, stmt);
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Connection conn, Statement stmt) {
        try {
            if (conn != null) {
                closeAll(conn);
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
