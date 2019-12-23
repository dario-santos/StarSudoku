/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.sudoku;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import star.sudoku.sqlite.AjudanteParaBD;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    
    @FXML private Button controlPause;
    @FXML private Label lTimer;
                
    private ArrayList<ArrayList<TextField>> areas = new ArrayList<>();
    private ArrayList<ArrayList<TextField>> lines = new ArrayList<>(); 
    private ArrayList<ArrayList<TextField>> diagonalsr = new ArrayList<>(); 
    private ArrayList<ArrayList<TextField>> diagonalsl = new ArrayList<>();
    
    
    private ArrayList<TextField> selected = new ArrayList<>();

    private int [][] solution = null;
    String numbers[] = new String[]{ "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    
    
    private boolean isGamePaused = false;
    
    private int start = 0;
    
    private int gameLevel = 0;
    private int idUser = 0;
    
    @FXML
    private void handleButtonValidate(ActionEvent event)
    {
        for(int i = 0 ; i < 6 ; i++)
            if(!isAreaCorrect(i, areas) || !isLineCorrect(i, lines))
            {
                pane.setStyle("-fx-background-color: #e74c3c;");
                //return;
            }

        // Verificar as colunas
        
        // Se correu tudo bem o jogo terminou
        pane.setStyle("-fx-background-color: #2ecc71;");
        
        
        String sql = "SELECT " + AjudanteParaBD.PONTUACAO_TEMPO + " , " + AjudanteParaBD.PONTUACAO_ID + " FROM " + AjudanteParaBD.TABELA_PONTUACAO 
                        + " WHERE " + AjudanteParaBD.PONTUACAO_IDUTILIZADOR +  " = " + idUser +  " and " + AjudanteParaBD.PONTUACAO_NIVEL +  " = " + gameLevel +  ";";
        
        boolean exists = false;
        int bestTime = 0;
        int idPontuancao = 0;
        
        try (Connection conn = AjudanteParaBD.ConnectToDB())
        {
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next())
            {
                exists = true;
                bestTime = rs.getInt(AjudanteParaBD.PONTUACAO_TEMPO);
                idPontuancao = rs.getInt(AjudanteParaBD.PONTUACAO_ID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // ----------------------------
        if(!exists)
        {
            sql = "INSERT INTO "+ AjudanteParaBD.TABELA_PONTUACAO + "(" + AjudanteParaBD.PONTUACAO_NIVEL + "," + AjudanteParaBD.PONTUACAO_TEMPO + "," + AjudanteParaBD.PONTUACAO_IDUTILIZADOR + ") VALUES(?,?,?)";

            try (Connection conn = AjudanteParaBD.ConnectToDB())
            {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, gameLevel);
                pstmt.setInt(2, start);
                pstmt.setInt(3, idUser);
                pstmt.executeUpdate();
            } catch (SQLException e) 
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            // Todo: Update
            if(start < bestTime)
            {
                sql = "UPDATE " + AjudanteParaBD.TABELA_PONTUACAO + " SET " + AjudanteParaBD.PONTUACAO_TEMPO + " = ? "
                   + " WHERE " + AjudanteParaBD.PONTUACAO_ID + " = ?";
                
                 try (Connection conn = AjudanteParaBD.ConnectToDB();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    // set the corresponding param
                    pstmt.setInt(1, start);
                    pstmt.setInt(2, idPontuancao);
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Update: " + e.getMessage());
                }
            }
        }
    }
    
    @FXML
    private void handlePauseGame(ActionEvent event)
    {
        isGamePaused = !isGamePaused;
        controlPause.setText(isGamePaused ? "Continuar" : "Pausar");

        for (int a = 0; a < 6; a++) 
        {
            ArrayList<TextField> area = areas.get(a);
            for (int i = 0; i < 9; i++)
                area.get(i).setVisible(!isGamePaused);
        }    
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
            
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleHighLigh(ActionEvent event)
    {
        for(TextField t : selected)
        {
            String areaId = t.getId().split("_")[0];
            String color = getColor(areaId);
            
            t.setStyle("-fx-background-color: " + color);
        }
        
        selected.clear();
        
        TextField t = (TextField) event.getSource();
        
        for(ArrayList<TextField> a : areas)
            if(a.contains(t))
                for(TextField tf : a)
                {
                    selected.add(tf);
                    tf.setStyle("-fx-background-color: #bdc3c7");
                }

        for(ArrayList<TextField> dr : diagonalsr)
            if(dr.contains(t))
                for(TextField tf : dr)
                {
                    selected.add(tf);
                    tf.setStyle("-fx-background-color: #bdc3c7");
                }
        
        for(ArrayList<TextField> dl : diagonalsl)
            if(dl.contains(t))
                for(TextField tf : dl)
                {
                    selected.add(tf);
                    tf.setStyle("-fx-background-color: #bdc3c7");
                }
        
    }
    
    private String getColor(String id)
    {
        if(id.equals("1"))
            return "#F39005";
        if(id.equals("2"))
            return "#ED98CD";
        if(id.equals("3"))
            return "#C0EDFF";
        if(id.equals("4"))
            return "#FDF779";
        if(id.equals("5"))
            return "#FD8092";
        if(id.equals("6"))
            return "#D8ED6E";
        return "";  
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
    
    private void loadSudokuBoard(int level)
    {
        int[][] initial = GameLevels.getInitialBoard(level);
        
        
        for(int a = 0 ; a < 6 ; a++)
        {
            ArrayList<TextField> area = areas.get(a);
            for(int i = 0 ; i < 9 ; i++)
            {
                if(initial[a][i] != 0)
                {
                    area.get(i).setText(String.valueOf(initial[a][i]));
                    area.get(i).setStyle("-fx-font-weight: bold");
                    
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
        idUser = SharedInformation.idUser;
        gameLevel = SharedInformation.gameLevel;
        
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
        
        //diagonais direitas
        ArrayList<TextField> diagonalr1 = new ArrayList<>();
        ArrayList<TextField> diagonalr2 = new ArrayList<>();
        ArrayList<TextField> diagonalr3 = new ArrayList<>();
        ArrayList<TextField> diagonalr4 = new ArrayList<>();
        ArrayList<TextField> diagonalr5 = new ArrayList<>();
        ArrayList<TextField> diagonalr6 = new ArrayList<>();
        
        diagonalr1.add(area1_5);
        diagonalr1.add(area1_6);
        diagonalr1.add(area1_2);
        diagonalr1.add(area1_3);
        diagonalr1.add(area1_1);
        diagonalr1.add(area6_2);
        diagonalr1.add(area6_5);
        diagonalr1.add(area6_6);
        diagonalr1.add(area6_7);
        
        diagonalr2.add(area2_5);
        diagonalr2.add(area1_7);
        diagonalr2.add(area1_8);
        diagonalr2.add(area1_4);
        diagonalr2.add(area6_1);
        diagonalr2.add(area6_3);
        diagonalr2.add(area6_4);
        diagonalr2.add(area6_8);
        diagonalr2.add(area6_9);
        
        diagonalr3.add(area2_2);
        diagonalr3.add(area2_6);
        diagonalr3.add(area2_7);
        diagonalr3.add(area1_9);
        diagonalr3.add(area5_5);
        diagonalr3.add(area5_6);
        diagonalr3.add(area5_2);
        diagonalr3.add(area5_3);
        diagonalr3.add(area5_1);

        diagonalr4.add(area2_1);
        diagonalr4.add(area2_3);
        diagonalr4.add(area2_4);
        diagonalr4.add(area2_8);
        diagonalr4.add(area2_9);
        diagonalr4.add(area4_5);
        diagonalr4.add(area5_7);
        diagonalr4.add(area5_8);
        diagonalr4.add(area5_4);
        
        diagonalr5.add(area3_5);
        diagonalr5.add(area3_6);
        diagonalr5.add(area3_2);
        diagonalr5.add(area3_3);
        diagonalr5.add(area3_1);
        diagonalr5.add(area4_2);
        diagonalr5.add(area4_6);
        diagonalr5.add(area4_7);
        diagonalr5.add(area5_9);
        
        diagonalr6.add(area3_7);
        diagonalr6.add(area3_8);
        diagonalr6.add(area3_9);
        diagonalr6.add(area3_4);
        diagonalr6.add(area5_1);
        diagonalr6.add(area5_3);
        diagonalr6.add(area5_4);
        diagonalr6.add(area5_8);
        diagonalr6.add(area5_9);
        
        diagonalsr.add(diagonalr1);
        diagonalsr.add(diagonalr2);
        diagonalsr.add(diagonalr3);
        diagonalsr.add(diagonalr4);
        diagonalsr.add(diagonalr5);
        diagonalsr.add(diagonalr6);
        
        //diagonais esquerdas
        ArrayList<TextField> diagonall1 = new ArrayList<>();
        ArrayList<TextField> diagonall2 = new ArrayList<>();
        ArrayList<TextField> diagonall3 = new ArrayList<>();
        ArrayList<TextField> diagonall4 = new ArrayList<>();
        ArrayList<TextField> diagonall5 = new ArrayList<>();
        ArrayList<TextField> diagonall6 = new ArrayList<>();
        
        diagonall1.add(area2_1);
        diagonall1.add(area2_2);
        diagonall1.add(area2_3);
        diagonall1.add(area2_5);
        diagonall1.add(area2_6);
        diagonall1.add(area1_5);
        diagonall1.add(area1_6);
        diagonall1.add(area1_7);
        diagonall1.add(area1_2);
        
        diagonall2.add(area3_5);
        diagonall2.add(area2_4);
        diagonall2.add(area2_7);
        diagonall2.add(area2_8);
        diagonall2.add(area1_8);
        diagonall2.add(area1_9);
        diagonall2.add(area1_3);
        diagonall2.add(area1_4);
        diagonall2.add(area1_1);
        
        diagonall3.add(area3_7);
        diagonall3.add(area3_6);
        diagonall3.add(area2_9);
        diagonall3.add(area3_2);
        diagonall3.add(area6_1);
        diagonall3.add(area6_2);
        diagonall3.add(area6_3);
        diagonall3.add(area6_5);
        diagonall3.add(area6_6);

        diagonall4.add(area3_8);
        diagonall4.add(area3_9);
        diagonall4.add(area3_3);
        diagonall4.add(area3_4);
        diagonall4.add(area3_1);
        diagonall4.add(area6_4);
        diagonall4.add(area5_5);
        diagonall4.add(area6_7);
        diagonall4.add(area6_8);
        
        diagonall5.add(area4_1);
        diagonall5.add(area4_2);
        diagonall5.add(area4_3);
        diagonall5.add(area4_5);
        diagonall5.add(area4_6);
        diagonall5.add(area5_6);
        diagonall5.add(area5_7);
        diagonall5.add(area6_9);
        diagonall5.add(area5_2);
        
        diagonall6.add(area4_4);
        diagonall6.add(area4_7);
        diagonall6.add(area4_8);
        diagonall6.add(area4_9);
        diagonall6.add(area5_8);
        diagonall6.add(area5_9);
        diagonall6.add(area5_3);
        diagonall6.add(area5_4);
        diagonall6.add(area5_1);
        
        diagonalsl.add(diagonall1);
        diagonalsl.add(diagonall2);
        diagonalsl.add(diagonall3);
        diagonalsl.add(diagonall4);
        diagonalsl.add(diagonall5);
        diagonalsl.add(diagonall6);
        
        
        loadSudokuBoard(gameLevel);
        
        // Clock
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() 
        {
            @Override
            public void run() 
            {
                Platform.runLater(() -> 
                {
                    if(isGamePaused)
                        return;
                    
                    start++;
                    int hours = (int)   start / 3600;
                    int minutes = (int) (start % 3600) / 60;
                    int seconds = (int) start % 60;

                    String timeLeftFormatted;
                    if(hours == 0 && minutes == 0)
                    {
                        timeLeftFormatted = String.format(Locale.getDefault(), "00m%02ds", seconds);
                    }
                    else if (hours == 0)
                    {
                        timeLeftFormatted = String.format(Locale.getDefault(), "%02dm%02ds", minutes, seconds);
                    }
                    else
                    {
                        timeLeftFormatted = String.format(Locale.getDefault(),"%02dh%02dm%02ds",hours, minutes, seconds);
                    }
                    lTimer.setText(timeLeftFormatted);
                });
            }
        }, 0, 1000);
        
    }    
}
