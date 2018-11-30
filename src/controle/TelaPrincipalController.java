/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Ayrton Barreto
 */
public class TelaPrincipalController implements Initializable {
    @FXML private BorderPane borderPrincipal;
    @FXML private Label labelPrincipal;
    //@FXML private JFXButton btCalendario;
    @FXML private JFXButton btDisciplinas;
    @FXML private JFXButton btTarefas;
    //@FXML private JFXButton btPlanoDeEstudos;
    @FXML private JFXButton btExames;
    //@FXML private JFXButton btPesquisar;
    //@FXML private JFXButton btConfiguracoes;
    @FXML private JFXButton btSair;
    @FXML private Pane paneInicial;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       disciplinas();
    }

    /*@FXML private void calendarios(){
        System.out.println("teste");
        try {
            URL url = getClass().getResource("/visao/TelaCalendario.fxml");
            Parent TelaCalendario = FXMLLoader.load(url);
            borderPrincipal.setCenter(TelaCalendario);
            labelPrincipal.setText("Calendario");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    } */
        
    @FXML private void disciplinas(){
        System.out.println("teste");
        try {
            URL url = getClass().getResource("/visao/TelaDisciplinas.fxml");
            Parent TelaDisciplinas = FXMLLoader.load(url);
            borderPrincipal.setCenter(TelaDisciplinas);
            labelPrincipal.setText("Disciplinas");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML private void tarefas(){
        System.out.println("teste");
        try {
            URL url = getClass().getResource("/visao/TelaTarefas.fxml");
            Parent TelaTarefas = FXMLLoader.load(url);
            borderPrincipal.setCenter(TelaTarefas);
            labelPrincipal.setText("Tarefas");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* @FXML private void planodeestudos(){
        System.out.println("teste");
        try {
            URL url = getClass().getResource("/visao/TelaPlanosDeEstudos.fxml");
            Parent TelaPlanosDeEstudos = FXMLLoader.load(url);
            borderPrincipal.setCenter(TelaPlanosDeEstudos);
            labelPrincipal.setText("Planos");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    } */
    
    @FXML private void exames(){
        System.out.println("teste");
        try {
            URL url = getClass().getResource("/visao/TelaExames.fxml");
            Parent TelaExames = FXMLLoader.load(url);
            borderPrincipal.setCenter(TelaExames);
            labelPrincipal.setText("Exames");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* @FXML private void pesquisar(){
        System.out.println("teste");
        try {
            URL url = getClass().getResource("/visao/TelaPesquisar.fxml");
            Parent TelaPesquisar = FXMLLoader.load(url);
            borderPrincipal.setCenter(TelaPesquisar);
            labelPrincipal.setText("Pesquisar");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    } */
    
    /* @FXML private void configuracoes(){
        System.out.println("teste");
        try {
            URL url = getClass().getResource("/visao/TelaConfiguracoes.fxml");
            Parent TelaConfiguracoes = FXMLLoader.load(url);
            borderPrincipal.setCenter(TelaConfiguracoes);
            labelPrincipal.setText("Configuraões");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    } */
    
    @FXML
	private void sair() {
		System.exit(0);
	}
    
    
    
}
