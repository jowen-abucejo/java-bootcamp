package exer04.actors;

import java.util.Random;

import exer04.items.HealingPotion;

public class Pokemon {

	private String name;
	private int hitPoints;
	private int manaPoints;
	private int experiencePoints;
	private int level;
	private int gold;

	final public int MAX_HP = 40;

	public Pokemon(String name) {
		if (name.isBlank())
			throw new IllegalArgumentException("Name cannot be empty!");

		this.name = name;
		this.hitPoints = 40;
		this.manaPoints = 10;
		this.experiencePoints = 0;
		this.level = 1;
		this.gold = 0;
	}

	public void sing() {
		if (getManaPoints() < 2) {
			System.out.println("No Mana!");
			return;
		}

		boolean isSuccess = new Random().nextBoolean();
		if (isSuccess) {
			System.out.println("Singing Succeeded");
			setExperiencePoints(getExperiencePoints() + 5);
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

	private void setHitPoints(int hitPoints) {
		if (hitPoints <= 0) {
			this.hitPoints = 0;
			System.out.println(getName() + "'s HP is 0." + getName() + " is dead!.");
			return;
		}

		this.hitPoints = hitPoints;

		if (this.hitPoints > MAX_HP) {
			this.hitPoints = MAX_HP;
		}
	}

	public int getManaPoints() {
		return manaPoints;
	}

	private void setManaPoints(int manaPoints) {
		if (manaPoints < 0)
			return;

		this.manaPoints = manaPoints;
	}

	public int getExperiencePoints() {
		return experiencePoints;
	}

	private void setExperiencePoints(int experiencePoints) {
		if (experiencePoints < 0)
			return;

		this.experiencePoints = experiencePoints;

		if (this.experiencePoints % 20 == 0) {
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

	private void setGold(int gold) {
		if (gold < 0)
			return;
		this.gold = gold;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format(
				"[Name: %s, Hit Points: %d, Mana Points: %d, Experience Points: %d, Level: %d, Gold: %d]", getName(),
				getHitPoints(), getManaPoints(), getExperiencePoints(), getLevel(), getGold());
	}

}
