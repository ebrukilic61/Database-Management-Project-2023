package vt.project;

/**
 *
 * @author Sevda Karahan

 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    public static Connection getConnection() throws SQLException, IOException {
        String url, user, pass;
        url = "jdbc:postgresql://localhost:5432/dbproje";
	    user = "postgres";
        pass = "12345";
        Connection conn = DriverManager.getConnection(url, user,pass);
        
        return conn;
    }
    
}
