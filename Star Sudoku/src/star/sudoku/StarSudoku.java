package star.sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.util.Timer;
import star.sudoku.sqlite.AjudanteParaBD;

public class StarSudoku extends Application 
{
    @Override
    public void start(Stage stage) throws Exception 
    {
        SharedInformation.timer = new Timer();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void stop()
    {
        if(SharedInformation.timer != null)
            SharedInformation.timer.cancel();
    }

    public static void main(String[] args) 
    {
        // Cria a base de dados caso não exista
        File f = new File(AjudanteParaBD.DB_PATH);
        
        if(!f.exists() && !f.isDirectory()) 
            AjudanteParaBD.createNewDatabase();
            
        launch(args);
    }
    
    
}
