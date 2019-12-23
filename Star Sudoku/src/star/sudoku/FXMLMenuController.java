/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class FXMLMenuController implements Initializable 
{
    @FXML
    private Button buttonJogar;

    @FXML
    private Button buttonOpcoes;

    @FXML
    private Button buttonPerfil;

    @FXML
    private Button buttonPontuacao;

    @FXML
    private Button buttonInfo;
    
    @FXML
    private void handleJogarAction(ActionEvent event) 
    {
        Parent root;
        try 
        {
            root = FXMLLoader.load(getClass().getResource("FXMLSelecionarNivel.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) buttonJogar.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleEnterInfo(ActionEvent event)
    {
        Parent root;
        try 
        {
            root = FXMLLoader.load(getClass().getResource("FXMLInfo.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) buttonJogar.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleEnterPerfil(ActionEvent event) 
    {
        Parent root;
        try 
        {
            root = FXMLLoader.load(getClass().getResource("FXMLPerfil.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) buttonJogar.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleEnterPontuacao(ActionEvent event) 
    {
        Parent root;
        try 
        {
            root = FXMLLoader.load(getClass().getResource("FXMLPontuacao.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) buttonJogar.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleSignOut(ActionEvent event) 
    {
        Parent root;
        try 
        {
            SharedInformation.user = null;
            
            root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) buttonJogar.getScene().getWindow();
            
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
    public void initialize(URL url, ResourceBundle rb) {}
}
