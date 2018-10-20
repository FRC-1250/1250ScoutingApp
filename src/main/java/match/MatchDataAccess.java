package match;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import frc.team1250.DatabaseHelper;

public class MatchDataAccess {
	
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	
	public MatchDataModel getMatch(int matchNumber) {		
    	String sql = "Select * FROM `match` WHERE matchNumber=?";	
		conn = DatabaseHelper.GetConnection();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, matchNumber);
			rs = stmt.executeQuery();
			rs.last();
			MatchDataModel match = new MatchDataModel(rs.getInt("matchNumber"), rs.getInt("teamNumber"), rs.getString("autoPosition"),rs.getString("autoType"), 
					rs.getBoolean("autoSuccess"), rs.getBoolean("placeSwitch"), rs.getBoolean("placeScale"), rs.getBoolean("placeVault"), 
					rs.getInt("scoreScale"), rs.getInt("scoreSwitch"), rs.getInt("scoreVault"), rs.getString("endGameAction"), rs.getString("notes"));
			return match;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ArrayList<MatchDataModel> getAllMatch() {		
    	String sql = "Select * FROM `match`";
		conn = DatabaseHelper.GetConnection();
    	ArrayList<MatchDataModel> matchList = new ArrayList<MatchDataModel>();

		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {	
				MatchDataModel match = new MatchDataModel(rs.getInt("matchNumber"), rs.getInt("teamNumber"), rs.getString("autoPosition"),rs.getString("autoType"), 
						rs.getBoolean("autoSuccess"), rs.getBoolean("placeSwitch"), rs.getBoolean("placeScale"), rs.getBoolean("placePort"), 
						rs.getInt("scoreScale"), rs.getInt("scoreSwitch"), rs.getInt("scoreVault"), rs.getString("endGameAction"), rs.getString("notes"));
				matchList.add(match);
			}
			return matchList;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int deleteMatch(int matchNumber) {
		String sql = "DELETE FROM `match` where id=?";
		conn = DatabaseHelper.GetConnection();
		int numberOfRowsEffected = 0;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, matchNumber);
			numberOfRowsEffected = stmt.executeUpdate();
			return numberOfRowsEffected;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return numberOfRowsEffected;
	}
	
	public int insertMatch(MatchDataModel match) {
		String sql= "INSERT INTO `match` "
    			+ "(matchNumber, teamNumber, autoPosition, autoType, autoSuccess, placeSwitch, "
    			+ "placeScale, placeVault, scoreScale, scoreSwitch, scoreVault, endGameAction, "
    			+ "notes) "
    			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		conn = DatabaseHelper.GetConnection();
		int numberOfRowsEffected = 0;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, match.getMatchNumber());
			stmt.setInt(2, match.getTeamNumber());
			stmt.setString(3, match.getAutoPosition());
			stmt.setString(4, match.getAutoType());
			stmt.setBoolean(5, match.isAutoSuccess());
			stmt.setBoolean(6, match.isPlaceSwitch());
			stmt.setBoolean(7, match.isPlaceScale());
			stmt.setBoolean(8, match.isPlaceVault());
			stmt.setInt(9, match.getScoreScale());
			stmt.setInt(10, match.getScoreSwitch());
			stmt.setInt(11, match.getScoreVault());
			stmt.setString(12, match.getEndGameAction());
			stmt.setString(13, match.getMatchNotes());
			numberOfRowsEffected = stmt.executeUpdate();
			return numberOfRowsEffected;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return numberOfRowsEffected;
	}
}
