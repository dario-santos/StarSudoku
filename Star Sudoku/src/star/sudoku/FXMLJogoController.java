package star.sudoku;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import star.sudoku.sqlite.AjudanteParaBD;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import star.sudoku.game.*;
import star.sudoku.sqlite.Pontuacao;

public class FXMLJogoController implements Initializable 
{
    // Area 1 - Orange
    @FXML private Polygon area1_1;  @FXML private Label text1_1;
    @FXML private Polygon area1_2;  @FXML private Label text1_2;
    @FXML private Polygon area1_3;  @FXML private Label text1_3;
    @FXML private Polygon area1_4;  @FXML private Label text1_4;
    @FXML private Polygon area1_5;  @FXML private Label text1_5;
    @FXML private Polygon area1_6;  @FXML private Label text1_6;
    @FXML private Polygon area1_7;  @FXML private Label text1_7;
    @FXML private Polygon area1_8;  @FXML private Label text1_8;
    @FXML private Polygon area1_9;  @FXML private Label text1_9;
    
    // Area 2 - Purple
    @FXML private Polygon area2_1;  @FXML private Label text2_1;
    @FXML private Polygon area2_2;  @FXML private Label text2_2;
    @FXML private Polygon area2_3;  @FXML private Label text2_3;
    @FXML private Polygon area2_4;  @FXML private Label text2_4;
    @FXML private Polygon area2_5;  @FXML private Label text2_5;
    @FXML private Polygon area2_6;  @FXML private Label text2_6;
    @FXML private Polygon area2_7;  @FXML private Label text2_7;
    @FXML private Polygon area2_8;  @FXML private Label text2_8;
    @FXML private Polygon area2_9;  @FXML private Label text2_9;
    
    // Area 3 - Blue
    @FXML private Polygon area3_1;  @FXML private Label text3_1;
    @FXML private Polygon area3_2;  @FXML private Label text3_2;
    @FXML private Polygon area3_3;  @FXML private Label text3_3;
    @FXML private Polygon area3_4;  @FXML private Label text3_4;
    @FXML private Polygon area3_5;  @FXML private Label text3_5;
    @FXML private Polygon area3_6;  @FXML private Label text3_6;
    @FXML private Polygon area3_7;  @FXML private Label text3_7;
    @FXML private Polygon area3_8;  @FXML private Label text3_8;
    @FXML private Polygon area3_9;  @FXML private Label text3_9;
    
    // Area 4 - Yellow
    @FXML private Polygon area4_1;  @FXML private Label text4_1;
    @FXML private Polygon area4_2;  @FXML private Label text4_2;
    @FXML private Polygon area4_3;  @FXML private Label text4_3;
    @FXML private Polygon area4_4;  @FXML private Label text4_4;
    @FXML private Polygon area4_5;  @FXML private Label text4_5;
    @FXML private Polygon area4_6;  @FXML private Label text4_6;
    @FXML private Polygon area4_7;  @FXML private Label text4_7;
    @FXML private Polygon area4_8;  @FXML private Label text4_8;
    @FXML private Polygon area4_9;  @FXML private Label text4_9;
   
    // Area 5 - Pink
    @FXML private Polygon area5_1;  @FXML private Label text5_1;
    @FXML private Polygon area5_2;  @FXML private Label text5_2;
    @FXML private Polygon area5_3;  @FXML private Label text5_3;
    @FXML private Polygon area5_4;  @FXML private Label text5_4;
    @FXML private Polygon area5_5;  @FXML private Label text5_5;
    @FXML private Polygon area5_6;  @FXML private Label text5_6;
    @FXML private Polygon area5_7;  @FXML private Label text5_7;
    @FXML private Polygon area5_8;  @FXML private Label text5_8;
    @FXML private Polygon area5_9;  @FXML private Label text5_9;
    
    // Area 6 - Green
    @FXML private Polygon area6_1;  @FXML private Label text6_1;
    @FXML private Polygon area6_2;  @FXML private Label text6_2;
    @FXML private Polygon area6_3;  @FXML private Label text6_3;
    @FXML private Polygon area6_4;  @FXML private Label text6_4;
    @FXML private Polygon area6_5;  @FXML private Label text6_5;
    @FXML private Polygon area6_6;  @FXML private Label text6_6;
    @FXML private Polygon area6_7;  @FXML private Label text6_7;
    @FXML private Polygon area6_8;  @FXML private Label text6_8;
    @FXML private Polygon area6_9;  @FXML private Label text6_9;
    
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Button button5;
    @FXML private Button button6;
    @FXML private Button button7;
    @FXML private Button button8;
    @FXML private Button button9;
    @FXML private Button buttonEmpty;
    
