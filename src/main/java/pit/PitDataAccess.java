package pit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import frc.team1250.DatabaseHelper;

public class PitDataAccess {

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;

	public PitDataModel getTeam(int teamNumber) {
		String sql = "Select * FROM `pit` WHERE teamNumber=?";
		conn = DatabaseHelper.GetConnection();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, teamNumber);
			rs = stmt.executeQuery();
			rs.last();
			PitDataModel pit = new PitDataModel(rs.getInt("teamNumber"), rs.getString("teamName"),
					rs.getInt("scaleClaim"), rs.getInt("switchClaim"), rs.getInt("vaultClaim"),
					rs.getString("pitNotes"), rs.getBoolean("autoBase"), rs.getBoolean("autoSwitch"),
					rs.getBoolean("autoscale"), rs.getBoolean("typeScale"), rs.getBoolean("typeSwitch"),
					rs.getBoolean("typeVault"));
			return pit;
		} catch (SQLException e) {
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
		return null;
	}

	public int deleteTeam(int teamNumber) {
		String sql = "DELETE FROM `pit` where id=?";
		conn = DatabaseHelper.GetConnection();
		int numberOfRowsEffected = 0;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, teamNumber);
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

	public int insertTeam(PitDataModel pit) {
		String sql = "INSERT INTO pit (teamNumber, teamName, scaleClaim, switchClaim, "
				+ "vaultClaim, pitNotes, autoBase, autoSwitch, autoScale, typeScale, " + "typeSwitch, typeVault) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		conn = DatabaseHelper.GetConnection();
		int numberOfRowsEffected = 0;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pit.getTeamNumber());
			stmt.setString(2, pit.getTeamName());
			stmt.setInt(3, pit.getScaleClaim());
			stmt.setInt(4, pit.getSwitchClaim());
			stmt.setInt(5, pit.getVaultClaim());
			stmt.setString(6, pit.getPitNotes());
			stmt.setBoolean(7, pit.isAutoBase());
			stmt.setBoolean(8, pit.isAutoSwitch());
			stmt.setBoolean(9, pit.isAutoScale());
			stmt.setBoolean(10, pit.isTypeScale());
			stmt.setBoolean(11, pit.isTypeSwitch());
			stmt.setBoolean(12, pit.isTypeVault());
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
