/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sr. Roosevelt
 */
public class conexaoBD {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/";
    private static final String DATA_BASE = "PROJETO_ESCOLA";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "llruy007";
    
    public static Connection getConexao(){
        Connection con = null;
        try{
        Class.forName(DRIVER);
        con = DriverManager.getConnection(URL + DATA_BASE, USUARIO, SENHA);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO" +e);
        }
        return con;
    }
    public static void fecharConexao(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO" +ex);
            }
        }
    }
    public static void fecharConexao(Connection con, PreparedStatement stmt){
        
        try {
            if(con != null){
                fecharConexao(con);
            }
            if(stmt != null){
                stmt.close();
            }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO" +ex);
        }
    }
    
    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
 
        try {
            if (con != null || stmt != null) {
                fecharConexao(con, stmt);
            }
            if (rs != null) {
                rs.close();
            }
 
 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO" +e);
        }
    }
}
