package org.example;

import java.io.*;
/**
 * Клас для обчислення виразу та збереження результату у файл.
 */
public class ExpressionCalculator {
    private double x;
    /**
     * Конструктор для створення об'єкта ExpressionCalculator зі значенням x.
     *
     * @param x Значення x, для якого буде обчислюватися вираз.
     */
    public ExpressionCalculator(double x) {
        this.x = x;
    }

    /**
     * Обчислює вираз y = tg(x) / ctg(x).
     *
     * @return Результат обчислення виразу.
     * @throws ArithmeticException Виникає, якщо виникає помилка при обчисленні виразу.
     */
    public double calculateExpression() throws ArithmeticException {
        double tanX = Math.tan(x);
        double cotanX = 1 / Math.tan(x);

        if (Double.isInfinite(tanX) || Double.isNaN(tanX) || Double.isInfinite(cotanX) || Double.isNaN(cotanX)) {
            throw new ArithmeticException("Вираз не визначений (tg(x) або ctg(x) мають недопустиме значення).");
        }

        if (Math.abs(cotanX) < 1e-6) {
            throw new ArithmeticException("Ділення на нуль у виразі (ctg(x) дуже мале).");
        }

        return tanX / cotanX;
    }

    /** в 5 створити бінарний файл із записаним туди числом, в 1 зчитати число з бінарного файла(яке є розміром матриці) і вивести результат в консоль
     * Метод для збереження результату обчислення у файл у текстовому і двійковому форматах.
     *
     * @param result      Результат обчислення виразу.
     * @param textFile    Ім'я файлу для текстового формату.
     * @param binaryFile  Ім'я файлу для двійкового формату.
     * @throws IOException Виникає, якщо сталася помилка при записі у файл.
     */
    public void saveResultToFile(double result, String textFile, String binaryFile) throws IOException {
        // Запис у текстовий файл
        try (PrintWriter textWriter = new PrintWriter(new FileWriter(textFile))) {
            textWriter.println("Результат обчислення виразу: " + result);
        }

        // Запис у двійковий файл
        try (DataOutputStream binaryWriter = new DataOutputStream(new FileOutputStream(binaryFile))) {
            binaryWriter.writeInt((int) x);
        }
    }
}