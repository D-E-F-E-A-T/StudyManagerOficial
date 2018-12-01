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
import modelo.Tarefa;

/**
 *
 * @author Ayrton Barreto
 */
public class TarefaDAO {
    private Conexao con = new Conexao();
     
    private final String INSERTTAREFA= "INSERT INTO TAREFA (NOME_TAREFA,ASSUNTO_TAREFA,DISCIPLINA_TAREFA, DATA_TAREFA) VALUES (?,?,?,?)";
    private final String UPDATETAREFA = "UPDATE TAREFA SET NOME_TAREFA = ?, ASSUNTO_TAREFA = ?, DISCIPLINA_TAREFA = ?, DATA_TAREFA = ? WHERE ID_TAREFA = ?";
    private final String DELETETAREFA= "DELETE FROM TAREFA WHERE ID_TAREFA = ?";
    private final String LISTTAREFA = "SELECT * FROM TAREFA ORDER BY ID_TAREFA";
   
    
    public boolean insertTarefa(Tarefa t) throws SQLException{
        System.out.println("ESTOU ACESSANDO O BANCO");
        con.conecta();
        
        try{
           
        PreparedStatement preparaInstrucao;
        preparaInstrucao = con.getConexao().prepareStatement(INSERTTAREFA);
        System.out.println("ESTOU AQUI DEPOIS DA CONEXAO");
      
        System.out.println("ESTOU ACESSANDO AS CLASSES");
        preparaInstrucao.setString(1, t.getNome().toUpperCase());
        preparaInstrucao.setString(2, t.getAssunto().toUpperCase());
        preparaInstrucao.setInt(3, t.getDisciplina());
        preparaInstrucao.setDate(4, new java.sql.Date(t.getData().getTime()));
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
    
     public boolean upadateTarefa(Tarefa t) throws SQLException{
     
        try{
            System.out.println("conexao para editar");
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATETAREFA);
            
            preparaInstrucao.setString(1, t.getNome().toUpperCase());
            preparaInstrucao.setString(2, t.getAssunto().toUpperCase());
            preparaInstrucao.setInt(3, t.getDisciplina());
            preparaInstrucao.setDate(4, (Date) t.getData());
            preparaInstrucao.setInt(5, t.getId_tarefa());
            System.out.println("conectei e editei");
            preparaInstrucao.execute();
            System.out.println("enviei para o banco");
            con.desconecta();

        return true;    
       }catch (SQLException e) {
           System.err.println(e);
        return false;    
        }
    }
     
     public boolean deleteTarefa(int id) throws SQLException{
        
         con.conecta();
         System.out.println("Estou conectado no banco para deletar");
        try{
            
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETETAREFA);
            System.out.println("fiz conexao com o delete");
            preparaInstrucao.setInt(1, id);
            preparaInstrucao.execute();
            System.out.println("Deletei");
            con.desconecta();		
            return true;
	} catch (SQLException e) {
                System.err.println(e);
                return false;
        } 
    }
    
    public ArrayList<Tarefa> listTarefa(){
      
      ArrayList<Tarefa> lista = new ArrayList<>(); 

	try {
			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTTAREFA); 
			
            ResultSet rs = preparaInstrucao.executeQuery(); 
			
            while (rs.next()) { 
                
                Tarefa t = new Tarefa(
                        rs.getInt("ID_TAREFA"),
                        rs.getString("NOME_TAREFA"),
                        rs.getString("ASSUNTO_TAREFA"), 
                        rs.getInt("DISCIPLINA_TAREFA"),
                        rs.getDate("DATA_TAREFA")
                        );
		lista.add(t);               
            }           
            con.desconecta();
            
            } catch (SQLException e) {
                System.err.println(e);
            }
            return lista;
     
    }

}

 

