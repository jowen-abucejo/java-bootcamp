package exer03;

public class HealingPotion {
	private String name;
	private int price;
	private int potency;
	
	public HealingPotion(String name, int price, int potency) {
		super();
		this.name = name;
		this.price = price;
		this.potency = potency;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPotency() {
		return potency;
	}
	public void setPotency(int potency) {
		this.potency = potency;
	}
	
	@Override
	public String toString() {
		return String.format("[Name: %s, Price: %d, Potency: %d]", getName(), getPrice(), getPotency());
	}
	
}
