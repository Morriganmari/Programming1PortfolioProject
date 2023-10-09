package programing1PortfolioProject;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;

/*
 * This class provides a simple way to interact with the Automobile Inventory 
 * application. It creates an instance of the AutomobileInventory class and 
 * calls its methods to list, add, remove, and update automobiles in the 
 * inventory. It also allows the user to save the vechicle inventory to a file.
 * 
 * @author Shayna Almond
 */
public class Main {

    public static void main(String[] args) {

        AutomobileInventory automobileInventory = new AutomobileInventory();

        System.out.println("Current Automobile Inventory: ");
        automobileInventory.listAutomobiles();

        System.out.println("Removing first vehicle...");
        System.out.println("Return value: " + automobileInventory.removeVehicle(automobileInventory.vehicles.get(0), "Nissan", "Rogue", "Blue", 2020, 36000));
        automobileInventory.listAutomobiles();

        System.out.println("Adding a new vehicle...");
        System.out.println("Return value " + automobileInventory.addVehicle("GMC", "Sierra", "Red", 2021, 35300));
        automobileInventory.listAutomobiles();

        System.out.println("Updating the vehicle attributes...");
        System.out.println("Return Value: " + automobileInventory.updateVehicle(automobileInventory.vehicles.get(1), "Toyota", "RAV4", "Tan", 2019, 43700));
        automobileInventory.listAutomobiles();

        System.out.println("Would you like to print the vehicle inventory to a file (Y or N)?");
        try (Scanner scanner = new Scanner(System.in)) {
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("Y")) {
                try {
                    FileWriter fw = new FileWriter("log.txt");
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    pw.println("Current Vehicle Inventory: ");
                    for (int i = 0; i < automobileInventory.vehicles.size(); i++) {
                        pw.println("car #" + (i + 1) + " Make: " + automobileInventory.vehicles.get(i).getMake());
                        pw.println("car #" + (i + 1) + " Model: " + automobileInventory.vehicles.get(i).getModel());
                        pw.println("car #" + (i + 1) + " Color: " + automobileInventory.vehicles.get(i).getColor());
                        pw.println("car #" + (i + 1) + " Year: " + automobileInventory.vehicles.get(i).getYear());
                        pw.println("car #" + (i + 1) + " Mileage: " + automobileInventory.vehicles.get(i).getMileage());
                        pw.println("********************");
                    }
                    pw.close();
                    System.out.println("Success! Data printed to file.");
                } catch (Exception e) {
                    System.out.println("Failure! Data not printed to file." + e.getMessage());
                }
            } else {
                System.out.println("Data was not printed to file.");
            }
        }
    }
}


