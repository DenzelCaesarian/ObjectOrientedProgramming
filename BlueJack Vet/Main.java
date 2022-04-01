import java.util.*;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Vector<Pets> Pet = new Vector<Pets>();

	public static void main(String[] args) {
		PrintLogo();
		MainMenu();
	}
	
	public static void PrintLogo() {
		System.out.println(" ____       _          __      __  _");
		System.out.println("|  _ \\     | |         \\ \\    / / | |");
		System.out.println("| |_) |    | |  _____   \\ \\  / /__| |_");
		System.out.println("|  _ < _   | | |_____|   \\ \\/ / _ \\ __|");
		System.out.println("| |_) | |__| |            \\  /  __/ |_");
		System.out.println("|____/ \\____/              \\/ \\___|\\__|");
	}
	
	public static void MainMenu() {
		int choice;
		
		do {
			System.out.println("+=====================+");
			System.out.println("+Menu                 +");
			System.out.println("+=====================+");
			System.out.println("+1. Add Sick Pet      +");
			System.out.println("+2. View Sick List    +");
			System.out.println("+3. Update Pet Health +");
			System.out.println("+4. Treat Pet         +");
			System.out.println("+5. Exit Program      +");
			System.out.println("+=====================+");
			System.out.print("Choice >> ");
			
			choice = scan.nextInt();
			scan.nextLine();
			
			switch (choice) {
				case 1:
					System.out.println();
					AddPet();
					break;
				case 2: 
					System.out.println();
					ViewPet();
					break;
				case 3:
					System.out.println();
					UpdatePet();
					break;
				case 4:
					System.out.println();
					DeletePet();
					break;
				case 5:
					System.out.println();
					System.out.println("Thanks for using BJ-Vet Program");
					return;
			}
		} while(choice < 1 || choice > 5);
	}
	
	public static boolean isValidHealth(int PetHealth) {
		return PetHealth >= 1 && PetHealth <= 90;
	}
	
	public static boolean isValidName(String PetName) {
		return PetName.length() >= 5 && PetName.length() <= 15;
	}
	
	public static boolean isValidType(String PetType) {
		return PetType.equals("kit") || PetType.equals("puppy") || PetType.equals("kitten");
	}

	public static void AddPet() {
		int PetHealth;
		String TempName;
		String PetName;
		String PetType;
		String PetSound;
		
		do {
			System.out.print("Input pet health [1 - 90]: ");
			PetHealth = scan.nextInt();
			scan.nextLine();
		} while(!isValidHealth(PetHealth));
		
		do {
			System.out.print("Input pet name [5 - 15 characters]: ");
			TempName = scan.nextLine();
		} while(!isValidName(TempName));
		
		do {
			System.out.print("Input pet type [kit | puppy | kitten]: ");
			PetType = scan.nextLine();
		} while(!isValidType(PetType));
		
		if (PetType.equals("kit")) {
			PetName = "Rabbit " + TempName;
			PetSound = "clucking";
		} else if (PetType.equals("puppy")) {
			PetName = "Dog " + TempName;
			PetSound = "bark bark";
		} else {
			PetName = "Cat " + TempName;
			PetSound = "meow meow";
		}
		
		Pet.add(new Pets(PetHealth, PetName, PetType, PetSound));
		
		System.out.println("Pet successfully added to the list...");
		
		System.out.println();
		MainMenu();
	}
	
	public static void PrintList() {
		int i;
		
		System.out.println("+==========================================================+");
		System.out.println("+ No |        Name         |   Type   |   Sound   | Health +");
		System.out.println("+==========================================================+");
		
		for (i = 0; i < Pet.size(); i++) {
			System.out.println(String.format("%s %-2d %s %-19s %s %-8s %s %-9s %s %-6d %s",
					"+", i + 1,
					"|", Pet.get(i).getPetName(),
					"|", Pet.get(i).getPetType(),
					"|", Pet.get(i).getPetSound(),
					"|", Pet.get(i).getPetHealth(), "+"));
		}
		
		System.out.println("+==========================================================+");
	}
	
	public static void ViewPet() {
		if (Pet.isEmpty()) {
			System.out.println("+==========================================================+");
			System.out.println("+ No |        Name         |   Type   |   Sound   | Health +");
			System.out.println("+==========================================================+");
			System.out.println("+ Empty -                                                  +");
			System.out.println("+==========================================================+");
			System.out.print("Press Enter to continue...");
			scan.nextLine();
			
			System.out.println();
			MainMenu();
		} else {
			PrintList();
			
			System.out.println();
			MainMenu();
		}
	}
	
	public static boolean isValidIndex(int toUpdateIndex) {
		return toUpdateIndex >= 0 && toUpdateIndex < Pet.size();
	}

	public static void UpdatePet() {
		if (Pet.isEmpty()) {
			System.out.println();
			MainMenu();
		} else {
			int toUpdateIndex, newPetHealth;
			
			do {
				PrintList();
				
				System.out.print("Choose pet number to update ");
				
				if (Pet.size() == 1) {
					System.out.print("[1]: ");
				} else {
					System.out.print("[1 - " + Pet.size() + "]: ");
				}
				
				toUpdateIndex = scan.nextInt();
				scan.nextLine();
				
			} while(!isValidIndex(toUpdateIndex - 1));
			
			do {
				System.out.print("Update pet health [1 - 90]: ");
				newPetHealth = scan.nextInt();
				scan.nextLine();
			} while(!isValidHealth(newPetHealth));
			
			if (newPetHealth < 20) {
				Pet.get(toUpdateIndex - 1).setPetHealth(25);
			} else if (newPetHealth < Pet.get(toUpdateIndex - 1).getPetHealth()) {
				Pet.get(toUpdateIndex - 1).setPetHealth((Pet.get(toUpdateIndex - 1).getPetHealth() + newPetHealth) / 2);
			} else {
				Pet.get(toUpdateIndex - 1).setPetHealth(newPetHealth);
			}
			
			System.out.println("Pet health updated..");
			
			System.out.println();
			MainMenu();
		}
	}
	
	public static void DeletePet() {
		if (Pet.isEmpty()) {
			System.out.println();
			MainMenu();
		} else {
			int toDeleteIndex;
			
			do {
				PrintList();
				
				System.out.print("Choose pet number to be treated ");
				
				if (Pet.size() == 1) {
					System.out.print("[1]: ");
				} else {
					System.out.print("[1 - " + Pet.size() + "]: ");
				}
				
				toDeleteIndex = scan.nextInt();
				scan.nextLine();
				
			} while(!isValidIndex(toDeleteIndex - 1));
			
			Pet.remove(toDeleteIndex - 1);
		
			System.out.println("Pets treated!!");
			
			System.out.println();
			MainMenu();
		}
	}
}
