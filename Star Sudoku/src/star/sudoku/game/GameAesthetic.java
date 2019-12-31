package star.sudoku.game;

public class GameAesthetic 
{
    private GameAesthetic(){}
    
    public static String getAreaColor(char id)
    {
        if(id == '1')
            return "#F39005";
        if(id == '2')
            return "#ED98CD";
        if(id == '3')
            return "#C0EDFF";
        if(id == '4')
            return "#FDF779";
        if(id == '5')
            return "#FD8092";
        if(id == '6')
            return "#D8ED6E";
        return "";  
    }
}
