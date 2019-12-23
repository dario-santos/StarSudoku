package star.sudoku.game;

import java.util.ArrayList;
import javafx.scene.control.TextField;

/**
 *
 * @author dario
 */
public class GameLogic 
{
    private static String numbers[] = new String[]{ "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    
    public static boolean isAreaCorrect(int area, ArrayList<ArrayList<TextField>> areas)
    {
        ArrayList<String> inputs = new ArrayList<>();
        
        for(TextField t : areas.get(area))
            inputs.add(t.getText());
        
        for(String s : numbers)
            if(!inputs.contains(s))
                return false;
        return true;
    }
    
    public static boolean isLineCorrect(int line, ArrayList<ArrayList<TextField>> lines)
    {
        ArrayList<String> inputs = new ArrayList<>();
        
        for(TextField t : lines.get(line))
            inputs.add(t.getText());
        
        for(String s : numbers)
            if(!inputs.contains(s))
                return false;
        return true;
    }
    
    public static boolean isDiagonalRCorrect(int diagonalr, ArrayList<ArrayList<TextField>> diagonalsr)
    {
        ArrayList<String> inputs = new ArrayList<>();
        
        for(TextField t : diagonalsr.get(diagonalr))
            inputs.add(t.getText());
        
        for(String s : numbers)
            if(!inputs.contains(s))
                return false;
        return true;
    }
    
    public static boolean isDiagonalLCorrect(int diagonall, ArrayList<ArrayList<TextField>> diagonalsl)
    {
        ArrayList<String> inputs = new ArrayList<>();
        
        for(TextField t : diagonalsl.get(diagonall))
            inputs.add(t.getText());
        
        for(String s : numbers)
            if(!inputs.contains(s))
                return false;
        return true;
    }
    
}
