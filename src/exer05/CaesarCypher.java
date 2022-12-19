package exer05;

/*
	Item #1: Make CeasarCypher as a subclass of the Cypher class.
*/

public class CaesarCypher extends Cypher {

	private boolean rearrange;

	/*
	 * Item #3: Complete the constructors of the CeasarCypher class.
	 */
	// public CaesarCypher(int offset) {
	// super(offset);
	// this.rearrange = false;
	// }

	// public CaesarCypher(int offset, boolean rearrange) {
	// super(offset);
	// this.rearrange = rearrange;
	// }

	/*
	 * Item #4: Redefine the constructors above without using the keyword super (To
	 * make this work, comment out your solution in item #3).
	 */
	public CaesarCypher(int offset) {
		this.offset = offset;
		this.rearrange = false;
	}

	public CaesarCypher(int offset, boolean rearrange) {
		this.offset = offset;
		this.rearrange = rearrange;
	}

	/*
	 * Item #5-6: Implement encrypt() method.
	 */
	public void encrypt(String plaintext) {
		String cyphertext = "";

		for (char toEncryptCharacter : plaintext.toCharArray()) {

			// ascii numeric equivalent of character
			int asciiValue = (int) toEncryptCharacter;

			// set offset to numbers between 0-25
			int alphabetOffset = this.offset % 26;
			// int alphabetOffset = this.getOffset() % 26;

			if (this.rearrange)// reverse the direction of encryption if need to be rearrange/decrypt
				alphabetOffset *= -1;

			// min and max ascii value for lowercase characters
			int maxAlphabetAscii = 90;
			int minAlphabetAscii = 65;

			// check if character is uppercase
			if (asciiValue >= 97 && asciiValue <= 122) {
				maxAlphabetAscii = 122;
				minAlphabetAscii = 97;
			}

			// encrypt alphabet character
			if (asciiValue >= minAlphabetAscii && asciiValue <= maxAlphabetAscii) {
				asciiValue += alphabetOffset;
				if (asciiValue < minAlphabetAscii) {
					asciiValue = maxAlphabetAscii - ((minAlphabetAscii - 1) - asciiValue);
				} else if (asciiValue > maxAlphabetAscii) {
					asciiValue = asciiValue - maxAlphabetAscii + (minAlphabetAscii - 1);
				}
			}

			// concatenate encrypted characters
			cyphertext = String.format("%s%c", cyphertext, (char) asciiValue);
		}
		/*
		 * Update the value of cyphertext.
		 */
		this.setCyphertext(cyphertext);
	}

}