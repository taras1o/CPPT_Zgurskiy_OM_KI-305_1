package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * The <code>House</code> class represents a house and its operations.
 * It includes functionality for managing the number of floors, addresses,
 * gardens and gives information about house .
 * This class also logs events to a file named "Log.txt".
 *
 *
 * @version 1.0
 */

public abstract  class House extends Object {
    private FileWriter writer; // Поле для зберігання посилання на потік запису в файл

    private String address;
    private int numberOfFloors;
    private boolean hasGarden;

    /**
     * Default constructor for the house.
     *
     */
    // Конструктори
    public House(){
        address = "No information";
        numberOfFloors = 0;
        hasGarden = false;

    }

    /**
     * Parameterized constructor for the house.
     *
     * @param address Specifies initial address.
     * @param numberOfFloors The initial number of floors.
     * @param hasGarden Specifies if the garden initially exists.
     */
    public House(String address, int numberOfFloors, boolean hasGarden) {
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.hasGarden = hasGarden;
    }
    /**
     * Constructs a house with the specified address and number of floors, defaulting to no garden.
     *
     * @param address The address of the house.
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

    // Методи

    // Метод для відкриття файлу для запису
    /**
     * Open the file for writing
     */
    public void openLogFile() {
        try {
            writer = new FileWriter("log.txt", true);
        } catch (IOException e) {
            System.err.println("Помилка при відкритті файлу для запису: " + e.getMessage());
        }
    }

    // Метод для закриття файлу після закінчення запису

    /**
     * Close the file after ending of writing
     */
    public void closeLogFile() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Помилка при закритті файлу: " + e.getMessage());
        }
    }

    /**
     * Display details of the house
     */
    public void displayDetails() {
        System.out.println("Адреса будинку: " + address);
        System.out.println("Кількість поверхів: " + numberOfFloors);
        System.out.println("Наявність саду: " + (hasGarden ? "Так" : "Ні"));
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
            System.err.println("Помилка при записі до файлу: " + e.getMessage());
        }
    }
    /**
     * Set the number of floors for the house.
     *
     * @param numberOfFloors The number of floors to set.
     */
    public void setNumberOfFloors(int numberOfFloors) {

        this.numberOfFloors = numberOfFloors;
        logMessage("Встановлено кількість поверхів: " + numberOfFloors);
    }
    /**
     * Set the address for the house.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
        logMessage("Оновлено адресу: " + address);
    }
    /**
     * Set whether the house has a garden or not.
     *
     * @param hasGarden True if the house has a garden, false otherwise.
     */
    public void setHasGarden(boolean hasGarden) {

        this.hasGarden = hasGarden;
        logMessage("Оновлено інформацію про сад.");
    }
    /**
     * Add a floor to the house.
     */
    public void addFloor() {

        numberOfFloors++;
        logMessage("Додано поверх.");
    }
    /**
     * Remove a floor from the house.
     * If the number of floors is already at the minimum, log a message accordingly.
     */
    public void removeFloor() {
        if (numberOfFloors > 0) {
            numberOfFloors--;
            logMessage("Видалено поверх.");
        } else {
            logMessage("Не можна видалити поверх. Кількість поверхів вже мінімальна.");
        }
    }
    /**
     * Get the number of floors for the house.
     *
     * @return The number of floors.
     */
    public int getNumberOfFloors() {
        logMessage("Дана інформація про кількість поверхів.");
        return numberOfFloors;

    }
    /**
     * Get the address of the house.
     *
     * @return The address.
     */
    public String getAddress() {

        return address;
    }
    /**
     * Check if the house has a garden.
     *
     * @return True if the house has a garden, false otherwise.
     */
    public boolean hasGarden() {
        logMessage("Дана інформація про наявність саду.");
        return hasGarden;
    }

    // Додаткові методи


}
