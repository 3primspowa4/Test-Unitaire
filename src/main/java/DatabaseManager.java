import java.sql.*;
public class DatabaseManager {
    public static Connection connexionBDD(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="lhcp3208.webapps.net:3306";
            String user="eb4kljsw";
            String pwd="$y6w.#x@21x8";
            Connection cn= DriverManager.getConnection("jdbc:mysql://"+url+user+pwd);
            return cn;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
