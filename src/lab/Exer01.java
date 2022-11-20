/*
	Item #1: 
	Add this class to a package named 'lab'.
*/
package lab;

/*
 * created by : Jowen Naval Abucejo
 * */

import java.util.Scanner;

public class Exer01 {
	/*
		Item #2:
		Correct the declaration of main method.
	*/	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		/*
			Item #3:
			Declare an integer variable named 'choice'; declare a double variable named velocity;
		*/
		int choice;
		double velocity;

		double distance;
		final double WOODEN_BOX=0.25;
		final double BRICK_BOX=0.6;
		final double ICE_BOX=0.05;
		/*
			Item #4:
			Declare a constant named 'GRAVITY'.
		*/
		final double GRAVITY=9.8;

		/*	
			Item #5:
			Print a menu that looks like the following:
			==========================
			  NEWTONIAN PHYSICS DEMO
			==========================
			[1] Wooden Box
			[2] Brick Box
			[3] Ice Box
			Select an object to push on a wooden surface (1-3):
		*/
		System.out.println(
				 "=========================="
				+ "\nNEWTONIAN PHYSICS DEMO\n"
				+ "\n=========================="
				+ "\n[1] Wooden Box"
				+ "\n[2] Brick Box"
				+ "\n[3] Ice Box"
				+ "\nSelect an object to push on a wooden surface (1-3):");

		/*
			Item #6 (2 points)
			Ask the user for an integer; assign it to 'choice';
			Ask the user for the object's initial velocity; assign it to 'velocity'. 
		*/
//		System.out.print("Enter an integer:");
		choice = scan.nextInt();
		
		System.out.println("Enter object's initial velocity:");
		velocity = scan.nextDouble();
		
		scan.close();
		
		double acceleration;
		switch(choice){
				/*
					Item #7 (2 points)
					Compute the distance the object will travel given its initial velocity;
					assign the result of the computation to 'distance'.
				*/
			case 1:
				acceleration = -1 * WOODEN_BOX * GRAVITY;
				distance = (velocity*velocity)/(-2*acceleration);
				draw(distance);
				break;
			case 2:
				acceleration = -1 * BRICK_BOX * GRAVITY;
				distance = (velocity*velocity)/(-2*acceleration);
				draw(distance);
				break;
			case 3:
				acceleration = -1 * ICE_BOX * GRAVITY;
				distance = (velocity*velocity)/(-2*acceleration);
				draw(distance);
				break;
			default:
				System.out.println("Invalid input.");
				System.exit(0);
		}
	}

	public static void draw(double distance){
		System.out.println("distance: "+distance);
		System.out.print(" ____ ");
		for(double i=distance; i>=0.5; i-=0.5){
			System.out.print("  ");
		}
		System.out.println("  ____ ");

		System.out.print("|    | ");
		for(double i=distance; i>=0.5; i-=0.5){
			System.out.print("_ ");
		}
		System.out.println("|    |");

		System.out.print("|____|");
		for(double i=distance; i>=0.5; i-=0.5){
			System.out.print("  ");
		}
		System.out.print(" |____|");

	}
}

/*
	Item #8
	Which of the boxes will travel farther if they were all given the same initial velocity?
	
	the ICE_BOX will travel the most
*/