/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author lucas
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import modelo.Tarefa;

public class TarefaDAO {
	private final Conexao con = new Conexao();
	
	private final String INSERTTAREFA = "INSERT INTO TAREFA(NOME_TAREFA,ID_TAREFA,ASSUNTO_TAREFA,ANOTACOES_TAREFA,DATA_TAREFA) VALUES (?,?)";
	private final String UPDATETAREFA= "UPDATE TAREFA SET NOME_TAREFA = ? WHERE NOME_TAREFA = ?";
	private final String DELETETAREFA = "DELETE FROM TAREFA WHERE NOME_TAREFA = ?";
	private final String LISTTAREFA = "SELECT * FROM TAREFA";
	private final String VALIDANOMETAREFA = "SELECT COUNT(NOME_TAREFA) FROM TAREFA WHERE UPPER(NOME_TAREFA) = ?";
	private final String IDTAREFA = "SELECT COD_TAREFA FROM TAREFA WHERE ID_TAREFA = (SELECT MAX(ID_TAREFA) FROM TAREFA WHERE UPPER(NOME_TAREFA ) LIKE ?)";
	
	public boolean insertAutor(Tarefa a) {
		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(INSERTTAREFA);

			// SETA OS VALORES DA INSTRUCAO
			// OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
			preparaInstrucao.setString(1, a.getNomeTarefa().toUpperCase());
			preparaInstrucao.setString(2, a.getAssuntoTarefa().toUpperCase());
                      

			// EXECUTA A INSTRUCAO
			preparaInstrucao.execute();

			// DESCONECTA
			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			return false;

		}
	}
	
	public boolean updateAutor(String nome, Tarefa a) {
		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(UPDATETAREFA);

			// SETA OS VALORES DA INSTRUCAO
			// OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
			preparaInstrucao.setString(1, a.getNomeTarefa().toUpperCase());
			preparaInstrucao.setString(2, a.getAssuntoTarefa().toUpperCase());

			// EXECUTA A INSTRUCAO
			preparaInstrucao.execute();

			// DESCONECTA
			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			return false;

		}
	}
	
	public boolean deleteAutor(Tarefa a) {
		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(DELETETAREFA);

			// SETA OS VALORES DA INSTRUCAO
			// OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
			preparaInstrucao.setString(1, a.getNomeTarefa().toUpperCase());
			
			// EXECUTA A INSTRUCAO
			preparaInstrucao.execute();

			// DESCONECTA
			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			return false;

		}
	}
	
	public ArrayList<Tarefa> listTarefa() {
		ArrayList<Tarefa> lista = new ArrayList<>(); 

		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(LISTTAREFA); 
			
			// EXECUTA A INSTRUCAO
			ResultSet rs = preparaInstrucao.executeQuery(); 
			
			//TRATA O RETORNO DA CONSULTA
			while (rs.next()) { //enquanto houver registro
				Tarefa a = new Tarefa(rs.getInt("NOME_TAREFA"));
				lista.add(a); 
			}
			// DESCONECTA
			con.desconecta();
		} catch (SQLException e) {
		}
		
		return lista;
	}
}
	
	