package org.example;
import java.io.*;
import java.io.FileWriter;


/**
 * The {@code OfficeCenter} class represents an office center, which extends the {@code House}
 * abstract class and implements the {@code OfficeFunctionality} interface. It adds specific
 * functionality for an office center, including office space allocation and office equipment management.
 *
 *
 * @version 1.0
 */
public  class OfficeCenter extends House implements OfficeInterface, OfficeInterface2 {
    private int officeSpace;  // Represents the amount of office space in square meters
    private boolean hasMeetingRoom;
    private int numberOfDesks;
    private boolean hasProjector;
    private boolean hasWhiteboard;

    private static int countOfOfficeCentersWithFloorsMoreThan5 = 0;

    /**
     * Constructor for creating an OfficeCenter object with specified parameters.
     *
     * @param address The address of the office center.
     * @param numberOfFloors The number of floors in the office center.
     * @param officeSpace The amount of office space in square meters.
     * @param hasMeetingRoom Indicates whether the office center has a meeting room.
     * @param numberOfDesks The number of desks in the office center.
     * @param hasProjector Indicates whether the office center has a projector.
     * @param hasWhiteboard Indicates whether the office center has a whiteboard.
     */

    public OfficeCenter(String address, int numberOfFloors, int officeSpace,
                        boolean hasMeetingRoom, int numberOfDesks, boolean hasProjector, boolean hasWhiteboard) {
        super(address, numberOfFloors);
        this.officeSpace = officeSpace;
        this.hasMeetingRoom = hasMeetingRoom;
        this.numberOfDesks = numberOfDesks;
        this.hasProjector = hasProjector;
        this.hasWhiteboard = hasWhiteboard;

        if (numberOfFloors > 5) {
            countOfOfficeCentersWithFloorsMoreThan5++;
        }
    }

    public static int getCountOfOfficeCentersWithFloorsMoreThan5() {
        return countOfOfficeCentersWithFloorsMoreThan5;
    }
    // Getter and setter methods for the additional fields

    /**
     * Gets the office space in square meters.
     *
     * @return The office space in square meters.
     */
    public int getOfficeSpace() {
        return officeSpace;
    }
    /**
     * Sets the office space in square meters.
     *
     * @param officeSpace The office space to set in square meters.
     */
    public void setOfficeSpace(int officeSpace) {
        this.officeSpace = officeSpace;
    }


    /**
     * Allocates additional office space.
     *
     * @param squareMeters The additional office space to allocate in square meters.
     */
    public void allocateOfficeSpace(int squareMeters) {
        this.officeSpace += squareMeters;
    }

    /**
     * Equips the meeting room with a projector and/or whiteboard.
     *
     * @param projector Indicates whether to equip a projector.
     * @param whiteboard Indicates whether to equip a whiteboard.
     */
    public void equipMeetingRoom(boolean projector, boolean whiteboard) {
        this.hasMeetingRoom = true;
        this.hasProjector = projector;
        this.hasWhiteboard = whiteboard;
    }


    /**
     * Adds desks to the office center.
     *
     * @param desksToAdd The number of desks to add.
     */

    public void addDesks(int desksToAdd) {
        this.numberOfDesks += desksToAdd;
    }
    /**
     * Removes desks from the office center.
     *
     * @param desksToRemove The number of desks to remove.
     */
    public void removeDesks(int desksToRemove) {
        if (desksToRemove > this.numberOfDesks) {
            System.out.println("Cannot remove more desks than available.");
        } else {
            this.numberOfDesks -= desksToRemove;
        }
    }
    /**
     * Adds a projector to the office center.
     *
     * @param hasProjector Indicates whether to add a projector.
     */
    public void addProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
        // Additional logic related to adding a projector
    }

    public void addWhiteboard(boolean hasWhiteboard) {
        this.hasWhiteboard = hasWhiteboard;

    }

    public void addProjector2(boolean hasProjector){
        System.out.println("Projector was added");
        hasProjector = true;
    }

    @Override
    public void addWhiteboard2(boolean hasWhiteboard) {

    }

    public String writeAddressToFile() {
        String address = getAddress();

        try (FileWriter writer = new FileWriter("Address.txt")) {
            writer.write(address);
        } catch (IOException e) {
            System.err.println("Помилка при записі у файл: " + e.getMessage());
        }

        return address;
    }
    @Override
    public String toString() {
        return writeAddressToFile();
    }

}