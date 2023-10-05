package ejercicio2;

public class Product {
	private final String strName;
	private double dbPrice;
	private int intUnits;
	
	public Product(String strName, double dbPrice, int intUnits) {
		this.strName = strName;
		this.dbPrice = dbPrice;
		this.intUnits = intUnits;
	}

	public double getDbPrice() {
		return dbPrice;
	}

	public void setDbPrice(double dbPrice) {
		this.dbPrice = dbPrice;
	}

	public int getIntUnits() {
		return intUnits;
	}

	public void setIntUnits(int intUnits) {
		this.intUnits = intUnits;
	}

	public String getStrName() {
		return strName;
	}

	@Override
	public String toString() {
		return String.format("Product: %s - Price: %.2f - Units: %d", this.strName, this.dbPrice, this.intUnits);
	}
	
	
}
