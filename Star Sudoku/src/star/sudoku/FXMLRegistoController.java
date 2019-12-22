/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.sudoku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 *
 * 
 */
public class FXMLRegistoController implements Initializable 
{
    @FXML private TextField userTextField;
    @FXML private TextField passwordTextField;
    @FXML private TextField passwordConfirmTextField;
    
    @FXML
    private void handleButtonAction(ActionEvent event) 
    {
        if(!passwordTextField.getText().equals(passwordConfirmTextField.getText()))
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro durante o Registo");
            alert.setHeaderText("As passwords não são iguais");

            alert.showAndWait();
            return;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
