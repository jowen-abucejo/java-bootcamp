package exer06;

/* (ITEM #4) import necessary classes
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import exer06.model.Food;

public class Refrigerator {
	private HashMap<String, ArrayList<Food>> foodMap;

	public Refrigerator() {
		/*
		 * (ITEM #5) initialize the foodMap for the refrigerator instance
		 */
		this.foodMap = new HashMap<>();
	}

	public void add(Food food) {
		System.out.println(food.getInfo());

		/*
		 * (ITEM #6) implement the method add(Food)
		 * this adds the food item to the foodMap
		 */
		ArrayList<Food> foodList = this.foodMap.getOrDefault(food.getType(), new ArrayList<Food>());
		foodList.add(food);
		this.foodMap.put(food.getType(), foodList);
	}

	public void listRefContents() {
		/*
		 * (ITEM #7) implement the method listRefContents()
		 * print the names of all the food in the refrigerator
		 */
		Set<String> foodTypes = this.foodMap.keySet();
		Iterator<String> typeIterator = foodTypes.iterator();
		while (typeIterator.hasNext()) {
			listRefContents(typeIterator.next());
		}
	}

	public void listRefContents(String type) {
		/*
		 * (ITEM #8) implement the method listRefContents(String)
		 * print the names of all the food in the refrigerator
		 * based on the type passed
		 */
		ArrayList<Food> foodList = this.foodMap.get(type);
		if (foodList == null)
			return;
		for (Food food : foodList) {
			System.out.println(food.getName());
		}
	}

	public int getFoodCount() {
		/*
		 * (ITEM #9) implement the method getFoodCount()
		 * returns the total number of food items in the refrigerator
		 */
		Set<String> foodTypes = this.foodMap.keySet();
		Iterator<String> typeIterator = foodTypes.iterator();
		int totalFoodCount = 0;
		while (typeIterator.hasNext()) {
			totalFoodCount += getFoodCount(typeIterator.next());
		}

		return totalFoodCount;
	}

	public int getFoodCount(String type) {
		/*
		 * (ITEM #10) implement the method getFoodCount()
		 * returns the total number of food items in the refrigerator
		 * based on the type passed
		 */
		ArrayList<Food> foodList = this.foodMap.get(type);

		if (foodList == null)
			return 0;

		return foodList.size();
	}
}
