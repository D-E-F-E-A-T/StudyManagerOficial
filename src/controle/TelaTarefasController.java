/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import modelo.Tarefa;
import modelo.Disciplina;
import persistencia.DisciplinaDAO;
import persistencia.TarefaDAO;

/**
 * FXML Controller class
 *
 * @author Ayrton Barreto
 */
public class TelaTarefasController implements Initializable {
    private Tarefa tarefaEDIT;
    private TarefaDAO tarefaDAO = new TarefaDAO();
    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    private ObservableList<Tarefa> tarefa;
    private ObservableList<Disciplina> disciplina = FXCollections.observableArrayList();;
    
    
    @FXML
    private JFXTextField nomeTarefa;
    @FXML
    private JFXTextField assuntoTarefa;
    @FXML
    private JFXComboBox<Disciplina> disciplinaTarefa;
    @FXML
    private JFXDatePicker dataTarefa;
    @FXML
    private JFXTextArea anotacoesTarefa;
    @FXML
    private JFXButton btcadastrarTarefa;
    @FXML
    private JFXButton btEditarTarefa;
    @FXML
    private JFXButton btExcluirTarefa;
    
    @FXML
    private TableView<Tarefa> tabelaTarefas;
    
    @FXML
    private TableColumn<?, ?> campoDisciplina;
    @FXML
    private TableColumn<?, ?> tipo;
    @FXML
    private TableColumn<?, ?> assunto;
    @FXML
    private TableColumn<?, ?> data;
    @FXML
    private TableColumn<?, ?> anotacoes;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         disciplina.addAll(disciplinaDAO.listDisciplina());
         disciplinaTarefa.setItems(disciplina);
         listarTarefas();
    }    
    
    
    
    
      @FXML
     private void mouseClicked(MouseEvent event) {
        Tarefa tis = tabelaTarefas.getSelectionModel().getSelectedItem();
        nomeTarefa.setText(tis.getNome());
        assuntoTarefa.setText(tis.getAssunto());
        
          
         Disciplina dis = null;
        for(Disciplina d: disciplina){
            if(d.getId_disciplina() == tis.getDisciplina())
                dis = d;
        }
       
        disciplinaTarefa.setValue(dis);
        
       
        
        Instant instant = Instant.ofEpochMilli(tis.getData().getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        dataTarefa.setValue(localDate);
        
       
        
    }
     
     @FXML
    private void refreshTable(){
        tarefa.clear();
        tarefa.addAll(tarefaDAO.listTarefa());
        tabelaTarefas.setItems(tarefa); 
    }
    
      private StringConverter<LocalDate> data(){
        
        String pattern = "yyyy-MM-dd";
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>(){
            DateTimeFormatter formatar = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if(date != null){
                    return formatar.format(date);
                }else{
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if(string != null && !string.isEmpty()){
                    return LocalDate.parse(string,formatar);
                }else{
                    return null;
                }
            }
            
        };
        return converter;
    }
    
     @FXML
    private void addTarefa() throws SQLException{
         Date dataTarefas = Date.valueOf(this.dataTarefa.getValue());
        tarefaEDIT = new Tarefa(
                nomeTarefa.getText(),
                assuntoTarefa.getText(),
                disciplinaTarefa.getSelectionModel().getSelectedItem().getId_disciplina(),
                dataTarefas);
        
        tarefaDAO.insertTarefa(tarefaEDIT);
        limparTextField();
        refreshTable();
    }
    
    @FXML
    private void deleteTarefa() throws SQLException{
        
        tarefaDAO.deleteTarefa(tabelaTarefas.getSelectionModel().getSelectedItem().getId_tarefa());
        refreshTable();
        
    }
    
    @FXML
    private void updateTarefa() throws SQLException{
        
        Tarefa t = tabelaTarefas.getSelectionModel().getSelectedItem();
           
            if(t != null){
             System.out.println("vou editar");
            if(!nomeTarefa.getText().equals("")){
                t.setNome(nomeTarefa.getText());
            }
             System.out.println(t);
            if(!assuntoTarefa.getText().equals("")){
                t.setAssunto(assuntoTarefa.getText());
            }
             System.out.println(t);
            t.setDisciplina(disciplinaTarefa.getSelectionModel().getSelectedItem().getId_disciplina());
             System.out.println(t);
            if(!dataTarefa.getValue().equals("")){
                t.setData(Date.valueOf(dataTarefa.getValue()));
            }
            
            System.out.println(t);
            tarefaDAO.upadateTarefa(t);
            System.out.println("editei");
            
     
        }
        limparTextField();
        refreshTable();
     
    }
    
    
    @FXML
    private void listarTarefas(){
        
        tarefa = FXCollections.observableArrayList(tarefaDAO.listTarefa());
        
        tabelaTarefas.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("id_tarefa"));
        tabelaTarefas.getColumns().get(1).setCellValueFactory(new  PropertyValueFactory<>("nome"));
        tabelaTarefas.getColumns().get(2).setCellValueFactory(new  PropertyValueFactory<>("assunto"));
        tabelaTarefas.getColumns().get(3).setCellValueFactory(new  PropertyValueFactory<>("disciplina"));
        tabelaTarefas.getColumns().get(4).setCellValueFactory(new  PropertyValueFactory<>("data"));
        tabelaTarefas.setItems(tarefa);
        
    }
    
    
    private void limparTextField() {

        nomeTarefa.clear();
        assuntoTarefa.clear();     
    }
}
