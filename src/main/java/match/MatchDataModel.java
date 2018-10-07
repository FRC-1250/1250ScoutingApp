package match;

final public class MatchDataModel {

	private enum autoPositions {
		LEFT, CENTER, RIGHT
	};
	
	private enum endGameOptions {
		CLIMB, PARK, NONE
	};
	
	private int matchNumber;
	private int teamNumber;
	private String autoPosition;
	private boolean autoSuccess;
	private boolean placeSwitch;
	private boolean placeScale;
	private boolean placePort;
	private String endGameAction;
	private String matchNotes;
	
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
		setMatchNotes(notes);
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
	
	public boolean isPlacePort() {
		return placePort;
	}
	
	public void setPlacePort(boolean placePort) {
		this.placePort = placePort;
	}
	
	String getEndGameAction() {
		return endGameAction;
	}
	
	public void setEndGameAction(String endGameOption) {	
		for(endGameOptions opt : endGameOptions.values()) {
			if(endGameOption.toUpperCase().equals(opt.toString())) {
				this.autoPosition = endGameOption;
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
