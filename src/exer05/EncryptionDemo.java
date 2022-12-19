package exer05;

import java.util.Scanner;

public class EncryptionDemo {
	public static void main(String[] args) {

		Scanner intScanner = new Scanner(System.in);
		Scanner stringScanner = new Scanner(System.in);
		int offset;
		// String cyphertext;
		String plaintext;

		System.out.print("Enter a string to be encrypted: ");
		plaintext = stringScanner.nextLine();

		System.out.print("Enter value of offset: ");
		offset = intScanner.nextInt();

		CaesarCypher caesarCipher = new CaesarCypher(offset);
		caesarCipher.encrypt(plaintext);

		System.out.println("Encrypted string: " + caesarCipher.getLastCyphertext());

		System.out.print("Enter a string to be encrypted: ");
		plaintext = stringScanner.nextLine();

		System.out.print("Enter value of offset: ");
		offset = intScanner.nextInt();

		CaesarCypher caesarCipher2 = new CaesarCypher(offset, true);
		caesarCipher2.encrypt(plaintext);

		System.out.println("Encrypted string: " + caesarCipher2.getLastCyphertext());

		intScanner.close();
		stringScanner.close();

	}
}

// Item #8 Does the CaesarCypher class have offset and cyphertext attributes?
// Explain your answer.
// --No, the CaesarCypher class has only offset attribute because the offset is
// set as protected in Cypher class so it is being inherited by all of Cypher's
// sub/derived classess
// while the cyphertext attribute is set as private so it is for Cypher class
// internal use only

// Item #9 When do you declare a class as an abstract class? How about a method?
// When do you declare it as an abstract method?
// --You declare a class as an abstract class when it is intended to be a super
// class and there is/are method/s (abstract method/s) that need to be
// implemented by all of its sub/derived classes.
// --You declare a method as an abstract method when different sub/derived
// classes need to have different implementations of it.

// Item #10 When do you declare a class as a final class? When do you declare it
// as a final method?
// --You declare a class as final class when it should not have sub/derived
// classes
// --You declare a method of a class as final method when its implementations
// are need to be the same(should not be overriden) for all of its sub/derived
// classes
