package pit;

final public class PitDataModel {

	private int teamNumber;
	private String teamName;
	private int scaleClaim;
	private int switchClaim;
	private int vaultClaim;
	private String pitNotes;
	private boolean autoBase;
	private boolean autoSwitch;
	private boolean autoScale;
	private boolean typeScale;
	private boolean typeSwitch;
	private boolean typeVault;

	public PitDataModel(int teamNumber, String teamName, int scaleClaim, int switchClaim, int vaultClaim,
			String pitNotes, boolean autoBase, boolean autoScale, boolean autoSwitch, boolean typeScale,
			boolean typeSwitch, boolean typeVault) {

		setTeamNumber(teamNumber);
		setTeamName(teamName);
		setScaleClaim(scaleClaim);
		setSwitchClaim(switchClaim);
		setVaultClaim(vaultClaim);
		setPitNotes(pitNotes);
		setAutoBase(autoBase);
		setAutoSwitch(autoSwitch);
		setAutoScale(autoScale);
		setTypeScale(typeScale);
		setTypeSwitch(typeSwitch);
		setTypeVault(typeVault);
	}

	public PitDataModel() {
		setTeamNumber(1);
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		if (teamNumber > 0)
			this.teamNumber = teamNumber;
		else
			throw new IllegalArgumentException();
	}

	public boolean isAutoBase() {
		return autoBase;
	}

	public void setAutoBase(boolean autoBase) {
		this.autoBase = autoBase;
	}

	public boolean isAutoScale() {
		return autoScale;
	}

	public void setAutoScale(boolean autoScale) {
		this.autoScale = autoScale;
	}

	public boolean isAutoSwitch() {
		return autoSwitch;
	}

	public void setAutoSwitch(boolean autoSwitch) {
		this.autoSwitch = autoSwitch;
	}

	public boolean isTypeScale() {
		return typeScale;
	}

	public void setTypeScale(boolean typeScale) {
		this.typeScale = typeScale;
	}

	public boolean isTypeSwitch() {
		return typeSwitch;
	}

	public void setTypeSwitch(boolean typeSwitch) {
		this.typeSwitch = typeSwitch;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public boolean isTypeVault() {
		return typeVault;
	}

	public void setTypeVault(boolean typeVault) {
		this.typeVault = typeVault;
	}

	public int getScaleClaim() {
		return scaleClaim;
	}

	public void setScaleClaim(int scaleClaim) {
		if (scaleClaim >= 0)
			this.scaleClaim = scaleClaim;
		else
			throw new IllegalArgumentException();
	}

	public int getSwitchClaim() {
		return switchClaim;
	}

	public void setSwitchClaim(int switchClaim) {
		if (switchClaim >= 0)
			this.switchClaim = switchClaim;
		else
			throw new IllegalArgumentException();
	}

	public int getVaultClaim() {
		return vaultClaim;
	}

	public void setVaultClaim(int vaultClaim) {
		if (vaultClaim >= 0)
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
