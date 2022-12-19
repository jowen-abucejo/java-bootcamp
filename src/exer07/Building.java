package exer07;

import java.util.Random;

public class Building {
    private int blocksNeeded;
    private int currentBlocks;
    private String type;

    private final static int BARRACKS_COST = 10;
    private final static int CLANCASTLE_COST = 20;
    private final static int WIZARDTOWER_COST = 15;

    public Building(String type) {
        Random rand = new Random();
        this.blocksNeeded = rand.nextInt(10, 40) + 10;
        this.type = type;
        this.currentBlocks = 0;
    }

    public int getBlocks() {
        return this.blocksNeeded;
    }

    public int getCurrentBlocks() {
        return this.currentBlocks;
    }

    public String getType() {
        return this.type;
    }

    public void setCurrentBlocks(int blocks) {
        if (this.currentBlocks + blocks <= this.blocksNeeded)
            this.currentBlocks += blocks;
        else
            this.currentBlocks = blocksNeeded;
    }

    public boolean isCompleted() {
        return this.getCurrentBlocks() >= this.getBlocks();
    }

    public int getCost() {
        if (this.type == "Clan Castle")
            return CLANCASTLE_COST;
        else if (this.type == "Dark Barracks")
            return BARRACKS_COST;
        else
            return WIZARDTOWER_COST;
    }

    public String toString() {
        return "{\n\t'type': " + this.type + "\n"
                + "\t'blocksNeeded': " + this.blocksNeeded + "\n"
                + "\t'currentBlocks': " + this.currentBlocks + "\n}";
    }
}
