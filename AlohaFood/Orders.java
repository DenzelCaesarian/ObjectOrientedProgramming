public abstract class Orders {
	protected int quantity, totalPrice;
	protected String customerName, orderID, orderType, menuName;
	
	public Orders(int quantity, int totalPrice, String customerName, String orderID, String orderType, String menuName) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.customerName = customerName;
		this.orderID = orderID;
		this.orderType = orderType;
		this.menuName = menuName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public void PrintOrder() {
		System.out.println("Order ID: " + this.orderID);
		System.out.println("Customer Name: " + this.customerName);
		System.out.println("Menu Name: " + this.menuName);
		System.out.println("Quantity: " + this.quantity);
		System.out.println("Total Price: " + this.totalPrice);
	}
}
