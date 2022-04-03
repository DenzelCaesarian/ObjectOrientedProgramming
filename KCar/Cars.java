public class Cars {
	private int carCapacity;
	private String carName;
	private String carLicensePlate;
	
	public Cars(int carCapacity, String carName, String carLicensePlate) {
		super();
		this.carCapacity = carCapacity;
		this.carName = carName;
		this.carLicensePlate = carLicensePlate;
	}

	public int getCarCapacity() {
		return carCapacity;
	}

	public void setCarCapacity(int carCapacity) {
		this.carCapacity = carCapacity;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarLicensePlate() {
		return carLicensePlate;
	}

	public void setCarLicensePlate(String carLicensePlate) {
		this.carLicensePlate = carLicensePlate;
	}
}
