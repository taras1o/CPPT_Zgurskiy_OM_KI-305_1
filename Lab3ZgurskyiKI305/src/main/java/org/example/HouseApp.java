package org.example;

/**
 * The {@code HouseDriver} class provides a simple driver program to test the House and OfficeCenter classes.
 *
 * @version 1.0
 */
public class HouseApp {
    public static void main(String[] args) {
        // Create an office center
        OfficeCenter officeCenter = new OfficeCenter("789 Oak St.", 5, 500,
                true, 50, true, true);

        // Display office center details
        officeCenter.displayDetails();

        // Update office center details
        officeCenter.setNumberOfFloors(6);
        officeCenter.setAddress("101 Pine St.");
        officeCenter.setOfficeSpace(600);
        officeCenter.equipMeetingRoom(false, true);
        officeCenter.addDesks(10);

        // Display updated office center details
        officeCenter.displayDetails();

        officeCenter.toString();
        main1();

        System.out.println("Кількість офіс центрів з більше 5 поверхами: " +
                OfficeCenter.getCountOfOfficeCentersWithFloorsMoreThan5());


    }
    public static void main1() {
        // Create an office center
        OfficeCenter officeCenter = new OfficeCenter("789 Oak St.", 6, 500,
                true, 50, true, true);
    }
}