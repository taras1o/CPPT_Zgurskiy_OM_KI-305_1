package org.example;

public class HouseDrive {
    public static void main(String[] args) {
        // Call the main1 method to execute the first part of the program
        main1();

        // Create objects of the House class
        House house1 = new House("Вулиця Лінкольна", 3, true);
        House house2 = new House("Вулиця Лінкольна");
        House house3 = new House("Вулиця Лінкольна");
        House house4 = new House("Вулиця Лінкольна");

        // Display the count of houses with the address "Вулиця Лінкольна"
        System.out.print(House.getCountOfHousesWithAddress());

        // Uncomment the following lines when the respective methods are uncommented in the House class

        /*
        // house1.openLogFile();
        // house2.openLogFile();
        // house3.openLogFile();

        // house1.displayDetails();
        // house2.displayDetails();
        // house3.displayDetails();

        // house1.setAddress("Вулиця Нова, 555");
        // house1.setNumberOfFloors(4);
        // house1.addFloor();
        // house1.setHasGarden(false);
        // house1.removeFloor();

        // house2.setNumberOfFloors(6);
        // house2.addFloor();
        // house2.setHasGarden(true);
        // house2.removeFloor();

        // house3.setHasGarden(true);
        // house3.addFloor();

        // house1.displayDetails();
        // house2.displayDetails();
        // house3.displayDetails();

        // house1.closeLogFile();
        // house2.closeLogFile();
        // house3.closeLogFile();*/
    }

    /**
     * The main1 method creates additional House objects for testing purposes.
     *
     * @return
     */
    public static void main1() {
        House house1 = new House("Вулиця Лінкольна", 3, true);
        House house3 = new House("Вулиця Лінкольна", 3, true);
        House house2 = new House("Вулиця Індепенденс, 456");
    }


    /**
     * Count the number of houses with a specific address.
     *
     * @param targetAddress The address to search for.
     * @param houses The House objects to search through.
     * @return The count of houses with the specified address.
     */
    public static int countHousesWithAddress(String targetAddress, House... houses) {
        int count = 0;
        for (House house : houses) {
            if (house.getAddress().equals(targetAddress)) {
                count++;
            }
        }
        return count;
    }
}