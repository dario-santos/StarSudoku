package star.sudoku.sqlite;

public class Pontuacao 
{
    private final int id;
    private final String username;
    private final int gameLevel;
    private final int tempo;
    
    public Pontuacao(int id, String username, int gameLevel, int tempo)
    {
        this.id = id;
        this.username = username;
        this.gameLevel = gameLevel;
        this.tempo = tempo;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public int getGameLevel()
    {
        return gameLevel;
    }
    
    public int getTempo()
    {
        return tempo;
    }
}
