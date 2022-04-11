public class Headsets {
	private String headsetName, headsetType;
	
	public Headsets(String headsetName, String headsetType) {
		super();
		this.headsetName = headsetName;
		this.headsetType = headsetType;
	}

	public String getHeadsetName() {
		return headsetName;
	}

	public void setHeadsetName(String headsetName) {
		this.headsetName = headsetName;
	}

	public String getHeadsetType() {
		return headsetType;
	}

	public void setHeadsetType(String headsetType) {
		this.headsetType = headsetType;
	}
}
