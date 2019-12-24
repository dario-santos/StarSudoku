package star.sudoku;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import star.sudoku.sqlite.*;

public class FXMLPontuacaoController implements Initializable 
{
    @FXML private TableView lastGamesTable;
    
    @FXML private TableColumn  colName;
    @FXML private TableColumn  colGameLevel;
    @FXML private TableColumn  colTime;
    
    private void addGamesToTable(ArrayList<Pontuacao> pontuacoes)
    {
        for(Pontuacao p : pontuacoes)
            lastGamesTable.getItems().add(p);
    }
    
    @FXML
    private void handleEnterMainMenu(ActionEvent event) 
    {
        Parent root;
        try 
        {
            root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) lastGamesTable.getScene().getWindow();
            
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
        colName.setCellValueFactory(new PropertyValueFactory<>("username"));
        colGameLevel.setCellValueFactory(new PropertyValueFactory<>("gameLevel"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("tempo"));
        
        ArrayList<Pontuacao> pontuacoes = AjudanteParaBD.selectNPontuacao(10);
        
        addGamesToTable(pontuacoes);   
    }
}
