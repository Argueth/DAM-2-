package ejercicio1;

public class Pizza {
	private int id;
	private String name;
	private double price;
	
	public Pizza (int intId, String stName, double dbPrice) {
		this.id = intId;
		this.name = stName;
		this.price = dbPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return String.format("Pizza ID: %d - Name: %s - Price: %f", this.id, this.name, this.price);
	}
	
}
