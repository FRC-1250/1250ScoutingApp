package match;

final public class MatchDataModel {

	private enum autoPositions {
		LEFT, CENTER, RIGHT
	};
	
	private enum autoTypes {
		BASELINE, SWITCH, SCALE
	};
	
	private enum endGameOptions {
		CLIMB, PARK, NONE
	};
	
	private int matchNumber;
	private int teamNumber;
	private String autoPosition;
	private String autoType;
	private boolean autoSuccess;
	private boolean placeSwitch;
	private boolean placeScale;
	private boolean placeVault;
	private int scoreScale;
	private int scoreSwitch;
	private int scoreVault;
	private String endGameAction;
	private String matchNotes;
	
	public MatchDataModel(int matchNumber, int teamNumber, String autoPosition, String autoType, boolean autoSuccess,
			boolean placeSwitch, boolean placeScale, boolean placePort, int scoreScale, int scoreSwitch, int scoreVault, String endGameAction, String notes) {
		setMatchNumber(matchNumber);
		setTeamNumber(teamNumber);
		setAutoPosition(autoPosition);
		setAutoType(autoType);
		setAutoSuccess(autoSuccess);
		setPlaceSwitch(placeSwitch);
		setPlaceScale(placeScale);
		setPlaceVault(placePort);
		setScoreScale(scoreScale);
		setScoreSwitch(scoreSwitch);
		setScoreVault(scoreVault);
		setEndGameAction(endGameAction);
		setMatchNotes(notes);
	}
	
	public MatchDataModel() {
	}

	public int getMatchNumber() {
		return matchNumber;
	}
	
	public void setMatchNumber(int matchNumber) {
		if(matchNumber > 0)
			this.matchNumber = matchNumber;
		else
			throw new IllegalArgumentException(); 
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
	
	public String getAutoPosition() {
		return autoPosition;
	}
	
	public void setAutoPosition(String autoPosition) {	
		for(autoPositions pos : autoPositions.values()) {
			if(autoPosition.toUpperCase().equals(pos.toString())) {
				this.autoPosition = autoPosition;
				return;
			}
		}	
		throw new IllegalArgumentException();
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
	
	
	public boolean isAutoSuccess() {
		return autoSuccess;
	}
	
	public void setAutoSuccess(boolean autoSuccess) {
		this.autoSuccess = autoSuccess;
	}
	
	public boolean isPlaceSwitch() {
		return placeSwitch;
	}
	
	public void setPlaceSwitch(boolean placeSwitch) {
		this.placeSwitch = placeSwitch;
	}
	
	public boolean isPlaceScale() {
		return placeScale;
	}
	
	public void setPlaceScale(boolean placeScale) {
		this.placeScale = placeScale;
	}
	
	public boolean isPlaceVault() {
		return placeVault;
	}
	
	public void setPlaceVault(boolean placePort) {
		this.placeVault = placePort;
	}

	public int getScoreScale() {
		return scoreScale;
	}
	
	public void setScoreScale(int scoreScale) {
		if(scoreScale >= 0)
			this.scoreScale = scoreScale;
		else
			throw new IllegalArgumentException();
	}

	public int getScoreSwitch() {
		return scoreSwitch;
	}
	
	public void setScoreSwitch(int scoreSwitch) {
		if(scoreSwitch >= 0)
			this.scoreSwitch = scoreSwitch;
		else
			throw new IllegalArgumentException();
	}
	
	public int getScoreVault() {
		return scoreVault;
	}
	
	public void setScoreVault(int scoreVault) {
		if(scoreVault >= 0)
			this.scoreVault = scoreVault;
		else
			throw new IllegalArgumentException();
	}

	
	public String getEndGameAction() {
		return endGameAction;
	}
	
	public void setEndGameAction(String endGameOption) {	
		for(endGameOptions opt : endGameOptions.values()) {
			if(endGameOption.toUpperCase().equals(opt.toString())) {
				this.endGameAction = endGameOption;
				return;
			}
		}
		throw new IllegalArgumentException();
	}

	public String getMatchNotes() {
		return matchNotes;
	}

	public void setMatchNotes(String notes) {
		this.matchNotes = notes;
	}
}















