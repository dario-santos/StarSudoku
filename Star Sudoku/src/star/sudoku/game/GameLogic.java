package star.sudoku.game;

public class GameLogic 
{
    private GameLogic(){}
    
    public static boolean isBoardCorrect(int userBoard[][], int solution[][])
    {
        for(int a = 0; a < 6 ; a++)
            for(int i = 0; i < 9 ; i++)
                if(userBoard[a][i] != solution[a][i])
                    return false;
        
        return true;
    }
}
