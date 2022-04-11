public class Collections {
	private int quantity, discount;
	private float price;
	private Headsets Headset;
	
	public Collections(int quantity, int discount, float price, Headsets headset) {
		super();
		this.quantity = quantity;
		this.discount = discount;
		this.price = price;
		Headset = headset;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Headsets getHeadset() {
		return Headset;
	}

	public void setHeadset(Headsets headset) {
		Headset = headset;
	}
}
