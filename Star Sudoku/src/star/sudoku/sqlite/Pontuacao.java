package star.sudoku.sqlite;

public class Pontuacao 
{
    private String username;
    private int gameLevel;
    private int tempo;
    
    public Pontuacao(String username, int gameLevel, int tempo)
    {
        this.username = username;
        this.gameLevel = gameLevel;
        this.tempo = tempo;
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
