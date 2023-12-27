package org.example;

public class Main {

    public static void main(String[] args) {
        Penal <? super Item> penal = new Penal<>();
        penal.putItem(new Rubber("Rubber1", 10.50));
        penal.putItem(new Scissors("Scissors1" , 55.75));
        penal.putItem(new Rubber("Rubber2" , 15.25));
        penal.putItem(new Scissors("Scissors2" , 100));

        penal.printTotalPrice();
    }
}