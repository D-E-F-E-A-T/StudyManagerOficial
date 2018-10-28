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

import modelo.Disciplina;

public class DisciplinaDAO {
	private final Conexao con = new Conexao();
	
	private final String INSERTDISCIPLINA = "INSERT INTO DISCIPLINA(NOME_DISCIPLINA,ID_DISCIPLINA,ASSUNTO_DISCIPLINA) VALUES (?,?,?)";
	private final String UPDATEDISCIPLINA = "UPDATE DISCIPLIA SET NOME_DISCIPLINA = ? WHERE NOME_DISCIPLINA = ?";
	private final String DELETEDISCIPLINA = "DELETE FROM DISCIPLINA WHERE NOME_DISCIPLINA= ?";
	private final String LISTDISCIPLINA = "SELECT * FROM DISCIPLINA";
        private final String BUSCARDISCIPLINA = "SELECT * FROM DISCIPLINA WHERE UPPER(NOME_DISCIPLINA) LIKE ?";
	

	public boolean insertTitulo(Disciplina t) {
		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(INSERTDISCIPLINA);

			// SETA OS VALORES DA INSTRUCAO
			// OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
			preparaInstrucao.setString(1, t.getNomeDisciplina().toUpperCase());
			preparaInstrucao.setString(2, t.getAssuntoDisciplina().toUpperCase());
			

			// EXECUTA A INSTRUCAO
			preparaInstrucao.execute();

			// DESCONECTA
			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			return false;

		}
	}
	
	public boolean updateTitulo(String nome, Disciplina t) {
		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(UPDATEDISCIPLINA);

			// SETA OS VALORES DA INSTRUCAO
			// OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
			preparaInstrucao.setString(1, t.getNomeDisciplina().toUpperCase());
			preparaInstrucao.setString(2, t.getAssuntoDisciplina().toUpperCase());
			
			// EXECUTA A INSTRUCAO
			preparaInstrucao.execute();

			// DESCONECTA
			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			return false;

		}
	}
	
	public boolean deleteTitulo(Disciplina t) {
		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(DELETEDISCIPLINA);

			// SETA OS VALORES DA INSTRUCAO
			// OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
			preparaInstrucao.setString(1, t.getNomeDisciplina());

			// EXECUTA A INSTRUCAO
			preparaInstrucao.execute();

			// DESCONECTA
			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			return false;

		}
	}
	public ArrayList<Disciplina> buscarDisciplina(String nomeDisciplina) {
		ArrayList<Disciplina> lista = new ArrayList<>(); 

		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(BUSCARDISCIPLINA); 
			
			//SETA OS VALORES DA INSTRUCAO
			//OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
			preparaInstrucao.setString(1, "%"+nomeDisciplina.toUpperCase()+"%");
			
			// EXECUTA A INSTRUCAO
			ResultSet rs = preparaInstrucao.executeQuery(); 
			
			//TRATA O RETORNO DA CONSULTA
			while (rs.next()) { //enquanto houver registro
				Disciplina u = new Disciplina(rs.getString("NOME_DISCIPLINA"));
				lista.add(u); 
			}
			// DESCONECTA
			con.desconecta();
		} catch (SQLException e) {
                     System.out.println(e.getMessage());
		}
		
		return lista;
	}
	
}