package exer06;

import exer06.model.*;
import java.util.Scanner;

public class Demo {
	private static Scanner scan = new Scanner(System.in);
	private final static String BEVERAGE = "Beverage";
	private final static String FRUIT = "Fruit";
	private final static String MEAT = "Meat";

	public static void main(String[] args) {

		// Initial food items to store in the refrigerator
		Fruit fruit = new Fruit("Kiwi", "2016-03-20", 0.25, "green");
		Beverage beverage = new Beverage("Coffee", "2018-09-15", 1.0, "Kopiko");
		Meat meat = new Meat("Pork", "2016-03-30", 5.0, 1);

		Refrigerator ref = new Refrigerator();
		ref.add(fruit);
		ref.add(beverage);
		ref.add(meat);

		int choice = 0;

		do {
			switch (choice = showMenu()) {
				case 1:
					storeFoodMenu(ref);
					break;
				case 2:
					showContents(ref);
					break;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid answer.");
			}

		} while (choice != 0);

	}

	private static int showMenu() {
		System.out.println("=====================================");
		System.out.println(" REFRIGERATOR DEMO                   ");
		System.out.println("=====================================");
		System.out.println("[1] Store Food");
		System.out.println("[2] Open Refrigerator");
		System.out.println("[0] Exit");
		System.out.print("Choice [1-3]: ");
		return scan.nextInt();
	}

	private static void storeFoodMenu(Refrigerator ref) {
		String name, expDate, brand, color;
		int grade;
		double weight, volume;

		System.out.println("=====================================");
		System.out.println(" > Store Food                        ");
		System.out.println("=====================================");
		System.out.println("Food type:\n\t[1] Fruit");
		System.out.println("\t[2] Meat");
		System.out.println("\t[3] Beverage");
		System.out.print("Choice [1-3]: ");
		int foodChoice = scan.nextInt();
		scan.nextLine();

		System.out.print("Name: ");
		name = scan.nextLine();
		System.out.print("Expiry Date (yyyy-mm-dd): ");
		expDate = scan.nextLine();

		switch (foodChoice) {
			case 1:
				System.out.print("Weight (kg): ");
				weight = scan.nextDouble();
				scan.nextLine();
				System.out.print("Color: ");
				color = scan.nextLine();

				Fruit fruit = new Fruit(name, expDate, weight, color);
				ref.add(fruit);
				break;
			case 2:
				System.out.print("Weight (kg): ");
				weight = scan.nextDouble();
				scan.nextLine();
				System.out.print("Grade: ");
				grade = scan.nextInt();

				Meat meat = new Meat(name, expDate, weight, grade);
				ref.add(meat);
				break;
			case 3:
				System.out.print("Volume (liters): ");
				volume = scan.nextDouble();
				scan.nextLine();
				System.out.print("Brand: ");
				brand = scan.nextLine();

				Beverage beverage = new Beverage(name, expDate, volume, brand);
				ref.add(beverage);
				break;
			default:
				System.out.println("Invalid choice!");
		}

	}

	private static void showContents(Refrigerator ref) {
		System.out.println("=====================================");
		System.out.println(" > Refrigerator Contents             ");
		System.out.println("=====================================");

		System.out.println("\nFood Count: " + ref.getFoodCount());
		System.out.println("All Contents:");
		ref.listRefContents();

		System.out.println("\nBeverage Count: " + ref.getFoodCount(BEVERAGE));
		ref.listRefContents(BEVERAGE);

		System.out.println("\nFruit Count: " + ref.getFoodCount(FRUIT));
		ref.listRefContents(FRUIT);

		System.out.println("\nMeat Count: " + ref.getFoodCount(MEAT));
		ref.listRefContents(MEAT);
	}
}
