import java.util.*;

public class Main {
	static int totalOrder;
	static String name;
	static Scanner scan = new Scanner(System.in);
	static Vector<Menus> Menu = new Vector<Menus>();
	static Vector<Orders> Order = new Vector<Orders>();
	
	public static void main(String[] args) {
		MainMenu();
	}
	
	public static boolean isValidName(String name) {
		return name.length() > 0;
	}
	
	public static boolean isValidPhoneNumber(String phoneNumber) {
		int i;
		
		if (phoneNumber.length() == 0) {
			return false;
		}
		
		for (i = 0; i < phoneNumber.length(); i++) {
			if (phoneNumber.charAt(i) < 48 || phoneNumber.charAt(i) > 57) {
				return false;
			}
		}
		return true;
	}
	
	public static void MainMenu() {
		int loop;
		boolean isAdmin;
		String phoneNumber;
		
		System.out.println("AlohaFood");
		System.out.println("=========");
		System.out.println();
		
		loop = 0;
		isAdmin = false;
		do {
			if (loop > 0) {
				System.out.println("Penulisan nama invalid!");
			}
			
			System.out.print("Masukkan Nama [Ketik X untuk keluar]: ");
			name = scan.nextLine();
			
			if (name.equalsIgnoreCase("Admin")) {
				isAdmin = true;
			}
			
			if (name.equalsIgnoreCase("X")) {
				System.out.println();
				System.out.println("Terima Kasih sudah menggunakan aplikasi AlohaFood");
				System.out.print("Tekan ENTER untuk melanjutkan ...");
				scan.nextLine();
				return;
			}
			
			loop++;
		} while(!isValidName(name));
		
		loop = 0;
		do {
			if (loop > 0) {
				System.out.println("Penulisan nomor telepon invalid!");
			}
			
			System.out.print("Masukkan Nomor Telepon: ");
			phoneNumber = scan.nextLine();
			
			loop++;
		} while(!isValidPhoneNumber(phoneNumber));
		
		if (isAdmin) {
			System.out.println();
			AdminMenu();
		} else {
			System.out.println();
			CustomerMenu();
		}
	}
	
	public static void AdminMenu() {
		System.out.println("AlohaFood (Admin Menu)");
		System.out.println("======================");
		System.out.println();
		
		int choice;
		do {
			System.out.println("1. Add Menu");
			System.out.println("2. Show Order List");
			System.out.println("3. Exit");
			System.out.print(">> ");
			
			choice = scan.nextInt();
			scan.nextLine();
			
			switch (choice) {
				case 1:
					System.out.println();
					AddMenu();
					break;
				case 2:
					System.out.println();
					ShowOrderList();
					break;
				case 3:
					System.out.println();
					MainMenu();
					break;
			}
		} while(choice < 1 || choice > 3);
	}
	
	public static boolean isValidMenuName(String menuName) {
		return menuName.length() >= 5 && menuName.length() <= 20;
	}
	
	public static boolean isValidMenuPrice(String menuPrice) {
		int i;
		
		if (menuPrice.length() == 0) {
			return false;
		}
		
		for (i = 0; i < menuPrice.length(); i++) {
			if (menuPrice.charAt(i) < 48 || menuPrice.charAt(i) > 57) {
				return false;
			}
		}
		return true;
	}
	
	public static void AddMenu() {
		int i, loop, tempID;
		String menuID, menuPrice, menuName;
		
		System.out.println("Add Menu");
		System.out.println("========");
		System.out.println();
		
		loop = 0;
		do {
			if (loop > 0) {
				System.out.println("Penulisan nama menu invalid!");
			}
			
			System.out.print("Masukkan Nama Menu: ");
			menuName = scan.nextLine();
			
			loop++;
		} while(!isValidMenuName(menuName));
		
		loop = 0;
		do {
			if (loop > 0) {
				System.out.println("Penulisan harga wajib dalam format angka!");
			}
			
			System.out.print("Masukkan Harga Menu: ");
			menuPrice = scan.nextLine();
			
			loop++;
		} while(!isValidMenuPrice(menuPrice));
		
		menuID = "";
		for (i = 0; i < 10; i++) {
			tempID = (int)(Math.random() * 10);
			menuID = menuID + tempID;
		}
		
		Menu.add(new Menus(menuName, menuID, Integer.parseInt(menuPrice)));
		System.out.println();
		
		System.out.println("Menu berhasil ditambahkan.");
		System.out.print("Tekan ENTER untuk melanjutkan ...");
		scan.nextLine();
		
		System.out.println();
		AdminMenu();
	}
	
	public static void PrintList() {
		int i;
		
		for (i = 0; i < Order.size(); i++) {
			Order.get(i).PrintOrder();
			System.out.println("----------------------------------------------------");
		}
	}
	
