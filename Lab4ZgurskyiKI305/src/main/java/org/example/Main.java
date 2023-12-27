package org.example;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Головний клас програми для обчислення виразу та збереження результату у файл.
 *
 *
 * @since 1.0
 */


public class Main {
    /**
     * Точка входу в програму.
     *
     * @param args Масив аргументів командного рядка.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть значення x: ");


        try {
            double x = scanner.nextDouble();
            ExpressionCalculator calculator = new ExpressionCalculator(x);
            double result = calculator.calculateExpression();
            calculator.saveResultToFile(result);
            System.out.println("Результат обчислення: " + result);
        } catch (ArithmeticException | InputMismatchException e) {
            System.err.println("Помилка обчислення: " + e.getMessage());
        }
    }
}