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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import star.sudoku.sqlite.AjudanteParaBD;

public class FXMLRegistoController implements Initializable 
{
    @FXML private TextField userTextField; 
    @FXML private PasswordField passwordTextField;  
    @FXML private PasswordField passwordConfirmTextField;
    
    @FXML
    private void handleRegisto(ActionEvent event) 
    {
        if (userTextField.getText().isEmpty() || passwordTextField.getText().isEmpty() || passwordConfirmTextField.getText().isEmpty())
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro durante o Registo");
            alert.setHeaderText("Por-favor, preencha todos os campos.");

            alert.showAndWait();
            return;
        }
        
        if(!passwordTextField.getText().equals(passwordConfirmTextField.getText()))
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro durante o Registo");
            alert.setHeaderText("As palavras-passe inseridas não são iguais");

            alert.showAndWait();
            return;
        }
        
        if(AjudanteParaBD.isNameInUse(userTextField.getText()))
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro durante o Registo");
            alert.setHeaderText("O nome não está disponível");

            alert.showAndWait();
            return;
        }
        
        if(AjudanteParaBD.insertUserInUtilizador(userTextField.getText(), passwordTextField.getText()))
        {
          
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Registo");
            alert.setHeaderText("Utilizador registado com sucesso.");
            alert.showAndWait();
            
            enterLogin();
        }
    }
    
    @FXML
    private void handleBack(ActionEvent event)
    {
        enterLogin();
    }
    
    private void enterLogin()
    {
        Parent root;
        try 
        {
            root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
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
