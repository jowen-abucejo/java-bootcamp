package lab;


/*
 * created by : Jowen Naval Abucejo
 * */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Exer02 {
	public static void main(String[] args) {
		int offset = 0;
		char[] blacklist = {'!', '@', '#', '$', '%', '^', '&', '*'};
		String cyphertext = "";
		Scanner scan = new Scanner(System.in);

		/*
			Item #1:
			Set the variable offset to the first argument passed upon running the program 
		*/

		/*
			Item #2:
			Use a try-catch statement to ensure that a valid offset was supplied.
			If the value supplied is not valid, inform the user and exit the program.
		*/
		try {
			offset = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Invalid Offset!");
			System.exit(0);
		}

		/*
			Item #3:
			Ask the user for a String to be encrypted and assign it to a 
			variable named plaintext.
		*/
		System.out.println("Enter String to be encrypted:");
	    String plaintext = scan.nextLine();
	    scan.close();

		/*
			Item #4:
			Convert the variable plaintext into uppercase.
		*/
	    plaintext = plaintext.toUpperCase();
			
		/*
			Item #5:
			Verify that the length of plaintext is not less than 8.
			If it is less than 8, inform the user and exit the program.
		*/
	    if(plaintext.length() < 8 ) {
	    	System.out.println("Invalid Input! String must be at least 8 characters long.");
	    	System.exit(0);
	    }

		/*
			Items #6-10:
			Implement Caesar cypher; if a character in the plaintext belongs to
			the blacklisted character, inform the user and exit
		*/
	    
	    Set<Character> blackListedChars = new HashSet<>();
	    for (Character character : blacklist) {
			blackListedChars.add(character);
		}
	    
	    
	    for (char toEncryptCharacter : plaintext.toCharArray()) {
	    	//stop program if character is blacklisted
	    	if(blackListedChars.contains(toEncryptCharacter)) {
	    		System.out.println("Character '" + toEncryptCharacter + "' is Invalid!." );
	    		System.exit(0);
	    	}
	    	
	    	//ascii numeric equivalent of character
	    	int asciiValue = (int) toEncryptCharacter;
	    	
	    	//set offset to numbers between 0-25
	    	//offset %= 26;
	    	int alphabetOffset = offset % 26;
	    	int numberOffset = offset % 10;
	    	
	    	//encrypt alphabet character
	    	if(asciiValue >=65 && asciiValue <= 90) {
		    	asciiValue += alphabetOffset;
		    	if(asciiValue < 65) {
		    		asciiValue = 90 - (64 - asciiValue);
		    	}else if(asciiValue > 90) {
		    		asciiValue = asciiValue - 90 + 64;
		    	}
		    }
	    	
	    	if(asciiValue >= 48 && asciiValue <= 57) {
	    		asciiValue += numberOffset;
	    		if(asciiValue < 48) {
		    		asciiValue = 57 - (47 - asciiValue);
		    	}else if(asciiValue > 57) {
		    		asciiValue = asciiValue - 57 + 47;
		    	}
	    	}
	    	
	    	//concatenate encrypted characters
	    	cyphertext=String.format("%s%c", cyphertext, (char)asciiValue);
		}

		System.out.println(cyphertext);
	}
}