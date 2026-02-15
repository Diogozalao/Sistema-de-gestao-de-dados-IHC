        package projeto_final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Projeto_final extends Application {
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        // Carrega o FXML
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        // Configura a cena
        Scene scene = new Scene(root);
        scene.setFill(null); // Importante para o StageStyle.TRANSPARENT
        
        // Adiciona o CSS
        scene.getStylesheets().add(getClass().getResource("loginDesign.css").toExternalForm());
        
        // Permite arrastar a janela
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
            stage.setOpacity(0.8);
        });
        
        root.setOnMouseReleased((MouseEvent event) -> {
            stage.setOpacity(1.0);
        });
        
        // Configura a janela sem bordas
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("SIGEF - Login");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}