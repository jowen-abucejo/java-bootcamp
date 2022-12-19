package exer06.model;

public class Meat extends Food {
	private double weight;
	private int grade;

	public Meat(String name, String expirationDate, double weight, int grade) {
		/*
		 * (ITEM #2) initialize the state of the meat instance
		 * using the specified parameters
		 */
		super(name, expirationDate);
		this.weight = weight;
		this.grade = grade;
	}

	public double getWeight() {
		return this.weight;
	}

	public int getGrade() {
		return this.grade;
	}

	/*
	 * (ITEM #3) implement the method getInfo();
	 * should return a JSON String
	 */
	@Override
	public String getInfo() {
		return "{\n"
				+ "\n\t'name' : '" + this.getName() + "'"
				+ ",\n\t'expiration_date' : '" + this.getExpirationDate() + "'"
				+ ",\n\t'weight' : " + this.weight
				+ ",\n\t'grade' : '" + this.grade + "'"
				+ "\n}";
	}
}
