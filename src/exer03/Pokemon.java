package exer03;

import java.util.Random;

public class Pokemon {

	private String name;
	private int hitPoints;
	private int manaPoints;
	private int experience;
	private int level;
	private int gold;

	final public int MAX_HP = 40;

	public Pokemon(String name) {
		this.name = name;
		this.hitPoints = 40;
		this.manaPoints = 10;
		this.experience = 0;
		this.level = 1;
		this.gold = 0;
	}

	public void sing() {
		if (getManaPoints() == 0) {// <2
			System.out.println("No Mana!");
			return;
		}

		boolean isSuccess = new Random().nextBoolean();
		if (isSuccess) {
			System.out.println("Singing Succeeded");
			setExperience(getExperience() + 5);
			;
		} else {
			System.out.println("Singing Failed");
			setHitPoints(getHitPoints() - 4);
		}

		setManaPoints(getManaPoints() - 2);
	}

	public void buyHealingPotion(HealingPotion potion) {
		if (getGold() < potion.getPrice()) {
			System.out.println("No Enough Gold!");
		} else {
			System.out.println("Bought Potion -> " + potion);

			setHitPoints(getHitPoints() + potion.getPotency());
			setGold(getGold() - potion.getPrice());
		}
	}

	public void mate(Pokemon pokemon) {
		if (pokemon == this) {
			System.out.println("Pokemon can't mate to itself!");
			return;
		}

		setLevel(getLevel() + 1);
		pokemon.setLevel(pokemon.getLevel() + 1);
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		if (hitPoints <= 0) {
			this.hitPoints = 0;
			System.out.println(getName() + "'s HP is 0." + getName() + " is dead!.");
			return;
		}
		;

		this.hitPoints = hitPoints;

		if (this.hitPoints > MAX_HP) {
			this.hitPoints = MAX_HP;
		}
	}

	public int getManaPoints() {
		return manaPoints;
	}

	public void setManaPoints(int manaPoints) {
		if (manaPoints < 0)
			return;

		this.manaPoints = manaPoints;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		if (experience < 0)
			return;

		this.experience = experience;

		if (this.experience % 20 == 0) {
			setLevel(getLevel() + 1);
		}
	}

	public int getLevel() {
		return level;
	}

	private void setLevel(int level) {
		this.level = level;
		setHitPoints(getHitPoints() + 10);
		setManaPoints(getManaPoints() + 10);
		setGold(getGold() + 5);
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format(
				"[Name: %s, Hit Points: %d, Mana Points: %d, Experience: %d, Level: %d, Gold: %d]", getName(),
				getHitPoints(), getManaPoints(), getExperience(), getLevel(), getGold());
	}

}
