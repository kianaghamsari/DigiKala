package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection connect(){
        String url = "jdbc:postgresql://localhost/DigiKala";
        Connection conn = null;
        try {
            String user = "postgres";
            String password = "123456";
        
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }
}
