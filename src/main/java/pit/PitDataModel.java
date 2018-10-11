package pit;

final public class PitDataModel {
	
	private enum autoTypes {
		BASELINE, SWITCH, SCALE, NONE
	};
	
	private enum robotTypes{
		SCALE, SWITCH, VAULT
	};

	private int teamNumber;
	private String teamName;
	private String autoType;
	private String robotType;
	private int scaleClaim;
	private int switchClaim;
	private int vaultClaim;
	private String pitNotes;
	
	public PitDataModel(int teamNumber, String teamName, String autoType, String robotType, int scaleClaim, int switchClaim, int vaultClaim, String pitNotes) {
		
		setTeamNumber(teamNumber);
		setTeamName(teamName);
		setAutoType(autoType);
		setRobotType(robotType);
		setScaleClaim(scaleClaim);
		setSwitchClaim(switchClaim);
		setVaultClaim(vaultClaim);
		setPitNotes(pitNotes);
		
	}
	
	public PitDataModel() {
	}
	
	public int getTeamNumber() {
		return teamNumber;
	}
	
	public void setTeamNumber(int teamNumber) {
		if(teamNumber > 0)
			this.teamNumber = teamNumber;
		else
			throw new IllegalArgumentException();
	}
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getAutoType() {
		return autoType;
	}
	
	public void setAutoType(String autoType) {	
		for(autoTypes type : autoTypes.values()) {
			if(autoType.toUpperCase().equals(type.toString())) {
				this.autoType = autoType;
				return;
			}
		}	
		throw new IllegalArgumentException();
	}	
	
	public String getRobotType() {
		return robotType;
	}
	
	public void setRobotType(String robotType) {	
		for(robotTypes type : robotTypes.values()) {
			if(robotType.toUpperCase().equals(type.toString())) {
				this.robotType = robotType;
				return;
			}
		}	
		throw new IllegalArgumentException();
	}	
	
	public int getScaleClaim() {
		return scaleClaim;
	}
	
	public void setScaleClaim(int scaleClaim) {
		if(scaleClaim > 0)
			this.scaleClaim = scaleClaim;
		else
			throw new IllegalArgumentException();
	}
	
	public int getSwitchClaim() {
		return switchClaim;
	}
	
	public void setSwitchClaim(int switchClaim) {
		if(switchClaim > 0)
			this.switchClaim = switchClaim;
		else
			throw new IllegalArgumentException();
	}
	
	public int getVaultClaim() {
		return vaultClaim;
	}
	
	public void setVaultClaim(int vaultClaim) {
		if(vaultClaim > 0)
			this.vaultClaim = vaultClaim;
		else
			throw new IllegalArgumentException();
	}
	
	public String getPitNotes() {
		return pitNotes;
	}

	public void setPitNotes(String pitnotes) {
		this.pitNotes = pitnotes;
	}
	
}
