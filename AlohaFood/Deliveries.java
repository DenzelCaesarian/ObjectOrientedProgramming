public class Deliveries extends Orders{
	private String customerAddress;

	public Deliveries(int quantity, int totalPrice, String customerName, String orderID, String orderType, String menuName, String customerAddress) {
		super(quantity, totalPrice, customerName, orderID, orderType, menuName);
		this.customerAddress = customerAddress;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public void PrintOrder() {
		super.PrintOrder();
		System.out.println("Order Type: D - " + this.customerAddress);
	}
}
