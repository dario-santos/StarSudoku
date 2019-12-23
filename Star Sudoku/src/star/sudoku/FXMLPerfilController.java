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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLPerfilController implements Initializable 
{
    @FXML private Label lUsername;
    
    @FXML
    private void handleEnterMainMenu(ActionEvent event) 
    {
        Parent root;
        try 
        {
            root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) lUsername.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        lUsername.setText(SharedInformation.user.getUsername());
    }    
    
}
