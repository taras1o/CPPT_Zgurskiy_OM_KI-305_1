package org.example;

import java.util.ArrayList;
/**
 * The Penal class represents a container for items of a specific type that implement the Item interface.
 * It allows adding, retrieving, finding the maximum-price item, and using items.
 *
 * @param <T> The type of items that can be stored in the penal, which must implement the Item interface.
 *
 * @version 1.0
 */
public class Penal<T extends Item> {
    private ArrayList<T> array;
    /**
     * Constructs a new Penal object.
     * Initializes an empty array to store items.
     */
    public Penal() {
        array = new ArrayList<T>();
    }
    /**
     * Adds an item to the penal and prints a message indicating the addition.
     *
     * @param item The item to add to the penal.
     */
    public void putItem(T item) {
        array.add(item);
        System.out.print("Item added: ");
        item.print();
    }
    /**
     * Retrieves an item from the penal by its index.
     *
     * @param i The index of the item to retrieve.
     * @return The item at the specified index, or null if the index is out of bounds.
     */

    public T getItem(int i) {
        return array.get(i);
    }
    /**
     * Finds and returns the item with the maximum price in the penal.
     *
     * @return The item with the maximum price, or null if the penal is empty.
     */
    public T getMax() {
        if (!array.isEmpty()) {
            T max = array.get(0);
            for (int i = 1; i < array.size(); i++) {
                if (array.get(i).compareTo(max) > 0) {
                    max = array.get(i);
                }
            }
            return max;
        }
        return null;
    }
    /**
     * Uses an item in the penal by its index.
     *
     * @param i The index of the item to use.
     */
    public void useItem(int i) {
        array.get(i).use();
    }

    public void printTotalPrice() {
        double totalPrice = 0.0;
        for (T item : array) {
            totalPrice += item.getPrice();
        }
        System.out.println("Total price of all items in the penal: " + totalPrice);
    }
}