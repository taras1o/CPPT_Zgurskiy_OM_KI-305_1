package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Клас Main для обчислення та запису результатів в файл з вхідного файлу.
 * @version 1.0
 */
public class Main {
    /**
     * Головний метод програми.
     *
     * @param args Масив аргументів командного рядка. В даному випадку не використовується.
     * @throws IOException Виникає, якщо сталася помилка при роботі з файлами.
     */
    public static void main(String[] args) throws IOException {
        // Ім'я вхідного та вихідного файлів
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        String outputBinaryFileName = "output";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line = reader.readLine();
            double x = Double.parseDouble(line);

            // Створення об'єкта калькулятора для обчислення виразу з параметром x
            ExpressionCalculator calculator = new ExpressionCalculator(x);

            try {
                // Обчислення виразу та збереження результату у вихідний файл
                double result = calculator.calculateExpression();
                calculator.saveResultToFile(result, outputFileName, outputBinaryFileName);
                System.out.println("Результат обчислення: " + result);
            } catch (ArithmeticException e) {
                System.err.println("Помилка обчислення: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Помилка при записі до файлу: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Помилка при читанні з файлу: " + e.getMessage());
        }
    }
}