public class Pets {
	private int PetHealth;
	private String PetName;
	private String PetType;
	private String PetSound;
	
	public Pets(int petHealth, String petName, String petType, String petSound) {
		super();
		PetHealth = petHealth;
		PetName = petName;
		PetType = petType;
		PetSound = petSound;
	}

	public int getPetHealth() {
		return PetHealth;
	}

	public void setPetHealth(int petHealth) {
		PetHealth = petHealth;
	}

	public String getPetName() {
		return PetName;
	}

	public void setPetName(String petName) {
		PetName = petName;
	}

	public String getPetType() {
		return PetType;
	}

	public void setPetType(String petType) {
		PetType = petType;
	}

	public String getPetSound() {
		return PetSound;
	}

	public void setPetSound(String petSound) {
		PetSound = petSound;
	}
}