	public static void ShowOrderList() {
		System.out.println("Order List");
		System.out.println("==========");
		System.out.println();
		
		if (Order.isEmpty()) {
			System.out.println("Tidak ada Order");
			System.out.print("Tekan ENTER untuk melanjutkan ...");
			scan.nextLine();
			
			System.out.println();
			AdminMenu();
		} else {
			PrintList();
			
			System.out.print("Tekan ENTER untuk melanjutkan ...");
			scan.nextLine();
			
			System.out.println();
			AdminMenu();
		}
	}
	
	public static void PrintMenu() {
		int i;
		
		System.out.println("==================================================");
		System.out.println("| Menu ID    | Menu Name            | Menu Price |");
		System.out.println("==================================================");
		for (i = 0; i < Menu.size(); i++) {
			System.out.println(String.format("%s %-10s %s %-20s %s %-10d %s", 
					"|", Menu.get(i).getMenuID(), 
					"|", Menu.get(i).getMenuName(),
					"|", Menu.get(i).getMenuPrice(), "|"));
		}
		System.out.println("==================================================");
	}
	
	public static boolean isValidMenuID(String menuID) {
		int i;
		
		for (i = 0; i < Menu.size(); i++) {
			if (Menu.get(i).getMenuID().equals(menuID)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isValidOrderType(String orderType) {
		return orderType.equalsIgnoreCase("Delivery") || orderType.equalsIgnoreCase("Take Away");
	}
	
	public static int menuIndex(String menuID) {
		int i;
		
		for (i = 0; i < Menu.size(); i++) {
			if (Menu.get(i).getMenuID().equals(menuID)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void CustomerMenu() {
		System.out.println("AlohaFood (Customer Menu)");
		System.out.println("=========================");
		System.out.println();
		
		if (Menu.isEmpty()) {
			System.out.println("Tidak ada Data");
			System.out.print("Tekan ENTER untuk melanjutkan ...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		} else {
			int loop, quantity, totalPrice;
			String menuID, orderType, orderID, customerAddress, pickerName;
			
			PrintMenu();
			
			System.out.println();
			
			loop = 0;
			do {
				if (loop > 0) {
					System.out.println("Penulisan menu ID invalid!");
				}
				
				System.out.print("Masukkan Menu ID [Ketik X untuk kembali ke Menu Awal]: ");
				menuID = scan.nextLine();
				
				if (menuID.equalsIgnoreCase("X")) {
					System.out.println();
					MainMenu();
				}
				
				loop++;
			} while(!isValidMenuID(menuID));
			
			loop = 0;
			do {
				if (loop > 0) {
					System.out.println("Kuantitas wajib diisi!");
				}
				
				System.out.print("Masukkan Kuantitas: ");
				quantity = scan.nextInt();
				scan.nextLine();
				
				loop++;
			} while(quantity <= 0);
			
			loop = 0;
			do {
				if (loop > 0) {
					System.out.println("Penulisan tipe order invalid!");
				}
				
				System.out.print("Masukkan Tipe Order [ Delivery | Take Away ]: ");
				orderType = scan.nextLine();
				
				loop++;
			} while(!isValidOrderType(orderType));
			
			pickerName = "";
			customerAddress = "";
			if (orderType.equalsIgnoreCase("Delivery")) {
				System.out.print("Masukkan Alamat: ");
				customerAddress = scan.nextLine();
			} else {
				do {
					System.out.print("Masukkan Nama Pengambil: ");
					pickerName = scan.nextLine();
				} while(pickerName.length() < 5 || pickerName.length() > 20);
			}
			System.out.println();
			
			if (totalOrder == 0) {
				orderID = "OR001";
			} else if (totalOrder < 9) {
				orderID = "OR00" + (totalOrder + 1);
			} else if (totalOrder < 99) {
				orderID = "OR0" + (totalOrder + 1);
			} else {
				orderID = "OR" + (totalOrder + 1);
			}
			
			totalOrder++;
			totalPrice = (int)Menu.get(menuIndex(menuID)).getMenuPrice() * quantity;
			
			System.out.println("Order ID: " + orderID);
			System.out.println("Total Price: " + totalPrice);
			System.out.println();
			
			if (orderType.equalsIgnoreCase("Delivery")) {
				Deliveries Delivery = new Deliveries(quantity, totalPrice, name, orderID, orderType, Menu.get(menuIndex(menuID)).getMenuName(), customerAddress);
				Order.add(Delivery);
			} else {
				TakeAways TakeAway = new TakeAways(quantity, totalPrice, name, orderID, orderType, Menu.get(menuIndex(menuID)).getMenuName(), pickerName);
				Order.add(TakeAway);
			}
			
			System.out.println("Order berhasil ditambahkan.");
			System.out.print("Tekan ENTER untuk melanjutkan ...");
			scan.nextLine();
			
			System.out.println();
			CustomerMenu();
		}
	}
}
