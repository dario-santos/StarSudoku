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
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import star.sudoku.sqlite.AjudanteParaBD;
import star.sudoku.sqlite.Utilizador;


public class FXMLLoginController implements Initializable {
    
    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField passwordTextField;
    
    @FXML
    private void handleLogin(ActionEvent event)
    {
        Utilizador u = AjudanteParaBD.selectUserFromUtilizador(userTextField.getText(), 
                passwordTextField.getText());
        if(u == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro durante o login");
            alert.setHeaderText("O utilizador ou a palavra-passe inserida está incorreta.");
            alert.showAndWait();
            return;
        }
           
        SharedInformation.user = u;
        enterMainMenu();
    }
    
    @FXML
    private void handleRegisto(ActionEvent event) 
    {
        Parent root;
        try 
        {
            root = FXMLLoader.load(getClass().getResource("FXMLRegisto.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) userTextField.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void enterMainMenu()
    {
        Parent root;
        try 
        {
            root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) userTextField.getScene().getWindow();
            
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