    @FXML private AnchorPane pane;
    @FXML private Button controlPause;
    @FXML private Button verificar;
    @FXML private Label lTimer;
    @FXML private Label lGameLevel;
    @FXML private Label lCongratulations;
    
    private ArrayList<ArrayList<Label>> labels = new ArrayList<>();
    private ArrayList<ArrayList<Polygon>> areas = new ArrayList<>();
    
    private Map<Polygon, Label> dic = new HashMap<>();
    
    private Label selectedLabel = null;
    private Polygon selectedPolygon = null;
    
    private boolean isGamePaused = false;
    private int [][] userBoard = null;
    private int [][] solution = null;
    private int currentTime = 0;
    
    @FXML
    private void handleButtonValidate(ActionEvent event)
    {
        if(!GameLogic.isBoardCorrect(userBoard, solution)) 
        {
            verificar.setStyle("-fx-background-color: #e74c3c;");
            return;
        }
        
        Pontuacao pont = AjudanteParaBD.selectPontuacaoByUserAndLevel(
                SharedInformation.user.getUsername(), SharedInformation.gameLevel);
       
        // Create or Update user time
        if(pont == null)
        {
            AjudanteParaBD.insertPontuation(SharedInformation.gameLevel,currentTime, 
                    SharedInformation.user.getUsername());
        }
        else
        {
            if(currentTime < pont.getTempo())
                  AjudanteParaBD.updateGameLevelTime(pont.getId(), currentTime);
        }
        
        endGame();
    }
    
    private void endGame()
    {
        pane.setStyle("-fx-background-color: #8BC34A;");
        
        SharedInformation.timer.cancel();
        
        for(Polygon key : dic.keySet())
        {
            key.setVisible(false);
            dic.get(key).setVisible(false);
        }

        verificar.setVisible(false);
        controlPause.setVisible(false);
        
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        button5.setVisible(false);
        button6.setVisible(false);
        button7.setVisible(false);
        button8.setVisible(false);
        button9.setVisible(false);
        buttonEmpty.setVisible(false);
        lCongratulations.setVisible(true);
    }
    
    @FXML
    private void handlePauseGame(ActionEvent event)
    {
        isGamePaused = !isGamePaused;
        controlPause.setText(isGamePaused ? "Continuar" : "Pausar");

        for(Polygon key : dic.keySet())
        {
            key.setVisible(!isGamePaused);
            dic.get(key).setVisible(!isGamePaused);
        }
        
        button1.setVisible(!isGamePaused);
        button2.setVisible(!isGamePaused);
        button3.setVisible(!isGamePaused);
        button4.setVisible(!isGamePaused);
        button5.setVisible(!isGamePaused);
        button6.setVisible(!isGamePaused);
        button7.setVisible(!isGamePaused);
        button8.setVisible(!isGamePaused);
        button9.setVisible(!isGamePaused);
        buttonEmpty.setVisible(!isGamePaused);
    }
    
