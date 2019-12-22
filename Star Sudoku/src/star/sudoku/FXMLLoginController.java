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
import javafx.scene.control.Label;


/**
 *
 * 
 */
public class FXMLLoginController implements Initializable {
    
    @FXML
    private TextField userTextField;
    @FXML
    private TextField passwordTextField;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {

/** alertas de espaços em branco*/
/** começa aqui */
       if (userTextField.getText().isEmpty()){
          AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Erro!", "Insira o seu username!");
          return;
       }
       if (passwordTextField.getText().isEmpty()){
          AlertHelper.showAlert(Alert.AlertType.ERROR, password, "Erro!", "Insira a sua password!");
          return;
       }

/** termina aqui */
       

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

