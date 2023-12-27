package org.example;
/**
 * The Scissors class represents rubber item that implements the Item interface.
 * It has a name and a price    , and it can be used for reading.
 *
 * @version 1.0
 */
public class Rubber implements Item {
    private double price;
    private String name;


    /**
     * Constructs a new Rubber object with the specified name and price.
     *
     * @param name   The name of the rubber.
     * @param price The price of the rubber as a double value.
     */
    public Rubber(String name, double price) {
        this.name = name;
        this.price = price;
    }
    /**
     * Get the price of the rubber.
     *
     * @return The price of the rubber as a double value.
     */

    @Override
    public double getPrice() {
        return price;
    }
    /**
     * Use the rubber.
     */
    @Override
    public void use() {
        System.out.println("Using rubber " + name);
    }
    /**
     * Print information about the rubber.
     */
    @Override
    public void print() {
        System.out.println("Rubber: " + name + ", price: " + price);
    }
    /**
     * Compares this rubber's price to the price of another item that implements the Item interface.
     *
     * @param item The item to compare to.
     * @return A negative integer if this rubber is less expensive, a positive integer if
     *         it's more positive, or 0 if they have the same price.
     */
    @Override
    public int compareTo(Item item) {
        Double p = price;
        return p.compareTo(item.getPrice());

    }


}