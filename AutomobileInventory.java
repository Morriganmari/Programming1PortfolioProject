package programing1PortfolioProject;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class represents an inventory of automobiles. It allows users to store 
 * and manage vehicle information, such as make, model, color, year, and mileage. 
 * It also allows users to add, remove, and update vehicles and list all cars in 
 * the inventory.
 * 
 * @author Shayna Almond
 */
public class AutomobileInventory {

    ArrayList<Automobile> vehicles = new ArrayList<>();

    // Constructor
    public AutomobileInventory() {
        Automobile vehicle1 = new Automobile("Nissan", "Rogue", "Blue", 2020, 36000);
        Automobile vehicle2 = new Automobile("Buick", "Envista", "Black", 2022, 13500);
        Automobile vehicle3 = new Automobile("Toyota", "RAV4", "White", 2019, 43700);

        // Add objects to ArrayList
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
    }

    // Listing method that calls getter methods
    public void listAutomobiles() {
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println("Car #" + (i + 1) + " Make: " + vehicles.get(i).getMake());
            System.out.println("Car #" + (i + 1) + " Model: " + vehicles.get(i).getModel());
            System.out.println("Car #" + (i + 1) + " Color: " + vehicles.get(i).getColor());
            System.out.println("Car #" + (i + 1) + " Year: " + vehicles.get(i).getYear());
            System.out.println("Car #" + (i + 1) + " Mileage: " + vehicles.get(i).getMileage());
            System.out.println("-------------------------");
        }
    }

    // Method to add a car to the ArrayList and return a success or failure message
    public String addVehicle(String make, String model, String color, int year, int mileage) {
        try {
            if (make == null || model == null || color == null || year == 0 || mileage == 0) {
                throw new IllegalArgumentException("One or more of your entries was empty.");
            }

            Automobile vehicle = new Automobile(make, model, color, year, mileage);
            vehicles.add(vehicle);
            return "Success!";
        } catch (IllegalArgumentException e) {
            return "Failure: " + e.getMessage();
        }
    }

    // Method to remove a car from the ArrayList and return a success or failure message
    public String removeVehicle(Automobile automobile, String make, String model, String color, int year, int mileage) {
        try {
            int index = vehicles.indexOf(automobile);
            if (index == -1) {
                throw new NoSuchElementException("Sorry. The information you entered doesn't match any vehicle saved.");
            }

            vehicles.remove(index);
            return "Success!";
        } catch (Exception e) {
            return "Failure: " + e.getMessage();
        }
    }

    // Method to update a car's attributes and return a success or failure message
    public String updateVehicle(Automobile automobile, String make, String model, String color, int year, int mileage) {
        try {
            int index = vehicles.indexOf(automobile);
            if (index == -1) {
                throw new NoSuchElementException("Sorry. The information you entered doesn't match any vehicle saved.");
            }

            // Call setter methods 
            Automobile vehicle = vehicles.get(index);
            vehicle.setMake(make);
            vehicle.setModel(model);
            vehicle.setColor(color);
            vehicle.setYear(year);
            vehicle.setMileage(mileage);
            return "Success!";
        } catch (Exception e) {
            return "Failure: " + e.getMessage();
        }
    }
}

