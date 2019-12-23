package star.sudoku.game;

/**
 *
 * @author dario
 */
public class GameAesthetic 
{
    public static String getAreaColor(String id)
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
}
