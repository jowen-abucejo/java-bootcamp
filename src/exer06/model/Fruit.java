package exer06.model;

public class Fruit extends Food {
	private double weight;
	private String color;

	public Fruit(String name, String expirationDate, double weight, String color) {
		super(name, expirationDate);
		this.weight = weight;
		this.color = color;
	}

	public double getWeight() {
		return this.weight;
	}

	public String color() {
		return this.color;
	}

	public String getInfo() {
		return "{"
				+ "\n\t'name' : '" + this.getName() + "'"
				+ ",\n\t'expiration_date' : '" + this.getExpirationDate() + "'"
				+ ",\n\t'weight' : " + this.weight
				+ ",\n\t'color' : '" + this.color + "'"
				+ "\n}";
	}
}
