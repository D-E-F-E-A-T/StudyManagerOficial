/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author lucas
 */
public class Conexao {
    private static final String USUARIO = "StudyManager2";
    private static final String SENHA = "123";
    private static final String CAMINHO = "jdbc:h2:~/teste";
    private static final String DRIVER = "org.h2.Driver";
    private Connection conexao;
    
    public Conexao(){
        
    }
    
    public void conecta(){
     try{   
        System.out.println("CONECTOU");
        Class.forName(DRIVER);
        conexao = DriverManager.getConnection(CAMINHO,USUARIO,SENHA);
         System.out.println("PASSOU DAQUI"); 
        }
     catch(ClassNotFoundException | SQLException e){
         System.err.println(e);
        }
     
    }
    public void desconecta(){
     try{   
        conexao.close();
        }
     catch(SQLException ex){
         System.err.println(ex);
        }
     
    }
    public Connection getConexao(){
        return conexao;
    }
    
}
