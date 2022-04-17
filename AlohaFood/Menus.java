public class Menus {
	private int menuPrice;
	private String menuName, menuID;
	
	public Menus(String menuName, String menuID, int menuPrice) {
		super();
		this.menuName = menuName;
		this.menuID = menuID;
		this.menuPrice = menuPrice;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
}
