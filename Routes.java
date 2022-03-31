public class Routes {
	private String routeID;
	private String destination;
	private int distance;
	private int price;
	
	public Routes(String routeID, String destination, int distance, int price) {
		super();
		this.routeID = routeID;
		this.destination = destination;
		this.distance = distance;
		this.price = price;
	}
	
	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
