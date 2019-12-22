/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.sudoku;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    
    @FXML private Label lTimer;
    long start = 0;
                
    private ArrayList<ArrayList<TextField>> areas = new ArrayList<ArrayList<TextField>>();
    private ArrayList<ArrayList<TextField>> lines = new ArrayList<ArrayList<TextField>>(); 
    private ArrayList<ArrayList<TextField>> columns = new ArrayList<ArrayList<TextField>>(); 

    private int [][] solution = null;
    String numbers[] = new String[]{ "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    
    @FXML
    private void handleButtonValidate(ActionEvent event)
    {
        for(int i = 0 ; i < 6 ; i++)
            if(!isAreaCorrect(i, areas) || !isLineCorrect(i, lines))
            {
                pane.setStyle("-fx-background-color: #e74c3c;");
                return;
            }

        // Verificar as colunas
        
        // Se correu tudo bem o jogo terminou
        pane.setStyle("-fx-background-color: #2ecc71;");

    }
    
    // Função para ver se uma area está correta
    private boolean isAreaCorrect(int area, ArrayList<ArrayList<TextField>> areas)
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
    private boolean isLineCorrect(int line, ArrayList<ArrayList<TextField>> lines)
    {
        ArrayList<String> inputs = new ArrayList<>();
        
        for(TextField t : lines.get(line))
            inputs.add(t.getText());
        
        for(String s : numbers)
            if(!inputs.contains(s))
                return false;
        
        return true;
    }

    
    private void loadSudokuBoard()
    {
        int[][] initial = GameLevels.getInitialBoard(1);
        
        
        for(int a = 0 ; a < 6 ; a++)
        {
            ArrayList<TextField> area = areas.get(a);
            for(int i = 0 ; i < 9 ; i++)
            {
                if(initial[a][i] != 0)
                {
                    area.get(i).setText(String.valueOf(initial[a][i]));
                    area.get(i).setEditable(false);
                }
                else
                    area.get(i).setText("");     
            }
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
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
        
        //lines
        ArrayList<TextField> line1 = new ArrayList<>();
        ArrayList<TextField> line2 = new ArrayList<>();
        ArrayList<TextField> line3 = new ArrayList<>();
        ArrayList<TextField> line4 = new ArrayList<>();
        ArrayList<TextField> line5 = new ArrayList<>();
        ArrayList<TextField> line6 = new ArrayList<>();
        
        line1.add(area5_1);
        line1.add(area5_4);
        line1.add(area5_3);
        line1.add(area5_2);
        line1.add(area6_9);
        line1.add(area6_8);
        line1.add(area6_7);
        line1.add(area6_6);
        line1.add(area6_5);
        
        line2.add(area1_1);
        line2.add(area6_2);
        line2.add(area6_3);
        line2.add(area6_4);
        line2.add(area5_5);
        line2.add(area5_6);
        line2.add(area5_7);
        line2.add(area5_8);
        line2.add(area5_9);
        
        line3.add(area1_2);
        line3.add(area1_3);
        line3.add(area1_4);
        line3.add(area6_1);
        line3.add(area4_5);
        line3.add(area4_6);
        line3.add(area4_7);
        line3.add(area4_8);
        line3.add(area4_9);

        line4.add(area1_5);
        line4.add(area1_6);
        line4.add(area1_7);
        line4.add(area1_8);
        line4.add(area1_9);
        line4.add(area3_1);
        line4.add(area4_2);
        line4.add(area4_3);
        line4.add(area4_4);
        
        line5.add(area2_5);
        line5.add(area2_6);
        line5.add(area2_7);
        line5.add(area2_8);
        line5.add(area2_9);
        line5.add(area3_2);
        line5.add(area3_3);
        line5.add(area3_4);
        line5.add(area4_1);
        
        line6.add(area2_2);
        line6.add(area2_3);
        line6.add(area2_4);
        line6.add(area3_5);
        line6.add(area3_6);
        line6.add(area3_7);
        line6.add(area3_8);
        line6.add(area3_9);
        line6.add(area2_1);
        
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);
        lines.add(line5);
        lines.add(line6);
        
        /*
        //collumns
        ArrayList<TextField> column1 = new ArrayList<>();
        ArrayList<TextField> column2 = new ArrayList<>();
        ArrayList<TextField> column3 = new ArrayList<>();
        ArrayList<TextField> column4 = new ArrayList<>();
        ArrayList<TextField> column5 = new ArrayList<>();
        ArrayList<TextField> column6 = new ArrayList<>();
        
        column1.add(area5_1);
        column1.add(area5_4);
        column1.add(area5_3);
        column1.add(area5_2);
        column1.add(area6_9);
        column1.add(area6_8);
        column1.add(area6_7);
        column1.add(area6_6);
        column1.add(area6_5);
        
        column2.add(area1_1);
        column2.add(area6_2);
        column2.add(area6_3);
        column2.add(area6_4);
        column2.add(area5_5);
        column2.add(area5_6);
        column2.add(area5_7);
        column2.add(area5_8);
        column2.add(area5_9);
        
        column3.add(area1_2);
        column3.add(area1_3);
        column3.add(area1_4);
        column3.add(area6_1);
        column3.add(area4_5);
        column3.add(area4_6);
        column3.add(area4_7);
        column3.add(area4_8);
        column3.add(area4_9);

        column4.add(area1_5);
        column4.add(area1_6);
        column4.add(area1_7);
        column4.add(area1_8);
        column4.add(area1_9);
        column4.add(area3_1);
        column4.add(area4_2);
        column4.add(area4_3);
        column4.add(area4_4);
        
        column5.add(area2_5);
        column5.add(area2_6);
        column5.add(area2_7);
        column5.add(area2_8);
        column5.add(area2_9);
        column5.add(area3_2);
        column5.add(area3_3);
        column5.add(area3_4);
        column5.add(area4_1);
        
        column6.add(area2_2);
        column6.add(area2_3);
        column6.add(area2_4);
        column6.add(area3_5);
        column6.add(area3_6);
        column6.add(area3_7);
        column6.add(area3_8);
        column6.add(area3_9);
        column6.add(area2_1);
        
        columns.add(column1);
        columns.add(column2);
        columns.add(column3);
        columns.add(column4);
        columns.add(column5);
        columns.add(column6);
        */
        
        loadSudokuBoard();
        Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() 
            {
                Platform.runLater(() -> 
                {
                    lTimer.setText(String.valueOf(start++));
                });
            }
        }, 0, 1000);
    }    
}
