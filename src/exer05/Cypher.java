package exer05;

/*
	Item #1: Make Cypher class an abstract class.
*/

public abstract class Cypher {

	protected int offset;
	private String cyphertext;

	// default constructor required for Item#4
	public Cypher() {

	}

	public Cypher(int offset) {
		this.offset = offset;
		this.cyphertext = null;
	}

	/*
	 * Item #2: Create an abstract method encrypt() which requires the plaintext to
	 * be encrypted.
	 */
	public abstract void encrypt(String plaintext);

	protected int getOffset() {
		return this.offset;
	}

	public void setCyphertext(String cyphertext) {
		this.cyphertext = cyphertext;
	}

	/*
	 * Item #7: Make getLastCypherText() into a final method.
	 */
	public final String getLastCyphertext() {
		return this.cyphertext;
	}

}