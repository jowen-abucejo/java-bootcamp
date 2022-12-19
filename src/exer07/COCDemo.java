package exer07;

import java.util.Scanner;

public class COCDemo {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Clan clan = new Clan("HashT5");

        int choice = 0;

        do {
            switch (choice = showMenu()) {
                case 1:
                    addBuilderMenu(clan);
                    break;
                case 2:
                    buildMenu(clan);
                    break;
                case 3:
                    viewClan(clan);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid answer.");
            }

        } while (choice != 0);

    }

    private static int showMenu() {
        System.out.println("=====================================");
        System.out.println(" COC DEMO ");
        System.out.println("=====================================");
        System.out.println("[1] Add Builder");
        System.out.println("[2] Build");
        System.out.println("[3] View Clan");
        System.out.println("[0] Exit");
        System.out.print("Choice [1-3]: ");
        int choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

    private static void addBuilderMenu(Clan clan) {

        System.out.println("=====================================");
        System.out.println(" > Add Builder ");
        System.out.println("=====================================");

        // item
        Builder builder = new Builder();
        if (!clan.addBuilder(builder)) {
            System.out.println("Cannot exceed max builders!");
            // System.exit(0);
        } else
            System.out.println("BUILDER:\n" + builder.toString());
    }

    private static void buildMenu(Clan clan) {
        String type;
        System.out.println("=====================================");
        System.out.println(" > Build ");
        System.out.println("=====================================");

        System.out.println("Building type:\n\t[1] Clan Castle");
        System.out.println("\t[2] Dark Barracks");
        System.out.println("\t[3] Wizard Tower");
        System.out.print("Choice [1-3]: ");
        int typeChoice = scan.nextInt();
        scan.nextLine();

        if (typeChoice == 1)
            type = "Clan Castle";
        else if (typeChoice == 2)
            type = "Dark Barracks";
        else
            type = "Wizard Tower";

        // item
        Building building = new Building(type);
        if (!clan.addBuilding(building)) {
            System.out.println("Not enough gems to build a " + building.getType() + "!");
            System.exit(0);
        } else {
            clan.setGems(building.getCost());
            clan.getBuildings().add(building);
        }
    }

    private static void viewClan(Clan clan) {
        System.out.println("CLAN:\n" + clan.toString());
    }

}
