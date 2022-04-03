public class Drivers {
	private String driverName;
	private boolean driverIsFree;
	private final Cars Car;
	private Clients Client;
	
	public Drivers(String driverName, boolean driverIsFree, Cars car, Clients client) {
		super();
		this.driverName = driverName;
		this.driverIsFree = driverIsFree;
		Car = car;
		Client = client;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public boolean isDriverIsFree() {
		return driverIsFree;
	}

	public void setDriverIsFree(boolean driverIsFree) {
		this.driverIsFree = driverIsFree;
	}

	public Clients getClient() {
		return Client;
	}

	public void setClient(Clients client) {
		Client = client;
	}

	public Cars getCar() {
		return Car;
	}
}
