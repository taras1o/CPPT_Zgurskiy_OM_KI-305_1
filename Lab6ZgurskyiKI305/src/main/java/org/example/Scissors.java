package org.example;
/**
 * The Scissors class represents scissors item that implements the Item interface.
 * It has a name and a price    , and it can be used for reading.
 *
 * @version 1.0
 */
public class Scissors implements Item  {
    private double price;
    private String name;
    /**
     * Constructs a new Scissors object with the specified name and price.
     *
     * @param name   The name of the scissors.
     * @param price The price of the scissors as a double value.
     */
    public Scissors(String name, double price) {
        this.name = name;
        this.price = price;
    }
    /**
     * Get the price of the scissors.
     *
     * @return The price of the scissors as a double value.
     */
    @Override
    public double getPrice() {
        return price;
    }
    /**
     * Use the scissors.
     */
    @Override
    public void use() {
        System.out.println("Using scissors " + name);
    }
    /**
     * Print information about the scissors.
     */
    @Override
    public void print() {
        System.out.println("Scissors: " + name + ", price: " + price);
    }
    /**
     * Compares this scissors' price to the price of another item that implements the Item interface.
     *
     * @param item The item to compare to.
     * @return A negative integer if this scissors is less expensive, a positive integer if
     *         it's more positive, or 0 if they have the same price.
     */
    @Override
    public int compareTo(Item item) {
        Double p = price;
        return p.compareTo(item.getPrice());
    }


}