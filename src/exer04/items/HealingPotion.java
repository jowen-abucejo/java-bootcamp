package exer04.items;

public class HealingPotion {
	private String name;
	private int price;
	private int potency;

	public HealingPotion(String name, int price, int potency) {
		if (name.isBlank()) throw new IllegalArgumentException("Name cannot be empty!");
		
		this.name = name;
		this.price = price;
		this.potency = potency;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getPotency() {
		return potency;
	}

	@Override
	public String toString() {
		return String.format("[Name: %s, Price: %d, Potency: %d]", getName(), getPrice(), getPotency());
	}

}
