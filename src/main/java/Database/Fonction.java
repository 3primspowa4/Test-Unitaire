package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Fonction {
    public static String url="jdbc:myslq://mysql-garm.alwaysdata.net:3306/garm_db";
    public static String login="garm";
    public static String mdp="tresport";
    public static Statement connexionSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, login,mdp);
            Statement st = conn.createStatement();
            return st;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
