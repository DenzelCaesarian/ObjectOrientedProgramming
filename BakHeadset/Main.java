import java.util.*;

public class Main {
	static String CustomerName;
	static Scanner scan = new Scanner(System.in);
	static Vector<Headsets> Headset = new Vector<Headsets>();
	static Vector<Collections> Collection = new Vector<Collections>();
	
	public static boolean isValidName(String name) {
		return name.length() >= 5 && name.length() <= 20;
	}
	
	public static void main(String[] args) {
		System.out.println("BakHeadset");
		System.out.println("==========");
		System.out.println();
		
		do {
			System.out.print("Input customer name [5...20]: ");
			CustomerName = scan.nextLine();
		} while(!isValidName(CustomerName));
		
		System.out.println();
		System.out.println("Welcome, " + CustomerName);
		System.out.println();
		System.out.println("Press enter to continue to main menu...");
		scan.nextLine();
		
		MainMenu();
	}

	public static void MainMenu() {
		int choice;
		
		do {
			System.out.println("BakHeadset");
			System.out.println("==========");
			System.out.println();
			System.out.println("Hello, " + CustomerName);
			System.out.println();
			System.out.println("Menu:");
			System.out.println("1. Add Headset");
			System.out.println("2. Update Headset");
			System.out.println("3. Buy Headset");
			System.out.println("4. View Collection");
			System.out.println("5. Exit");
			
			System.out.print(">> ");
			choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
				case 1:
					System.out.println();
					AddHeadset();
					break;
				case 2:
					System.out.println();
					UpdateHeadset();
					break;
				case 3:
					System.out.println();
					BuyHeadset();
					break;
				case 4:
					System.out.println();
					ViewCollection();
					break;
				case 5:
					return;
			}
			
			System.out.println();
		} while(choice < 1 || choice > 5);
	}
	
	public static boolean isValidHeadsetName(String headsetName) {
		return (headsetName.length() >= 5 && headsetName.length() <= 15) && (isUniqueHeadsetName(headsetName));
	}
	
	public static boolean isUniqueHeadsetName(String headsetName) {
		if (!Headset.isEmpty()) {
			for (Headsets headset: Headset) {
				if (headsetName.equalsIgnoreCase(headset.getHeadsetName())) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isValidHeadsetType(String headsetType) {
		return headsetType.equalsIgnoreCase("Headphone") || headsetType.equalsIgnoreCase("IEM") || headsetType.equalsIgnoreCase("OnEar");
	}
	
	public static String formatHeadsetType(String headsetType) {
		if (headsetType.equalsIgnoreCase("Headphone")) {
			return "Headphone";
		} else if (headsetType.equalsIgnoreCase("IEM")) {
			return "IEM";
		} else {
			return "OnEar";
		}
	}
	
	public static void AddHeadset() {
		String headsetName, headsetType;
		
		System.out.println("Add Headset");
		System.out.println("=========");
		System.out.println();
		
		do {
			System.out.print("Input headset name [5...15 | unique]: ");
			headsetName = scan.nextLine();
			
			if (!isUniqueHeadsetName(headsetName)) {
				System.out.println("'" + headsetName + "' is already added, input another name.");
			}
		} while(!isValidHeadsetName(headsetName));
		
		do {
			System.out.print("Input headset type [Headphone | IEM | OnEar]: ");
			headsetType = scan.nextLine();
		} while(!isValidHeadsetType(headsetType));
		
		headsetType = formatHeadsetType(headsetType);
		
		Headset.add(new Headsets(headsetName, headsetType));
		System.out.println();
		System.out.println("Headset successfully added!");
		
		System.out.println();
		System.out.println("Press enter to continue...");
		scan.nextLine();
		
		MainMenu();
	}
	
	public static void PrintTable() {
		int i;
		
		System.out.println("+====+==================+============+");
		System.out.println("| No | Headset Name     | Type       |");
		System.out.println("+====+==================+============+");
		
		for (i = 0; i < Headset.size(); i++) {
			System.out.println(String.format("%s %-2d %s %-16s %s %-10s %s",
					"|", i + 1, "|", Headset.get(i).getHeadsetName(), "|", Headset.get(i).getHeadsetType(), "|"));
		}
		
		System.out.println("+====+==================+============+");
	}
	
	public static boolean isValidIndex(int index) {
		return index >= 0 && index < Headset.size();
	}
	
	public static void UpdateHeadset() {
		if (Headset.isEmpty()) {
			System.out.println("Update Headset");
			System.out.println("=========");
			System.out.println();
			System.out.println("No headset added yet!");
			System.out.println();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			
			MainMenu();
		} else {
			int tobeUpdated;
			String newHeadsetName, newHeadsetType;
			
			System.out.println("Update Headset");
			System.out.println("=========");
			System.out.println();
			
			PrintTable();
			System.out.println();
			
			do {
				if (Headset.size() == 1) {
					System.out.print("Select headset [1]: ");
				} else {
					System.out.print("Select headset [1-" + Headset.size() + "]: ");
				}
				tobeUpdated = scan.nextInt();
				scan.nextLine();
			} while(!isValidIndex(tobeUpdated - 1));
			
			System.out.println();
			do {
				System.out.print("Input new headset name [5...15 | unique]: ");
				newHeadsetName = scan.nextLine();
				
				if (!isUniqueHeadsetName(newHeadsetName)) {
					System.out.println("'" + newHeadsetName + "' is already added, input another name.");
				}
			} while(!isValidHeadsetName(newHeadsetName));
			
			do {
				System.out.print("Input new headset type [Headphone | IEM | OnEar]: ");
				newHeadsetType = scan.nextLine();
			} while(!isValidHeadsetType(newHeadsetType));
			
			newHeadsetType = formatHeadsetType(newHeadsetType);
			
			Headset.get(tobeUpdated - 1).setHeadsetName(newHeadsetName);
			Headset.get(tobeUpdated - 1).setHeadsetType(newHeadsetType);
			
			System.out.println();
			System.out.println("Headset successfully updated!");
			
			System.out.println();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			
			MainMenu();
		}
	}
	
	public static boolean isValidQuantity(int quantity) {
		return quantity > 0;
	}

	public static void BuyHeadset() {
		if (Headset.isEmpty()) {
			System.out.println("Buy Headset");
			System.out.println("=========");
			System.out.println();
			System.out.println("No headset added yet!");
			System.out.println();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			
			MainMenu();
		} else {
			int toBuy, quantity, discount, headsetPrice;
			float totalPrice;
			
			System.out.println("Buy Headset");
			System.out.println("=========");
			System.out.println();
			
			PrintTable();
			
			System.out.println();
			do {
				if (Headset.size() == 1) {
					System.out.print("Select headset [1]: ");
				} else {
					System.out.print("Select headset [1-" + Headset.size() + "]: ");
				}
				toBuy = scan.nextInt();
				scan.nextLine();
			} while(!isValidIndex(toBuy - 1));
			
			System.out.println();
			do {
				System.out.print("Input quantity [min. 1]: ");
				quantity = scan.nextInt();
				scan.nextLine();
			} while(!isValidQuantity(quantity));
			
			if (Headset.get(toBuy - 1).getHeadsetType().equalsIgnoreCase("Headphone")) {
				headsetPrice = 20000;
			} else if (Headset.get(toBuy - 1).getHeadsetType().equalsIgnoreCase("IEM")) {
				headsetPrice = 25000;
			} else {
				headsetPrice = 30000;
			}

			discount = 10 + (int)(Math.random() * 15);
			totalPrice = ((float)quantity * (float)headsetPrice) * (((float)100 - (float)discount) / (float)100);
			
			System.out.println();
			System.out.println("You got " + discount + "% discount!");
			System.out.println(String.format("%s %.0f", "Total Price: ", totalPrice));
			
			Collection.add(new Collections(quantity, discount, totalPrice, Headset.get(toBuy - 1)));
			
			System.out.println();
			System.out.println("This headset has been added to your collection!");
			System.out.println();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			
			MainMenu();
		}
	}
	
	public static void PrintCollection() {
		int i;
		
		System.out.println("+====+==================+============+");
		System.out.println("| No | Headset Name     | Type       |");
		System.out.println("+====+==================+============+");
		
		for (i = 0; i < Collection.size(); i++) {
			System.out.println(String.format("%s %-2d %s %-16s %s %-10s %s",
					"|", i + 1, "|", Collection.get(i).getHeadset().getHeadsetName(), "|", Collection.get(i).getHeadset().getHeadsetType(), "|"));
		}
		
		System.out.println("+====+==================+============+");
	}

	public static void ViewCollection() {
		if (Headset.isEmpty()) {
			System.out.println("View Collection");
			System.out.println("=========");
			System.out.println();
			System.out.println("No headset added yet.");
			System.out.println();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			
			MainMenu();
		} else if (Collection.isEmpty()) {
			System.out.println("View Collection");
			System.out.println("=========");
			System.out.println();
			System.out.println("Your collection(s) are empty.");
			System.out.println();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			
			MainMenu();
		} else {
			System.out.println("View Collection");
			System.out.println("=========");
			System.out.println();
			
			System.out.println("Your Collection:");
			PrintCollection();
			
			System.out.println();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			
			MainMenu();
		}
	}
}
