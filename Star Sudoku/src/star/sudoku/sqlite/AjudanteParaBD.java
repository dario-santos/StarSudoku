package star.sudoku.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AjudanteParaBD 
{   
    public static final String DB_PATH = "./StarSudoku.db";
    private static final String DB_NOME = "StarSudoku";

    // Table Names
    public static final String TABELA_UTILIZADOR = "Utilizador";
    public static final String TABELA_PONTUACAO = "Pontuacao";

    // Tabela Utilizador - Colunas
    public static final String UTILIZADOR_ID = "idUtilizador";
    public static final String UTILIZADOR_NOME = "Nome";
    public static final String UTILIZADOR_PALAVRAPASSE = "PalavraPasse";

    // Tabela Pontuacao - Colunas
    public static final String PONTUACAO_ID = "idPontuacao";
    public static final String PONTUACAO_NIVEL = "Nível";
    public static final String PONTUACAO_TEMPO = "Tempo";
    public static final String PONTUACAO_IDUTILIZADOR = "idUtilizador";

    // Table Create Statements
    // User table create statement
    private static final String CREATE_TABELA_UTILIZADOR = "CREATE TABLE " + TABELA_UTILIZADOR + "("
            + UTILIZADOR_ID + " INTEGER PRIMARY KEY, "
            + UTILIZADOR_NOME + " VARCHAR(20), "
            + UTILIZADOR_PALAVRAPASSE + " VARCHAR(20)"
            + ");";

    // Game table create statement
    private static final String CREATE_TABELA_PONTUACAO = "CREATE TABLE " + TABELA_PONTUACAO + "("
            + PONTUACAO_ID + " INTEGER PRIMARY KEY,"
            + PONTUACAO_NIVEL + " INTEGER,"
            + PONTUACAO_TEMPO + " INTEGER,"
            + PONTUACAO_IDUTILIZADOR + " INTEGER"
            + ");";

    private AjudanteParaBD() {}
    
    public static void createNewDatabase() 
    {
        String url = "jdbc:sqlite:" + DB_PATH;
        
        try (Connection conn = DriverManager.getConnection(url))
        {
            if (conn != null)
            {
                Statement stmt = conn.createStatement();
                
                // Cria as tabelas
                stmt.execute(CREATE_TABELA_PONTUACAO);
                stmt.execute(CREATE_TABELA_UTILIZADOR);
                System.out.println("A base de dados" + DB_NOME + ".db foi criada.");
                System.out.println("As tabelas " + TABELA_UTILIZADOR + " e " + TABELA_PONTUACAO + " foram criadas.");
    
            }
        } catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }

    public static Connection ConnectToDB() 
    {
        Connection conn = null;
        try 
        {
            String url = "jdbc:sqlite:" + DB_PATH;
            
            conn = DriverManager.getConnection(url);
            
            System.out.println("A conecção ao SQLite foi estabelecida.");
            return conn;
        } 
        catch(SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static void DisconnectFromDB(Connection conn)
    {
        try 
        {
            if (conn != null)
                conn.close();
                
        } catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void insert() 
    {
        String sql = "INSERT INTO "+ TABELA_UTILIZADOR + "(" + UTILIZADOR_NOME + "," + UTILIZADOR_PALAVRAPASSE + ") VALUES(?,?)";
 
        try (Connection conn = ConnectToDB())
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Dario");
            pstmt.setString(2, "123");
            pstmt.executeUpdate();
        } catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void selectAll()
    {
        String sql = "SELECT * FROM " + TABELA_UTILIZADOR + ";";
        
        try (Connection conn = ConnectToDB())
        {
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) 
            {
                System.out.println(rs.getInt(UTILIZADOR_ID) +  "\t" + 
                                   rs.getString(UTILIZADOR_NOME) + "\t" +
                                   rs.getString(UTILIZADOR_PALAVRAPASSE));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insertPontuation(int gameLevel, int time, int idUser)
    {
        String sql = "INSERT INTO " + AjudanteParaBD.TABELA_PONTUACAO + "(" 
                + AjudanteParaBD.PONTUACAO_NIVEL + "," 
                + AjudanteParaBD.PONTUACAO_TEMPO + "," 
                + AjudanteParaBD.PONTUACAO_IDUTILIZADOR + ") VALUES(?,?,?)";

        try (Connection conn = AjudanteParaBD.ConnectToDB()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, gameLevel);
            pstmt.setInt(2, time);
            pstmt.setInt(3, idUser);
            pstmt.executeUpdate();
        } catch (SQLException e) 
        {
            System.out.println("AjudanteParaBD.insertPontuation: " + e.getMessage());
        }
    }
    
    public static void updateGameLevelTime(int idPontuacao, int time) 
    {
        String sql = "UPDATE " + AjudanteParaBD.TABELA_PONTUACAO + " SET " + AjudanteParaBD.PONTUACAO_TEMPO + " = ? "
                + " WHERE " + AjudanteParaBD.PONTUACAO_ID + " = ?";

        try (Connection conn = AjudanteParaBD.ConnectToDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setInt(1, time);
            pstmt.setInt(2, idPontuacao);
            pstmt.executeUpdate();
        } catch (SQLException e) 
        {
            System.out.println("AjudanteParaBD.updateGameLevelTime: " + e.getMessage());
        }
    }
    
    public static Utilizador selectUserFromUtilizador(String username, String password)
    {
        String sql = "SELECT " + UTILIZADOR_ID + "," + UTILIZADOR_NOME + " FROM " + TABELA_UTILIZADOR 
                + " WHERE " + UTILIZADOR_NOME + " = " + username + " and " 
                + UTILIZADOR_PALAVRAPASSE + " = " + password + ";";
        
        try (Connection conn = ConnectToDB())
        {
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if(!rs.next())
                return null;
            
            Utilizador u = new Utilizador(rs.getInt(UTILIZADOR_ID), rs.getString(UTILIZADOR_NOME));
            return u;
        } 
        catch (SQLException e) 
        {
            System.out.println("AjudanteParaBD.selectUserFromUtilizador: " + e.getMessage());
            return null;
        }
    }
}