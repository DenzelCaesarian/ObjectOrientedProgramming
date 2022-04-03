import java.util.*;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Vector<Drivers> Driver = new Vector<>();
	
	public static void main(String[] args) {
		MainMenu();
	}
	
	public static void MainMenu() {
		int choice;
		
		do {
			System.out.println("888    d8P   .d8888b.");
			System.out.println("888   d8P   d88P  Y88b");
			System.out.println("888  d8P    888    888");
			System.out.println("888d88K     888         8888b.  888d888");
			System.out.println("8888888b    888            \"88b 888P\"");
			System.out.println("888  Y88b   888    888 .d888888 888");
			System.out.println("888   Y88b  Y88b  d88P 888  888 888");
			System.out.println("888    Y88b  \"Y8888P\"  \"Y888888 888");
			System.out.println("=========================");
			System.out.println("1. View All Driver");
			System.out.println("2. Add New Driver");
			System.out.println("3. Delete A Driver");
			System.out.println("4. Assign Passenger to Driver");
			System.out.println("5. Exit");
			System.out.print(">> ");
			
			choice = scan.nextInt();
			scan.nextLine();
			
			switch (choice) {
				case 1:
					System.out.println();
					ViewDriver();
					break;
				case 2:
					System.out.println();
					AddDriver();
					break;
				case 3:
					System.out.println();
					DeleteDriver();
					break;
				case 4:
					System.out.println();
					AssignPassenger();
					break;
				case 5:
					return;
			}
			
			System.out.println();
		} while(choice < 1 || choice > 5);
	}
	
	public static void PrintData() {
		int i;
		
		for (i = 0; i < Driver.size(); i++) {
			System.out.println(String.format("%-30s %s %s", "Driver Name", ":", Driver.get(i).getDriverName()));
			System.out.println(String.format("%-30s %s %s", "Car", ":", Driver.get(i).getCar().getCarName()));
			System.out.println(String.format("%-30s %s %s", "License Plate", ":", Driver.get(i).getCar().getCarLicensePlate()));
			
			if (Driver.get(i).isDriverIsFree()) {
				System.out.println(String.format("%-30s %s %s", 
						"Driver Status", ":", Driver.get(i).getDriverName() + " is currently free. Any client can use this driver."));
			} else {
				System.out.println(String.format("%-30s %s %s", 
						"Driver Status", ":", Driver.get(i).getDriverName() + " is driving " +
						Driver.get(i).getClient().getClientName() + " to the destination."));
			}
			
			System.out.println("================================================================");
		}
	}
	
	public static void ViewDriver() {
		if (Driver.isEmpty()) {
			System.out.println("KCar Drivers");
			System.out.println("=============================================");
			System.out.println();
			System.out.println("No driver available.");
			System.out.println();
			System.out.print("Press Enter to Continue...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		} else {
			System.out.println("KCar Drivers");
			System.out.println("=============================================");
			System.out.println();
			
			PrintData();
			
			System.out.println();
			System.out.print("Press Enter to Continue...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		}
	}
	
	public static boolean isValidName(String name) {
		return name.length() >= 5 && name.length() <= 25;
	}
	
	public static boolean isValidCar(String car) {
		return car.length() >= 1;
	}
	
	public static boolean isValidLicensePlate(String licensePlate) {
		return (licensePlate.charAt(0) >= 65 && licensePlate.charAt(0) <= 90) &&
				(licensePlate.charAt(1) == ' ' && licensePlate.charAt(6) == ' ') &&
				(licensePlate.charAt(2) >= 48 && licensePlate.charAt(2) <= 57) &&
				(licensePlate.charAt(3) >= 48 && licensePlate.charAt(3) <= 57) &&
				(licensePlate.charAt(4) >= 48 && licensePlate.charAt(4) <= 57) &&
				(licensePlate.charAt(5) >= 48 && licensePlate.charAt(5) <= 57) &&
				(licensePlate.charAt(7) >= 65 && licensePlate.charAt(7) <= 90) &&
				(licensePlate.charAt(8) >= 65 && licensePlate.charAt(8) <= 90) &&
				(licensePlate.charAt(9) >= 65 && licensePlate.charAt(9) <= 90) && 
				licensePlate.length() == 10;
	}
	
	public static boolean isValidCapacity(int capacity) {
		return capacity >= 1 && capacity <= 7;
	}
	
	public static void AddDriver() {
		int loop;
		int capacity;
		String name;
		String car;
		String licensePlate;
		boolean status;
		Cars Car;
		
		System.out.println("Insert New Driver");
		System.out.println("=============================================");
		System.out.println();
		
		loop = 0;
		do {
			if (loop > 0) {
				System.out.println("Name must be between 5 and 25 characters long");
			}
			System.out.print("Input Driver's Name [ 5 - 25 characters ]: ");
			name = scan.nextLine();
			loop++;
		} while(!isValidName(name));
		
		loop = 0;
		do {
			if (loop > 0) {
				System.out.println("Car's name cannot be empty");
			}
			System.out.print("Input Driver's Car [ ex: Toyota Innova ]: ");
			car = scan.nextLine();
			loop++;
		} while(!isValidCar(car));
		
		loop = 0;
		do {
			if (loop > 0) {
				System.out.println("The license plate's format is invalid");
			}
			System.out.print("Input Driver's Car License Plate: ");
			licensePlate = scan.nextLine();
			loop++;
		} while(!isValidLicensePlate(licensePlate));
		
		loop = 0;
		do {
			if (loop > 0) {
				System.out.println("Car capacity must be between 1 - 7 passengers");
			}
			System.out.print("Input Driver's Car Maximum Passengers [ 1 - 7 people ]: ");
			capacity = scan.nextInt();
			loop++;
		} while(!isValidCapacity(capacity));
		
		status = true;
		
		Car = new Cars(capacity, car, licensePlate);
		
		Driver.add(new Drivers(name, status, Car, null));
		
		System.out.println();
		System.out.println("Driver " + name + " is successfully added!");
		System.out.print("Press Enter to Continue...");
		scan.nextLine();
		scan.nextLine();
		
		System.out.println();
		MainMenu();
	}
	
	public static void PreviewData() {
		int i;
		System.out.println("+=============================================================================+");
		System.out.println("| No  | Driver Name                 | Vehicle Name          | Vehicle License |");
		System.out.println("+=============================================================================+");
		
		for (i = 0; i < Driver.size(); i++) {
			System.out.println(String.format("%s %-3s %s %-27s %s %-21s %s %-15s %s", 
					"|", i + 1,
					"|", Driver.get(i).getDriverName(),
					"|", Driver.get(i).getCar().getCarName(),
					"|", Driver.get(i).getCar().getCarLicensePlate(), "|"));
		}
		
		System.out.println("+=============================================================================+");
	}
	
	public static boolean isValidIndex(int index) {
		return index >= 0 && index < Driver.size();
	}
	
	public static void DeleteDriver() {
		if (Driver.isEmpty()) {
			System.out.println("Delete Driver");
			System.out.println("=============================================");
			System.out.println();
			System.out.println("No driver available.");
			System.out.println();
			System.out.print("Press Enter to Continue...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		} else {
			int tobeDeleted;
			String DeletedName;
			
			System.out.println("Delete Driver");
			System.out.println("=============================================");
			System.out.println();
			
			PreviewData();
			
			System.out.println();
			System.out.println();
			
			do {
				if (Driver.size() == 1) {
					System.out.print("Select driver to be removed [1]: ");
					tobeDeleted = scan.nextInt();
					scan.nextLine();
				} else {
					System.out.print("Select driver to be removed [1 - " + Driver.size() + "]: ");
					tobeDeleted = scan.nextInt();
					scan.nextLine();
				}
			} while(!isValidIndex(tobeDeleted - 1));
			
			DeletedName = Driver.get(tobeDeleted - 1).getDriverName();
			Driver.remove(tobeDeleted - 1);
			
			System.out.println();
			System.out.println(DeletedName + " has been removed from driver list.");
			
			System.out.println();
			System.out.print("Press Enter to Continue...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		}
	}
	
	public static boolean isBusy() {
		for (Drivers driver: Driver) {
			if (driver.isDriverIsFree()) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidClient(String name) {
		return name.length() >= 1;
	}
	
	public static void AssignPassenger() {
		if (Driver.isEmpty()) {
			System.out.println("Assign Client");
			System.out.println("=============================================");
			System.out.println();
			System.out.println("No driver available.");
			System.out.println();
			System.out.print("Press Enter to Continue...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		} else if (isBusy()) {
			System.out.println("Assign Client");
			System.out.println("=============================================");
			System.out.println();
			System.out.println("Sorry, all of our drivers are busy.");
			System.out.println();
			System.out.print("Press Enter to Continue...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		} else {
			int loop;
			String clientName = null;
			String driverName = null;
			Clients client;
			
			System.out.println("Assign Client");
			System.out.println("=============================================");
			System.out.println();
			
			loop = 0;
			do {
				if (loop > 0) {
					System.out.println("Client Name cannot be empty");
				}
				System.out.print("Input Client Name: ");
				clientName = scan.nextLine();
				loop++;
			} while(!isValidClient(clientName));
			
			client = new Clients(clientName);
			
			for(Drivers driver: Driver) {
				if (driver.isDriverIsFree()) {
					driverName = driver.getDriverName();
					driver.setClient(client);
					driver.setDriverIsFree(false);
					break;
				}
			}
			
			System.out.println();
			System.out.println(clientName + " is assigned to Driver " + driverName);
			System.out.println();
			System.out.print("Press Enter to Continue...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		}
	}
}
