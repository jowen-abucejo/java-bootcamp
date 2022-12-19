package exer06.model;

public abstract class Food {
	private String name;
	private String expirationDate;

	public Food(String name, String expirationDate) {
		this.name = name;
		this.expirationDate = expirationDate;
	}

	public String getName() {
		return this.name;
	}

	public String getExpirationDate() {
		return this.expirationDate;
	}

	public abstract String getInfo();

	public String getType() {
		return this.getClass().getSimpleName();
	}
}
