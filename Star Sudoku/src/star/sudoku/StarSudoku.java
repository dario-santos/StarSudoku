package star.sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import star.sudoku.sqlite.AjudanteParaBD;

public class StarSudoku extends Application 
{
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        // Cria a base de dados caso não exista
        //AjudanteParaBD.createNewDatabase();
        
        launch(args);
    }
}
