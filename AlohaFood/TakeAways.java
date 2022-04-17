public class TakeAways extends Orders {
	private String pickerName;

	public TakeAways(int quantity, int totalPrice, String customerName, String orderID, String orderType, String menuName, String pickerName) {
		super(quantity, totalPrice, customerName, orderID, orderType, menuName);
		this.pickerName = pickerName;
	}

	public String getPickerName() {
		return pickerName;
	}

	public void setPickerName(String pickerName) {
		this.pickerName = pickerName;
	}
	
	public void PrintOrder() {
		super.PrintOrder();
		System.out.println("Order Type: T - " + this.pickerName);
	}
}
