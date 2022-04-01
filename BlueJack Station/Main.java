import java.util.*;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Vector<Routes> Route = new Vector<Routes>();
	
	public static void main(String[] args) {
		MainMenu();
	}
	
	public static void MainMenu() {
		int choice;
		
		do {
			System.out.println("BlueJack Station");
			System.out.println("================");
			System.out.println("1. Insert route");
			System.out.println("2. View routes");
			System.out.println("3. Update route");
			System.out.println("4. Exit");
			System.out.print(">> ");
			
			choice = scan.nextInt();
			scan.nextLine();
			
			switch (choice) {
				case 1:
					System.out.println();
					InsertRoute();
					break;
				case 2:
					System.out.println();
					ViewRoute();
					break;
				case 3:
					System.out.println();
					UpdateRoute();
					break;
				case 4:
					return;
			}
			
		} while(choice < 1 || choice > 4);
	}
	
	public static boolean isValidDestination(String destination) {
		return (destination.equals("Jakarta") ||
				destination.equals("Bogor") ||
				destination.equals("Depok") ||
				destination.equals("Tangerang") ||
				destination.equals("Bekasi"));
	}
	
	public static boolean isValidDistance(int distance) {
		return (distance >= 1 && distance <= 1000);
	}
	
	public static void InsertRoute() {
		String routeID;
		String destination;
		int distance;
		int price;
		int tempID;
		
		do {
			System.out.print("Input route destination [Jakarta | Bogor | Depok | Tangerang | Bekasi] (case sensitive): ");
			destination = scan.nextLine();
		} while(!isValidDestination(destination));
		
		do {
			System.out.print("Input route distance [1...1000]: ");
			distance = scan.nextInt();
			scan.nextLine();
		} while(!isValidDistance(distance));
		
		tempID = 100 + (int)(Math.random() * 900);
		routeID = "BJ" + tempID;
		
		price = (distance / 2 * 1000) + 10000;
		
		Route.add(new Routes(routeID, destination, distance, price));
		
		System.out.println("Successfully added new route!");
		System.out.print("Press Enter to continue...");
		scan.nextLine();
		
		System.out.println();
		MainMenu();
	}
	
	public static void PrintRoute() {
		int i;
		
		System.out.println("=======================================================");
		System.out.println("|  ID   |   To               | Distance |    Price    |");
		System.out.println("=======================================================");
		
		for (i = 0; i < Route.size(); i++) {
			System.out.println(String.format("%s %-3s %s %-18s %s %-8d %s %-11d %s", 
					"|", Route.get(i).getRouteID(), 
					"|", Route.get(i).getDestination(), 
					"|", Route.get(i).getDistance(), 
					"|", Route.get(i).getPrice(), "|"));
		}
		
		System.out.println("=======================================================");
	}
	
	public static void ViewRoute() {
		if (Route.isEmpty()) {
			System.out.println("There are no routes available.");
			System.out.print("Press Enter to continue...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		} else {
			PrintRoute();
			
			System.out.print("Press Enter to continue...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		}
	}
	
	static int index = -1;
	public static boolean isValidID(String toUpdateID) {
		int i;
		
		for (i = 0; i < Route.size(); i++) {
			if (toUpdateID.equals(Route.get(i).getRouteID())) {
				index = i;
				return true;
			}
		}
		return false;
	}

	public static void UpdateRoute() {
		if (Route.isEmpty()) {
			System.out.println("There are no routes available.");
			System.out.print("Press Enter to continue...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		} else {
			String toUpdateID;
			String newDestination;
			int newDistance;
			int newPrice;
			
			PrintRoute();
			System.out.print("Input Route ID to update: ");
			toUpdateID = scan.nextLine();
			
			if (!isValidID(toUpdateID)) {
				System.out.println("Route ID is invalid!");
				System.out.print("Press Enter to continue...");
				scan.nextLine();
				
				System.out.println();
				MainMenu();
			} else {
				do {
					System.out.print("Input new destination [Jakarta | Bogor | Depok | Tangerang | Bekasi] (case sensitive): ");
					newDestination = scan.nextLine();
				} while(!isValidDestination(newDestination));
				
				do {
					System.out.print("Input route distance [1...1000]: ");
					newDistance = scan.nextInt();
					scan.nextLine();
				} while(!isValidDistance(newDistance));
				
				newPrice = (newDistance / 2 * 1000) + 10000;
				
				Route.get(index).setDestination(newDestination);
				Route.get(index).setDistance(newDistance);
				Route.get(index).setPrice(newPrice);
				
				System.out.println("Successfully updated Route " + toUpdateID);
				System.out.print("Press Enter to continue...");
				scan.nextLine();
				
				System.out.println();
				MainMenu();
			}
		}
	}
}