    @FXML
    private void handleBack(ActionEvent event)
    {
        Parent root;
        try 
        {
            root = FXMLLoader.load(getClass().getResource("FXMLSelecionarNivel.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) controlPause.getScene().getWindow();
            
            SharedInformation.timer.cancel();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
            
            SharedInformation.timer.cancel();
        }
    }

    @FXML
    private void handleUpdateValue(ActionEvent event)
    {
        String text = ((Button) event.getSource()).getText();
        
        if(text.equals("X"))
            text = " ";
        
        if(selectedLabel == null)
            return;
        
        selectedLabel.setText(text);
        
        int i = Character.getNumericValue(selectedLabel.getId().charAt(selectedLabel.getId().length() - 1));
        int a = Character.getNumericValue(selectedLabel.getId().split("text")[1].charAt(0));
        
        if(text.equals(" "))
            userBoard[a - 1][i - 1] = 0;
        else
            userBoard[a - 1][i - 1] = Integer.valueOf(text);
    }
    
    @FXML
    private void handleHighLigh(MouseEvent event)
    {
        if(selectedPolygon != null)
        {
            String areaId = selectedPolygon.getId().split("_")[0];
            String color = GameAesthetic.getAreaColor(areaId.charAt(areaId.length() - 1));

            selectedPolygon.fillProperty().setValue(Paint.valueOf(color));
        }
        
        Polygon newSelecetdPolygon = (Polygon) event.getSource();
        newSelecetdPolygon.fillProperty().setValue(Paint.valueOf("#bdc3c7"));
        
        selectedLabel = dic.get(newSelecetdPolygon);
        selectedPolygon = newSelecetdPolygon;
    }

    private void loadSudokuBoard(int level)
    {
        userBoard = GameLevels.getInitialBoard(level);
        solution = GameLevels.getSolutionBoard(level);
        
        for(int a = 0 ; a < 6 ; a++)
        {
            ArrayList<Polygon> area = areas.get(a);
            for(int i = 0 ; i < 9 ; i++)
            {
                if(userBoard[a][i] != 0)
                {
                    area.get(i).setDisable(true);
                    dic.get(area.get(i)).setText(String.valueOf(userBoard[a][i]));
                }
                else
                {
                    dic.get(area.get(i)).setText("");
                }
            }
        }
        
    }
    
    private void startClock()
    {
        SharedInformation.timer = new Timer();
        
        SharedInformation.timer.scheduleAtFixedRate(new TimerTask() 
        {
            @Override
            public void run() 
            {
                Platform.runLater(() -> 
                {
                    if(isGamePaused)
                        return;
                    
                    currentTime++;
                    int hours = (int)   currentTime / 3600;
                    int minutes = (int) (currentTime % 3600) / 60;
                    int seconds = (int) currentTime % 60;

                    String timeLeftFormatted;
                    if(hours == 0 && minutes == 0)
                        timeLeftFormatted = String.format(Locale.getDefault(), "00m%02ds", seconds);
                    else if (hours == 0)
                        timeLeftFormatted = String.format(Locale.getDefault(), "%02dm%02ds", minutes, seconds);
                    else
                        timeLeftFormatted = String.format(Locale.getDefault(), "%02dh%02dm%02ds",hours, minutes, seconds);
                    
                    lTimer.setText(timeLeftFormatted);
                });
            }
        }, 0, 1000);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {   
        lGameLevel.setText("Nivel: " + SharedInformation.gameLevel);
        
        // Lista de Text fields para cada area
        ArrayList<Polygon> area1 = new ArrayList<>();
        ArrayList<Polygon> area2 = new ArrayList<>();
        ArrayList<Polygon> area3 = new ArrayList<>();
        ArrayList<Polygon> area4 = new ArrayList<>();
        ArrayList<Polygon> area5 = new ArrayList<>();
        ArrayList<Polygon> area6 = new ArrayList<>();
        
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
                
        dic.put(area1_1, text1_1);
        dic.put(area1_2, text1_2);
        dic.put(area1_3, text1_3);
        dic.put(area1_4, text1_4);
        dic.put(area1_5, text1_5);
        dic.put(area1_6, text1_6);
        dic.put(area1_7, text1_7);
        dic.put(area1_8, text1_8);
        dic.put(area1_9, text1_9);
        
        dic.put(area2_1, text2_1);
        dic.put(area2_2, text2_2);
        dic.put(area2_3, text2_3);
        dic.put(area2_4, text2_4);
        dic.put(area2_5, text2_5);
        dic.put(area2_6, text2_6);
        dic.put(area2_7, text2_7);
        dic.put(area2_8, text2_8);
        dic.put(area2_9, text2_9);
        
        dic.put(area3_1, text3_1);
        dic.put(area3_2, text3_2);
        dic.put(area3_3, text3_3);
        dic.put(area3_4, text3_4);
        dic.put(area3_5, text3_5);
        dic.put(area3_6, text3_6);
        dic.put(area3_7, text3_7);
        dic.put(area3_8, text3_8);
        dic.put(area3_9, text3_9);
        
        dic.put(area4_1, text4_1);
        dic.put(area4_2, text4_2);
        dic.put(area4_3, text4_3);
        dic.put(area4_4, text4_4);
        dic.put(area4_5, text4_5);
        dic.put(area4_6, text4_6);
        dic.put(area4_7, text4_7);
        dic.put(area4_8, text4_8);
        dic.put(area4_9, text4_9);
        
        dic.put(area5_1, text5_1);
        dic.put(area5_2, text5_2);
        dic.put(area5_3, text5_3);
        dic.put(area5_4, text5_4);
        dic.put(area5_5, text5_5);
        dic.put(area5_6, text5_6);
        dic.put(area5_7, text5_7);
        dic.put(area5_8, text5_8);
        dic.put(area5_9, text5_9);   
        
        dic.put(area6_1, text6_1);
        dic.put(area6_2, text6_2);
        dic.put(area6_3, text6_3);
        dic.put(area6_4, text6_4);
        dic.put(area6_5, text6_5);
        dic.put(area6_6, text6_6);
        dic.put(area6_7, text6_7);
        dic.put(area6_8, text6_8);
        dic.put(area6_9, text6_9);
        
        loadSudokuBoard(SharedInformation.gameLevel);
        
        startClock();
    }    
}
