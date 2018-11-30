/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Disciplina;

/**
 *
 * @author Ayrton Barreto
 */
public class DisciplinaDAO {
    private Conexao con = new Conexao();
     
    private final String INSERTDISCIPLINA = "INSERT INTO DISCIPLINA (NOME_DISCIPLINA,CONTEUDO_DISCIPLINA, ANOTACOES_DISCIPLINA) VALUES (?,?,?)";
    private final String UPDATEDISCIPLINA = "UPDATE DISCIPLINA SET NOME_DISCIPLINA = ?, CONTEUDO_DISCIPLINA = ?, ANOTACOES_DISCIPLINA = ? WHERE ID_DISCIPLINA = ?";
    private final String DELETEDISCIPLINA = "DELETE FROM DISCIPLINA WHERE ID_DISCIPLINA = ?";
    private final String LISTDISCIPLINA = "SELECT * FROM DISCIPLINA ORDER BY ID_DISCIPLINA";
   
    
    public boolean insertDisciplina(Disciplina d) throws SQLException{
        System.out.println("ESTOU ACESSANDO O BANCO");
        con.conecta();
        
        try{
            
         
        PreparedStatement preparaInstrucao;
        preparaInstrucao = con.getConexao().prepareStatement(INSERTDISCIPLINA);
        System.out.println("ESTOU AQUI DEPOIS DA CONEXAO");
      
        System.out.println("ESTOU ACESSANDO AS CLASSES");
        preparaInstrucao.setString(1, d.getNome().toUpperCase());
        preparaInstrucao.setString(2, d.getConteudo().toUpperCase());
        preparaInstrucao.setString(3, d.getAnotacoes().toUpperCase());
        System.out.println("ESTOU ACESSEI AS CLASSES");
        preparaInstrucao.execute();
        con.desconecta();
        
        System.out.println("DESCONECTEI");
                   
        return true;    
       }catch (SQLException e) {
           System.err.println(e);
        return false;    
        }
    }
    
     public boolean upadateDisciplina(Disciplina d) throws SQLException{
        
        PreparedStatement preparaInstrucao;
        preparaInstrucao = con.getConexao().prepareStatement(UPDATEDISCIPLINA);

        try{
            preparaInstrucao.setString(1, d.getNome().toUpperCase());
            preparaInstrucao.setString(2, d.getConteudo().toUpperCase());
            preparaInstrucao.setString(3, d.getAnotacoes().toUpperCase());
            preparaInstrucao.setInt(4, d.getId_disciplina());

            preparaInstrucao.execute();
            con.desconecta();

        return true;    
       }catch (SQLException e) {
           System.err.println(e);
        return false;    
        }
    }
     
     public boolean deleteDisciplina(int id) throws SQLException{
        
        con.conecta();
	PreparedStatement preparaInstrucao;
        preparaInstrucao = con.getConexao().prepareStatement(DELETEDISCIPLINA);

        try{
            preparaInstrucao.setInt(1, id);
            preparaInstrucao.execute();
            con.desconecta();		
            return true;
	} catch (SQLException e) {
                System.err.println(e);
                return false;
        } 
    }
    
    public ArrayList<Disciplina> listDisciplina(){
      
      ArrayList<Disciplina> lista = new ArrayList<>(); 

	try {
			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTDISCIPLINA); 
			
            ResultSet rs = preparaInstrucao.executeQuery(); 
			
            while (rs.next()) { 
                
                Disciplina a = new Disciplina(
                        rs.getString("NOME_DISCIPLINA"),
                        rs.getString("CONTEUDO_DISCIPLINA"), 
                        rs.getString("ANOTACOES_DISCIPLINA")
                        );
		lista.add(a);               
            }           
            con.desconecta();
            
            } catch (SQLException e) {
                System.err.println(e);
            }
            return lista;
     
    }
}

 

