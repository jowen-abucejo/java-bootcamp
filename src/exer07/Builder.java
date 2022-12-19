package exer07;

import java.util.Random;

/*
Item #1: Make this class implement the Runnable Interface
*/
public class Builder implements Runnable {
    private int id;
    private int strength;
    private Building currentBuilding;
    public static int builderPopulation;

    public Builder() {
        /*
         * Item #2: Initialize the attributes of a builder instance
         */
        Random rand = new Random();

        this.id = builderPopulation;
        this.strength = rand.nextInt(5, 15);
        this.currentBuilding = null;

        builderPopulation += 1;
    }

    /*
     * Item #3: Create a method build() that allows only one thread to invoke it
     * This method updates the building's currentBlocks by the strength of the
     * this
     * builder instance
     */
    public synchronized void build() {
        this.currentBuilding.setCurrentBlocks(this.strength);
    }

    public int getId() {
        return this.id;
    }

    public int getStrength() {
        return this.strength;
    }

    /*
     * Item #4: Enclose this code block in a method that will be executed when a
     * thread starts
     */
    @Override
    public void run() {

        Random rand = new Random();
        while (!this.currentBuilding.isCompleted()) {
            synchronized (Clan.class) {
                this.build();
                System.out.println("BUILDER:\n" + this.toString());
                System.out.println("BUILDING STATS:\n" + this.currentBuilding.toString());
            }

            try {
                Thread.sleep(rand.nextInt(5000) + 1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /*
     * Item #4
     */

    public void setCurrentBuilding(Building building) {
        if (this.currentBuilding == null || this.currentBuilding.isCompleted())
            this.currentBuilding = building;
    }

    public String toString() {
        return "{\n\t'id': " + this.id + "\n"
                + "\t'strength': " + this.strength + "\n}";
    }

}
