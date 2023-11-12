package Ejercicio2;

public class Animal {
	private int intId;
	private String stName;
	private String stSpecies;
	private String stBreed;
	private int intAge;
	private String stSterilised;
	
	public Animal(int intId, String stName, String stSpecies, String stBreed, int intAge, String stSterilised) {
		this.intId = intId;
		this.stName = stName;
		this.stSpecies = stSpecies;
		this.stBreed = stBreed;
		this.intAge = intAge;
		this.stSterilised = stSterilised;
	}

	public int getIntId() {
		return intId;
	}

	public void setIntId(int intId) {
		this.intId = intId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStSpecies() {
		return stSpecies;
	}

	public void setStSpecies(String stSpecies) {
		this.stSpecies = stSpecies;
	}

	public String getStBreed() {
		return stBreed;
	}

	public void setStBreed(String stBreed) {
		this.stBreed = stBreed;
	}

	public int getIntAge() {
		return intAge;
	}

	public void setIntAge(int intAge) {
		this.intAge = intAge;
	}

	public String getStSterilised() {
		return stSterilised;
	}

	public void setStSterilised(String stSterilised) {
		this.stSterilised = stSterilised;
	}
}
