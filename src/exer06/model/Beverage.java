package exer06.model;

public class Beverage extends Food {
	private double volume;
	private String brand;

	public Beverage(String name, String expirationDate, double volume, String brand) {
		/*
		 * (ITEM #1) initialize the state of the beverage instance
		 * using the specified parameters
		 */
		super(name, expirationDate);
		this.volume = volume;
		this.brand = brand;
	}

	public double getVolume() {
		return this.volume;
	}

	public String getBrand() {
		return this.brand;
	}

	public String getInfo() {
		return "{\n"
				+ "\n\t'name' : '" + this.getName() + "'"
				+ ",\n\t'expiration_date' : '" + this.getExpirationDate() + "'"
				+ ",\n\t'volume' : " + this.volume
				+ ",\n\t'brand' : '" + this.brand + "'"
				+ "\n}";
	}
}
