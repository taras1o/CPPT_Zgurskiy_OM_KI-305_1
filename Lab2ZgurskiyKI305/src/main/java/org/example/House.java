package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * The <code>House</code> class represents a house and its operations.
 * It includes functionality for managing the number of floors, addresses,
 * gardens, and provides information about the house.
 * This class also logs events to a file named "Log.txt".
 *
 * @version 1.0
 */
public class House {
    private FileWriter writer; // Field to store a reference to the file writing stream

    private String address;
    private int numberOfFloors;
    private boolean hasGarden;

    // Static variables for tracking parameters
    public static int param3 = 0;
    public static int param2 = 0;

    private static int countOfHousesWithAddress = 0;

    /**
     * Gets the count of houses with the address "Вулиця Лінкольна".
     *
     * @return The count of houses with the specified address.
     */
    public static int getCountOfHousesWithAddress() {
        return countOfHousesWithAddress;
    }
    /**
     * Default constructor for the house.
     */
    public House() {
        address = "No information";
        numberOfFloors = 0;
        hasGarden = false;
    }

    /**
     * Parameterized constructor for the house.
     *
     * @param address      Specifies initial address.
     * @param numberOfFloors The initial number of floors.
     * @param hasGarden    Specifies if the garden initially exists.
     */
    public House(String address, int numberOfFloors, boolean hasGarden) {
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.hasGarden = hasGarden;
        if ("Вулиця Лінкольна".equals(address)) {
            countOfHousesWithAddress++;
        }
    }

    /**
     * Constructs a house with the specified address and number of floors, defaulting to no garden.
     *
     * @param address      The address of the house.
     * @param numberOfFloors The number of floors in the house.
     */
    public House(String address, int numberOfFloors) {
        this(address, numberOfFloors, false);

    }

    /**
     * Constructs a house with the specified address and defaults to one floor and no garden.
     *
     * @param address The address of the house.
     */
    public House(String address) {
        this(address, 1);

    }

    // Methods

    /**
     * Open the file for writing.
     */
    public void openLogFile() {
        try {
            writer = new FileWriter("log.txt", true);
        } catch (IOException e) {
            System.err.println("Error opening the file for writing: " + e.getMessage());
        }
    }

    /**
     * Close the file after ending writing.
     */
    public void closeLogFile() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing the file: " + e.getMessage());
        }
    }

    /**
     * Display details of the house.
     */
    public void displayDetails() {
        System.out.println("House address: " + address);
        System.out.println("Number of floors: " + numberOfFloors);
        System.out.println("Has a garden: " + (hasGarden ? "Yes" : "No"));
    }

    /**
     * Log a message to the file.
     *
     * @param message The message to log.
     */
    private void logMessage(String message) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            LocalDateTime timestamp = LocalDateTime.now();
            writer.write("[" + timestamp + "] " + message + " - " + this + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    /**
     * Set the number of floors for the house.
     *
     * @param numberOfFloors The number of floors to set.
     */
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        logMessage("Set the number of floors to: " + numberOfFloors);
    }

    /**
     * Set the address for the house.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
        logMessage("Updated address: " + address);
    }

    /**
     * Set whether the house has a garden or not.
     *
     * @param hasGarden True if the house has a garden, false otherwise.
     */
    public void setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
        logMessage("Updated garden information.");
    }

    /**
     * Add a floor to the house.
     */
    public void addFloor() {
        numberOfFloors++;
        logMessage("Added a floor.");
    }

    /**
     * Remove a floor from the house.
     * If the number of floors is already at the minimum, log a message accordingly.
     */
    public void removeFloor() {
        if (numberOfFloors > 0) {
            numberOfFloors--;
            logMessage("Removed a floor.");
        } else {
            logMessage("Cannot remove a floor. The number of floors is already at the minimum.");
        }
    }

    /**
     * Get the number of floors for the house.
     *
     * @return The number of floors.
     */
    public int getNumberOfFloors() {
        logMessage("Retrieved information about the number of floors.");
        return numberOfFloors;
    }

    /**
     * Get the address of the house.
     *
     * @return The address.
     */
    public String getAddress() {
        logMessage("Retrieved information about the address.");
        return address;
    }

    /**
     * Check if the house has a garden.
     *
     * @return True if the house has a garden, false otherwise.
     */
    public boolean hasGarden() {
        logMessage("Retrieved information about the garden.");
        return hasGarden;
    }

    // Additional methods

}
