/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Exames;

/**
 *
 * @author lucas
 */
public class ExameDAO {
    private Conexao con = new Conexao();
     
    private final String INSERTEXAME= "INSERT INTO EXAME (NOME_EXAME,CONTEUDO_EXAME,NOTA_EXAME, SALA_EXAME,DATA_EXAME,ANOTACAO_EXAME) VALUES (?,?,?,?,?,?)";
    private final String UPDATEEXAME = "UPDATE EXAME SET NOME_EXAME = ?, CONTEUDO_EXAME = ?, NOTA_EXAME = ?, SALA_EXAME = ?, DATA_EXAME = ?, ANOTACAO_EXAME = ? WHERE ID_EXAME = ?";
    private final String DELETEEXAME= "DELETE FROM EXAME WHERE ID_EXAME = ?";
    private final String LISTEXAME = "SELECT * FROM EXAME ORDER BY ID_EXAME";
   
    
    public boolean insertExame(Exames e) throws SQLException{
        System.out.println("ESTOU ACESSANDO O BANCO");
        con.conecta();
        
        try{
           
        PreparedStatement preparaInstrucao;
        preparaInstrucao = con.getConexao().prepareStatement(INSERTEXAME);
        System.out.println("ESTOU AQUI DEPOIS DA CONEXAO");
      
        System.out.println("ESTOU ACESSANDO AS CLASSES");
        preparaInstrucao.setString(1, e.getNome().toUpperCase());
        preparaInstrucao.setString(2, e.getConteudo().toUpperCase());
        preparaInstrucao.setDouble(3, e.getNota());
        preparaInstrucao.setString(4, e.getSala().toUpperCase());
        preparaInstrucao.setDate(5, new java.sql.Date(e.getData().getTime()));
        preparaInstrucao.setString(6, e.getAnotacoes().toUpperCase());
        System.out.println("ESTOU ACESSEI AS CLASSES");
        preparaInstrucao.execute();
        con.desconecta();
        
        System.out.println("DESCONECTEI");
                   
        return true;    
       }catch (SQLException f) {
           System.err.println(f);
        return false;    
        }
    }
    
     public boolean upadateExame(Exames e) throws SQLException{
     
        try{
            System.out.println("conexao para editar");
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEEXAME);
            
            preparaInstrucao.setString(1, e.getNome().toUpperCase());
            preparaInstrucao.setString(2, e.getConteudo().toUpperCase());
            preparaInstrucao.setDouble(3, e.getNota());
            preparaInstrucao.setString(4, e.getSala().toUpperCase());
            preparaInstrucao.setDate(5, new java.sql.Date(e.getData().getTime()));
            preparaInstrucao.setString(6, e.getAnotacoes().toUpperCase());
            preparaInstrucao.setInt(7, e.getId_exame());
            System.out.println("conectei e editei");
            preparaInstrucao.execute();
            System.out.println("enviei para o banco");
            con.desconecta();

        return true;    
       }catch (SQLException f) {
           System.err.println(f);
        return false;    
        }
    }
     
     public boolean deleteExame(int id) throws SQLException{
        
         con.conecta();
         System.out.println("Estou conectado no banco para deletar");
        try{
            
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETEEXAME);
            System.out.println("fiz conexao com o delete");
            preparaInstrucao.setInt(1, id);
            preparaInstrucao.execute();
            System.out.println("Deletei");
            con.desconecta();		
            return true;
	} catch (SQLException f) {
                System.err.println(f);
                return false;
        } 
    }
    
    public ArrayList<Exames> listExames(){
      
      ArrayList<Exames> lista = new ArrayList<>(); 

	try {
			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTEXAME); 
			
            ResultSet rs = preparaInstrucao.executeQuery(); 
			
            while (rs.next()) { 
                
                Exames e = new Exames(
                        rs.getInt("ID_EXAME"),
                        rs.getString("NOME_EXAME"),
                        rs.getString("CONTEUDO_EXAME"),
                        rs.getDouble("NOTA_EXAME"), 
                        rs.getString("SALA_EXAME"),
                        rs.getDate("DATA_EXAME"),
                        rs.getString("ANOTACAO_EXAME")
                        );
                lista.add(e);          
                }   
            con.desconecta();
            
            } catch (SQLException f) {
                System.err.println(f);
            }
            return lista;
     
    }
}
