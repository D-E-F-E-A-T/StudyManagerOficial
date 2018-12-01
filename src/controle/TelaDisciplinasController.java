/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Disciplina;
import persistencia.DisciplinaDAO;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ayrton Barreto
 */
public class TelaDisciplinasController implements Initializable {

    private Disciplina disciplinaEdit;
    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    private ObservableList<Disciplina> disciplina;

    @FXML
    private JFXTextField TextDisciplinaDisciplina;
    @FXML
    private JFXTextField TextConteudoDisciplina;
    @FXML
    private JFXTextArea TextAnotacoesDisciplina;
    @FXML
    private JFXButton btCadastrar;
    @FXML
    private JFXButton btEditar;
    @FXML
    private JFXButton btExcluir;
    @FXML
    private TableView<Disciplina> tabelaDisciplina;
    @FXML
    private TableColumn<?, ?> idDisciplina;
    @FXML
    private TableColumn<?, ?> nomeDisciplina;
    @FXML
    private TableColumn<?, ?> conteudoDisciplina;
    @FXML
    private TableColumn<?, ?> horarioDisciplina;
    @FXML
    private TableColumn<?, ?> anotacaoesDisciplina;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listarDisciplina();
    }

    private void limparTextField() {

        TextDisciplinaDisciplina.clear();
        TextConteudoDisciplina.clear();
        TextAnotacoesDisciplina.clear();

    }

    @FXML
    private void refreshTable() {
        disciplina.clear();
        disciplina.addAll(disciplinaDAO.listDisciplina());
        tabelaDisciplina.setItems(disciplina);
    }

    @FXML
    private void addDisciplina() throws SQLException {
        System.out.println("Metodo add");
        if (!"".equals(nomeDisciplina.getText())) {

        }
        System.out.println(nomeDisciplina.getText());
        disciplinaEdit = new Disciplina(TextDisciplinaDisciplina.getText(), TextConteudoDisciplina.getText(), TextAnotacoesDisciplina.getText());
        //Fazer tratamentos aqui, Pedir explicação a Laura
        disciplinaDAO.insertDisciplina(disciplinaEdit);
        refreshTable();
        limparTextField();
    }

    @FXML
    private void mouseClicked(MouseEvent event) {
        Disciplina dis = tabelaDisciplina.getSelectionModel().getSelectedItem();
        TextDisciplinaDisciplina.setText(dis.getNome());
        TextConteudoDisciplina.setText(dis.getConteudo());
        TextAnotacoesDisciplina.setText(dis.getAnotacoes());

    }

    @FXML
    private void updateDisciplina() throws SQLException {

        Disciplina dis = tabelaDisciplina.getSelectionModel().getSelectedItem();

        if (dis != null) {

            if (!TextDisciplinaDisciplina.getText().equals("")) {
                dis.setNome(TextDisciplinaDisciplina.getText());
            }
            if (!TextConteudoDisciplina.getText().equals("")) {
                dis.setConteudo(TextConteudoDisciplina.getText());
            }
            if (!TextAnotacoesDisciplina.getText().equals("")) {
                dis.setAnotacoes(TextAnotacoesDisciplina.getText());
            }
            disciplinaDAO.upadateDisciplina(dis);

        }

        refreshTable();
        limparTextField();

    }

    @FXML
    private void deleteDisciplina() throws SQLException {
        System.out.println("recebi mensagem para deletar");
        disciplinaDAO.deleteDisciplina(tabelaDisciplina.getSelectionModel().getSelectedItem().getId_disciplina());
        System.out.println(tabelaDisciplina.getSelectionModel().getSelectedItem().toString());
        refreshTable();
        System.out.println("DELETEI");
    }

    @FXML
    private void listarDisciplina() {

        disciplina = FXCollections.observableArrayList(disciplinaDAO.listDisciplina());

        //TabelaDisciplina.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("id_disciplina"));
        tabelaDisciplina.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id_disciplina"));
        tabelaDisciplina.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaDisciplina.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("conteudo"));
        tabelaDisciplina.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("anotacoes"));

        tabelaDisciplina.setItems(disciplina);
    }

}
