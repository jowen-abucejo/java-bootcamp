package lecture;

class Human {
	String name;
	int joy;
	int anger;
	int sadness;
	static int population = 0;

	public Human(String name) {
		this.name = name;
		this.joy = 10;
		this.anger = 0;
		this.sadness = 0;
	}

	void befriend(Human friend) {
		if (friend != this) {
			this.joy += 10;
			friend.joy += 10;
		}
	}

	void eat() {
		this.sadness -= 3;
	}

	void argue(Human human) {
		if (human != this) {
			this.sadness += 5;
			human.anger += 10;
		}
	}

}
