package frc.team1250;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    // Database URL
    private static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/frc";

    //  Database credentials
    private static final String USER = "maria";
    private static final String PASS = "FRC1250";
    
    private static Connection conn;
        
    public static Connection GetConnection() {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return conn;
    }
}