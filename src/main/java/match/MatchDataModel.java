package match;

final public class MatchDataModel {

	private enum autoPositions {
		LEFT, CENTER, RIGHT
	};
	
	private enum endGameOptions {
		CLIMB, PARK
	};
	
	private int matchNumber;
	private int teamNumber;
	private String autoPosition;
	private boolean autoSuccess;
	private boolean placeSwitch;
	private boolean placeScale;
	private boolean placePort;
	private String endGameAction;
	private String notes;
	
	public MatchDataModel(int matchNumber, int teamNumber, String autoPosition, boolean autoSuccess,
			boolean placeSwitch, boolean placeScale, boolean placePort, String endGameAction, String notes) {
		super();
		setMatchNumber(matchNumber);
		setTeamNumber(teamNumber);
		setAutoPosition(autoPosition);
		setAutoSuccess(autoSuccess);
		setPlaceSwitch(placeSwitch);
		setPlaceScale(placeScale);
		setPlacePort(placePort);
		setEndGameAction(endGameAction);
		setNotes(notes);
	}
	
	int getMatchNumber() {
		return matchNumber;
	}
	
	void setMatchNumber(int matchNumber) {
		if(matchNumber > 0)
			this.matchNumber = matchNumber;
		else
			throw new IllegalArgumentException(); 
	}
	
	int getTeamNumber() {
		return teamNumber;
	}
	
	void setTeamNumber(int teamNumber) {
		if(teamNumber > 0)
			this.teamNumber = teamNumber;
		else
			throw new IllegalArgumentException();
	}
	
	String getAutoPosition() {
		return autoPosition;
	}
	
	void setAutoPosition(String autoPosition) {	
		for(autoPositions pos : autoPositions.values()) {
			if(autoPosition.toUpperCase() == pos.toString())
				this.autoPosition = autoPosition;
			else
				throw new IllegalArgumentException();
		}
	}
	
	boolean isAutoSuccess() {
		return autoSuccess;
	}
	
	void setAutoSuccess(boolean autoSuccess) {
		this.autoSuccess = autoSuccess;
	}
	
	boolean isPlaceSwitch() {
		return placeSwitch;
	}
	
	void setPlaceSwitch(boolean placeSwitch) {
		this.placeSwitch = placeSwitch;
	}
	
	boolean isPlaceScale() {
		return placeScale;
	}
	
	void setPlaceScale(boolean placeScale) {
		this.placeScale = placeScale;
	}
	
	boolean isPlacePort() {
		return placePort;
	}
	
	void setPlacePort(boolean placePort) {
		this.placePort = placePort;
	}
	
	String getEndGameAction() {
		return endGameAction;
	}
	
	void setEndGameAction(String endGameOption) {	
		for(endGameOptions opt : endGameOptions.values()) {
			if(endGameOption.toUpperCase() == opt.toString())
				this.autoPosition = endGameOption;
			else
				throw new IllegalArgumentException();
		}
	}

	String getNotes() {
		return notes;
	}

	void setNotes(String notes) {
		this.notes = notes;
	}
}
