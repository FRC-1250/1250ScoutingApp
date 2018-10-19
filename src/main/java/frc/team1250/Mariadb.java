package frc.team1250;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import java.sql.ResultSet;

public class Mariadb {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/frc";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
        
    public static Connection GetConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	return conn;
    }
    
    private static void CloseConnection(Connection conn) {
		try {
			conn.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void CloseStatement(Statement stmt) {
		try {
			stmt.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void CloseResultSet(ResultSet rs) {
		try {
			rs.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static CachedRowSet Query(String sqlQuery) {
		Connection queryConnection = null;
		Statement queryStatement = null;
		ResultSet queryResults = null;
		CachedRowSet cache = null;
		
		try {
			queryConnection = GetConnection();
			queryStatement = queryConnection.createStatement();
			queryResults = queryStatement.executeQuery(sqlQuery);
			cache = RowSetProvider.newFactory().createCachedRowSet();
			cache.populate(queryResults);
			return cache;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			CloseConnection(queryConnection);
			CloseStatement(queryStatement);
			CloseResultSet(queryResults);
		}
		return cache;
	}
	
	public static int Update(String sqlQuery) {
		int effectedRows = 0;
		Connection updateConnection = null;
		Statement updateStatement = null;
		
		try {
			updateConnection = GetConnection();
			updateStatement = updateConnection.createStatement();
			effectedRows = updateStatement.executeUpdate(sqlQuery);
			return effectedRows;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			CloseConnection(updateConnection);
			CloseStatement(updateStatement);
		}
		return effectedRows;
	}
}