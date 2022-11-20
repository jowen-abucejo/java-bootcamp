package exer03;

import java.util.Scanner;

public class PokemonRunner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Pokemon[] pokemons = {
				new Pokemon("Gengar"),
				new Pokemon("Gastly"),
				new Pokemon("Haunter")
		};

		HealingPotion[] potions = {
				new HealingPotion("Magic Potion", 1, 2),
				new HealingPotion("Epic Potion", 2, 5),
				new HealingPotion("Legendary Potion", 5, 10)
		};

		int mode = selectGameMode(scan);
		scan.nextLine();

		if (mode == 1) {
			playNewGame(scan, potions, pokemons);
		} else {
			playDemo(potions, pokemons);
		}

	}

	// demo of game
	static void playDemo(HealingPotion[] potions, Pokemon[] pokemons) {
		Pokemon gengar = pokemons[0];
		Pokemon gastly = pokemons[1];

		HealingPotion magicPotion = potions[0];
		HealingPotion epicPotion = potions[1];

		System.out.println("Before Gastly and Gengar sing");
		System.out.println(gastly);
		System.out.println(gengar);

		gastly.sing();
		gengar.sing();
		System.out.println("\nAfter Gastly and Gengar sing");
		System.out.println(gastly);
		System.out.println(gengar);

		gastly.mate(gengar);
		System.out.println("\nAfter Gastly mate with Gengar");
		System.out.println(gastly);
		System.out.println(gengar);

		gengar.mate(gastly);
		System.out.println("\nAfter Gengar mate with Gastly");
		System.out.println(gastly);
		System.out.println(gengar);

		gastly.buyHealingPotion(magicPotion);
		System.out.println("\nAfter Gastly buy Potion");
		System.out.println(gastly);

		System.out.println("\nAfter Gengar buy Potion");
		gengar.buyHealingPotion(epicPotion);
		System.out.println(gengar);

	}

	// new game
	static void playNewGame(Scanner scan, HealingPotion[] potions, Pokemon[] pokemons) {
		String pokemonName = enterPlayerPokemonName(scan);
		if (pokemonName.trim().isEmpty()) {
			System.out.println("Pokemon name cannot be empty!");
			System.exit(0);
		}

		Pokemon player = new Pokemon(pokemonName);
		int action = 1;

		do {
			System.out.println("Player's Info: " + player.toString());
			action = selectAction(scan);

			switch (action) {
				case 1: {
					player.sing();
					break;
				}
				case 2: {
					int potionIndex = selectHealingPotion(scan, potions);
					if (potionIndex > 0 && potionIndex <= potions.length)
						player.buyHealingPotion(potions[potionIndex - 1]);
					break;
				}
				case 3: {
					int pokemonIndex = selectPokemonToMate(scan, pokemons);
					if (pokemonIndex > 0 && pokemonIndex <= pokemons.length)
						player.mate(pokemons[pokemonIndex - 1]);
					break;
				}

				default: {
					System.out.println("Game Exited!");
					System.exit(0);
				}
			}
		} while (player.getHitPoints() > 0);
		System.out.println("Game Over!");
	}

	static int selectGameMode(Scanner scan) {
		System.out.println(
				"===================================="
						+ "\n SELECT GAME MODE"
						+ "\n  [1] New Game"
						+ "\n  [other keys] Demo"
						+ "\n====================================");

		try {
			return Integer.parseInt(scan.next());
		} catch (Exception e) {
			return 2;
		}
	}

	static int selectAction(Scanner scan) {
		System.out.println(
				"===================================="
						+ "\n SELECT ACTION"
						+ "\n  [1] Sing"
						+ "\n  [2] Buy Healing Potion"
						+ "\n  [3] Mate With Other Pokemon"
						+ "\n  [other keys] Exit Game"
						+ "\n====================================");

		try {
			return Integer.parseInt(scan.next());
		} catch (Exception e) {
			return 0;
		}
	}

	static int selectHealingPotion(Scanner scan, HealingPotion[] potions) {
		StringBuffer potionNames = new StringBuffer(
				"====================================\n SELECT HEALING POTION TO BUY");
		for (int i = 1; i <= potions.length; i += 1) {
			HealingPotion healingPotion = potions[i - 1];
			potionNames.append("\n  [" + i + "] " + healingPotion);
		}
		potionNames.append("\n  [other keys] Back to Action Menu\n====================================");
		System.out.println(potionNames.toString());

		try {
			return Integer.parseInt(scan.next());
		} catch (Exception e) {
			return 0;
		}
	}

	static int selectPokemonToMate(Scanner scan, Pokemon[] pokemons) {
		StringBuffer pokemonNames = new StringBuffer("====================================\n SELECT POKEMON TO MATE");
		for (int i = 1; i <= pokemons.length; i += 1) {
			Pokemon pokemon = pokemons[i - 1];
			pokemonNames.append("\n  [" + i + "] " + pokemon);
		}
		pokemonNames.append("\n  [other keys] Back to Action Menu\n====================================");
		System.out.println(pokemonNames.toString());

		try {
			return Integer.parseInt(scan.next());
		} catch (Exception e) {
			return 0;
		}
	}

	static String enterPlayerPokemonName(Scanner scan) {
		System.out.println("Enter pokemon name:");
		return scan.nextLine();
	}

}
