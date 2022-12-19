package exer07;

import java.util.ArrayList;
import java.util.Iterator;

public class Clan {
    private String name;
    private int gems;
    private ArrayList<Builder> builders;
    private ArrayList<Building> buildings;
    private final static int MAX_BUILDERS = 5;

    public Clan(String name) {
        this.name = name;
        this.gems = 10;
        this.builders = new ArrayList<Builder>();
        this.buildings = new ArrayList<Building>();
    }

    /*
     * Item #5: Complete addBuilder method
     */
    public boolean addBuilder(Builder builder) {
        if (Builder.builderPopulation > MAX_BUILDERS)
            return false;

        this.gems += 10;
        return this.builders.add(builder);
    }

    public ArrayList<Builder> getBuilders() {
        return this.builders;
    }

    public ArrayList<Building> getBuildings() {
        return this.buildings;
    }

    public void setGems(int cost) {
        this.gems -= cost;
    }

    public boolean addBuilding(Building building) {
        if (this.gems >= building.getCost()) {
            Iterator<Builder> iter = this.builders.iterator();
            ArrayList<Thread> threads = new ArrayList<Thread>();

            /*
             * Item #6: Complete addBuilding method
             */
            while (iter.hasNext()) {
                Builder builder = iter.next();
                builder.setCurrentBuilding(building);

                try {
                    Thread buildThread = new Thread(builder);
                    threads.add(buildThread);
                    buildThread.start();
                    /**
                     * uncomment call of sleep() if printing of stats at Builder.run() method
                     * is not synchronized in Clan.class
                     */
                    // buildThread.sleep(2000);
                } catch (Exception ie) {
                    System.out.println(ie.getMessage());
                }
            }
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (Exception ie) {
                    System.out.println(ie.getMessage());
                }
            }
            return true;
        }
        return false;
    }

    public String toString() {
        String builders = "";
        String buildings = "";
        for (Builder builder : this.builders) {
            builders += "\t\t{\n\t\t\t'id': " + builder.getId() + "\n"
                    + "\t\t\t'strength': " + builder.getStrength() + "\n\t\t}, \n";
        }
        for (Building building : this.buildings) {
            buildings += "\t\t{\n\t\t\t'type': " + building.getType() + "\n"
                    + "\t\t\t'blocksNeeded': " + building.getBlocks() + "\n"
                    + "\t\t\t'currentBlocks': " + building.getCurrentBlocks() + "\n\t\t}, \n";
        }
        if (builders.length() > 0) {
            builders = builders.substring(0, builders.length() - 3);
        }
        if (buildings.length() > 0) {
            buildings = buildings.substring(0, buildings.length() - 3);
        }
        builders = "[\n" + builders + "\n\t]";
        buildings = "[\n" + buildings + "\n\t]";

        return "{"
                + "\n\t'name': '" + this.name + "',"
                + "\n\t'gems': '" + this.gems + "',"
                + "\n\t'builders': " + builders + ","
                + "\n\t'buildings': " + buildings + "\n}";
    }
}
