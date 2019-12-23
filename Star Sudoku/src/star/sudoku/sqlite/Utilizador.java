package star.sudoku.sqlite;

public class Utilizador 
{
    private int id;
    private String username;
    
    public Utilizador(int id, String username)
    {
        this.id = id;
        this.username = username;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public String getUsername()
    {
        return username;
    }
}
