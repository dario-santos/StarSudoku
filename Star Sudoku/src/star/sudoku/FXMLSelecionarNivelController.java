package star.sudoku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLSelecionarNivelController implements Initializable 
{    
    @FXML
    private void handleLevelSelector(ActionEvent event) 
    {
        Parent root;
        Button b = (Button) event.getSource();
        try 
        {
            SharedInformation.gameLevel = Integer.valueOf(b.getText());
            root = FXMLLoader.load(getClass().getResource("FXMLJogo.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) b.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleBack(ActionEvent event)
    {
        Parent root;
        Button b = (Button) event.getSource();
        
        try 
        {
            root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) b.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
}
