/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ayrton Barreto
 */
public class main extends Application {
    private static Stage stagePrincipal;
    
    @Override
    public void start(Stage stage) throws Exception {
        stagePrincipal = stage;
        Parent root = FXMLLoader.load(getClass() .getResource("/visao/TelaPrincipal.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Menu");
        
        //Ocupa a tela toda
        /*
        stage.centerOnScreen();
        stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());*/
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static Stage getStagePrincipal() {
        return stagePrincipal;
    }

    public static void setStagePrincipal(Stage stagePrincipal) {
        main.stagePrincipal = stagePrincipal;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
