/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.sudoku;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author dario
 */
public class FXMLJogoController implements Initializable 
{
    // Area 1 - Laranja
    @FXML private TextField area1_1;
    @FXML private TextField area1_2;
    @FXML private TextField area1_3;
    @FXML private TextField area1_4;
    @FXML private TextField area1_5;
    @FXML private TextField area1_6;
    @FXML private TextField area1_7;
    @FXML private TextField area1_8;
    @FXML private TextField area1_9;
    
    // Area 2 - Roxo
    @FXML private TextField area2_1;
    @FXML private TextField area2_2;
    @FXML private TextField area2_3;
    @FXML private TextField area2_4;
    @FXML private TextField area2_5;
    @FXML private TextField area2_6;
    @FXML private TextField area2_7;
    @FXML private TextField area2_8;
    @FXML private TextField area2_9;
    
    // Area 3 - Azul
    @FXML private TextField area3_1;
    @FXML private TextField area3_2;
    @FXML private TextField area3_3;
    @FXML private TextField area3_4;
    @FXML private TextField area3_5;
    @FXML private TextField area3_6;
    @FXML private TextField area3_7;
    @FXML private TextField area3_8;
    @FXML private TextField area3_9;
    
    // Area 4 - Amarelo
    @FXML private TextField area4_1;
    @FXML private TextField area4_2;
    @FXML private TextField area4_3;
    @FXML private TextField area4_4;
    @FXML private TextField area4_5;
    @FXML private TextField area4_6;
    @FXML private TextField area4_7;
    @FXML private TextField area4_8;
    @FXML private TextField area4_9;
    
    // Area 5 - Rosa
    @FXML private TextField area5_1;
    @FXML private TextField area5_2;
    @FXML private TextField area5_3;
    @FXML private TextField area5_4;
    @FXML private TextField area5_5;
    @FXML private TextField area5_6;
    @FXML private TextField area5_7;
    @FXML private TextField area5_8;
    @FXML private TextField area5_9;
    
    // Area 6 - Verde
    @FXML private TextField area6_1;
    @FXML private TextField area6_2;
    @FXML private TextField area6_3;
    @FXML private TextField area6_4;
    @FXML private TextField area6_5;
    @FXML private TextField area6_6;
    @FXML private TextField area6_7;
    @FXML private TextField area6_8;
    @FXML private TextField area6_9;
    
    @FXML private AnchorPane pane;
                
    private ArrayList<ArrayList<TextField>> areas = new ArrayList<ArrayList<TextField>>(); 
    String numbers[] = new String[]{ "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    
    
    @FXML
    private void handleButtonValidate(ActionEvent event)
    {
        for(int i = 0 ; i < 6 ; i++)
            if(!isAreaCorrect(1))
            {
                pane.setStyle("-fx-background-color: #e74c3c;");
                return;
            }
            
        // Verificar as linhas
        // Verificar as colunas
        
        // Se correu tudo bem o jogo terminou
    }
    
    // Função para ver se uma area está correta
    private boolean isAreaCorrect(int area)
    {
        ArrayList<String> inputs = new ArrayList<>();
        
        for(TextField t : areas.get(area))
            inputs.add(t.getText());
        
        for(String s : numbers)
            if(!inputs.contains(s))
                return false;
        
        return true;
    }
    
    // Função para ver se uma linha está correta
    private void AreLinesCorrect()
    {
       // Area 2_1 & 2 & 3 & 4 & Area 3_5 & 6 & 7 & 8 & 9 
        
        
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        
        // Lista de Text fields para cada area
        ArrayList<TextField> area1 = new ArrayList<>();
        ArrayList<TextField> area2 = new ArrayList<>();
        ArrayList<TextField> area3 = new ArrayList<>();
        ArrayList<TextField> area4 = new ArrayList<>();
        ArrayList<TextField> area5 = new ArrayList<>();
        ArrayList<TextField> area6 = new ArrayList<>();
        
        area1.add(area1_1);
        area1.add(area1_2);
        area1.add(area1_3);
        area1.add(area1_4);
        area1.add(area1_5);
        area1.add(area1_6);
        area1.add(area1_7);
        area1.add(area1_8);
        area1.add(area1_9);
        
        area2.add(area2_1);
        area2.add(area2_2);
        area2.add(area2_3);
        area2.add(area2_4);
        area2.add(area2_5);
        area2.add(area2_6);
        area2.add(area2_7);
        area2.add(area2_8);
        area2.add(area2_9);
        
        area3.add(area3_1);
        area3.add(area3_2);
        area3.add(area3_3);
        area3.add(area3_4);
        area3.add(area3_5);
        area3.add(area3_6);
        area3.add(area3_7);
        area3.add(area3_8);
        area3.add(area3_9);
        
        area4.add(area4_1);
        area4.add(area4_2);
        area4.add(area4_3);
        area4.add(area4_4);
        area4.add(area4_5);
        area4.add(area4_6);
        area4.add(area4_7);
        area4.add(area4_8);
        area4.add(area4_9);
        
        area5.add(area5_1);
        area5.add(area5_2);
        area5.add(area5_3);
        area5.add(area5_4);
        area5.add(area5_5);
        area5.add(area5_6);
        area5.add(area5_7);
        area5.add(area5_8);
        area5.add(area5_9);
        
        area6.add(area6_1);
        area6.add(area6_2);
        area6.add(area6_3);
        area6.add(area6_4);
        area6.add(area6_5);
        area6.add(area6_6);
        area6.add(area6_7);
        area6.add(area6_8);
        area6.add(area6_9);
        
        
        areas.add(area1);
        areas.add(area2);
        areas.add(area3);
        areas.add(area4);
        areas.add(area5);
        areas.add(area6);
    }    
    
}
