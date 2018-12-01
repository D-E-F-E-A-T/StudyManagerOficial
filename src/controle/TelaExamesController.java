/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
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
import modelo.Exames;
import persistencia.ExameDAO;


/**
 * FXML Controller class
 *
 * @author Ayrton Barreto
 */
public class TelaExamesController implements Initializable {

    private Exames exameEDIT;
    private ExameDAO exameDAO = new ExameDAO();
    private ObservableList<Exames> exame;
    
    @FXML
    private JFXTextField nomeExame;
    @FXML
    private JFXTextField conteudoExame;
    @FXML
    private JFXDatePicker dataExame;
    @FXML
    private JFXTextField notaExame;
    @FXML
    private JFXTextField salaExame;
    @FXML
    private JFXTextArea anotacaoExame;
    @FXML
    private JFXButton btcadastrarExame;
    @FXML
    private JFXButton bteditarExame;
    @FXML
    private JFXButton btexcluirExame;
    @FXML
    private TableView<Exames> tabelaExame;
    @FXML
    private TableColumn<?, ?> tarefa;
    @FXML
    private TableColumn<?, ?> conteudo;
    @FXML
    private TableColumn<?, ?> data;
    @FXML
    private TableColumn<?, ?> nota;
    @FXML
    private TableColumn<?, ?> sala;
    @FXML
    private TableColumn<?, ?> anotacoes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listarTarefas();
    }    
    
    @FXML
     private void mouseClicked(MouseEvent event) {
        Exames ex = tabelaExame.getSelectionModel().getSelectedItem();
        nomeExame.setText(ex.getNome());
        conteudoExame.setText(ex.getConteudo());
        notaExame.setText(String.valueOf(ex.getNota()));
        salaExame.setText(ex.getSala());
        
        Instant instant = Instant.ofEpochMilli(ex.getData().getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        dataExame.setValue(localDate);
      
        anotacaoExame.setText(ex.getAnotacoes());
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
    private void addExame() throws SQLException{
         Date dataExames = Date.valueOf(this.dataExame.getValue());
         
         exameEDIT = new Exames(
                nomeExame.getText(),
                conteudoExame.getText(),
                Double.parseDouble(notaExame.getText()),
                salaExame.getText(), 
                dataExames,
                anotacaoExame.getText());
       
        System.out.println("ESTOU AQUI DEPOIS DO ADICIONAR");
        exameDAO.insertExame(exameEDIT);
        System.out.println("JA COLOQUEI NO INSERT E ADICIONEI");
        
        limparTextField();
        System.out.println("limpei os textos");
         System.out.println(exameDAO.listExames());
       
                
        refreshTable();
        System.out.println("adicionado com sucesso");
    }
    
     @FXML
    private void deleteExame() throws SQLException{
        
        exameDAO.deleteExame(tabelaExame.getSelectionModel().getSelectedItem().getId_exame());
        refreshTable();
        
    }
    
    @FXML
    private void updateExame() throws SQLException{
        
        Exames e = tabelaExame.getSelectionModel().getSelectedItem();
           
            if(e != null){
             System.out.println("vou editar");
            if(!nomeExame.getText().equals("")){
                e.setNome(nomeExame.getText());
            }
             System.out.println(e);
            if(!conteudoExame.getText().equals("")){
                e.setConteudo(conteudoExame.getText());
            }
            
            if(!notaExame.getText().equals("")){
                e.setNota(Double.parseDouble(notaExame.getText()));
            }
             System.out.println(e);
            if(!salaExame.getText().equals("")){
                e.setSala(salaExame.getText());
            }
             System.out.println(e);
            if(!dataExame.getValue().equals("")){
                e.setData(Date.valueOf(dataExame.getValue()));
            }
            if(!anotacaoExame.getText().equals("")){
                e.setAnotacoes(anotacaoExame.getText());
            }
            
            System.out.println(e);
            exameDAO.upadateExame(e);
            System.out.println("editei");
           
        }
        limparTextField();
        refreshTable();
     
    }
    
     
    @FXML
    private void listarTarefas(){
        
        exame = FXCollections.observableArrayList(exameDAO.listExames());
        tabelaExame.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("id_exame"));
        tabelaExame.getColumns().get(1).setCellValueFactory(new  PropertyValueFactory<>("nome"));
        tabelaExame.getColumns().get(2).setCellValueFactory(new  PropertyValueFactory<>("conteudo"));
        tabelaExame.getColumns().get(3).setCellValueFactory(new  PropertyValueFactory<>("nota"));
        tabelaExame.getColumns().get(4).setCellValueFactory(new  PropertyValueFactory<>("sala"));
        tabelaExame.getColumns().get(5).setCellValueFactory(new  PropertyValueFactory<>("data"));
        tabelaExame.getColumns().get(6).setCellValueFactory(new  PropertyValueFactory<>("anotacoes"));
        tabelaExame.setItems(exame);
        
    }
    
     @FXML
    private void refreshTable(){
        exame.clear();
        exame.addAll(exameDAO.listExames());
        tabelaExame.setItems(exame);
    }
    
     private void limparTextField() {
        nomeExame.clear();
        conteudoExame.clear();
        salaExame.clear();
        notaExame.clear();
        anotacaoExame.clear();
       
    }
    
}
