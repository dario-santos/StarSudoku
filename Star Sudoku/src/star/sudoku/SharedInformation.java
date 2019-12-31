package star.sudoku;

import java.util.Timer;
import star.sudoku.sqlite.Utilizador;

public class SharedInformation 
{
    public static Utilizador user = null;
    public static int gameLevel = 0;
    public static Timer timer = null;
    
    private SharedInformation(){}
}
