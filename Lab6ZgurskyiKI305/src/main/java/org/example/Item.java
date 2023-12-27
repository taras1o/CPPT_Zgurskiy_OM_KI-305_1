package org.example;
/**
 * The Item interface represents items that can be used and have price.
 * Classes that implement this interface should provide implementations
 * for the methods declared here.
 *
 * @version 1.0
 */
public interface Item extends Comparable<Item> {
    /**
     * Get the price of the item.
     *
     * @return The price of the item as a double value.
     */
    double getPrice();
    /**
     * Perform an action with the item.
     */
    void use();
    /**
     * Print information about the item.
     */
    void print();
}