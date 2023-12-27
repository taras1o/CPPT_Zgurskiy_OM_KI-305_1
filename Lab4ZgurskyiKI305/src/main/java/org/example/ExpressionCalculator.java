package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Клас ExpressionCalculator виконує обчислення виразу та запис результатів у файл.
 * Вираз: y = tg(x) / ctg(x)
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
    public double calculateExpression() throws ArithmeticException, NewException {
        double tanX = Math.tan(x);
        double cotanX = 1 / Math.tan(x);
        if(x>20){
            throw new NewException("Значення більше за 20");
        }

        if (Double.isInfinite(tanX) || Double.isNaN(tanX) || Double.isInfinite(cotanX) || Double.isNaN(cotanX)) {
            throw new ArithmeticException("Вираз не визначений (tg(x) або ctg(x) мають недопустиме значення).");
        }

        if (Math.abs(cotanX) < 1e-6) {
            throw new ArithmeticException("Ділення на нуль у виразі (ctg(x) дуже мале).");
        }

        return tanX / cotanX;
    }

    /**
     * Записує результат обчислення виразу у файл "result.txt".
     *
     * @param result Результат обчислення виразу.
     * @throws IOException Виникає, якщо виникає помилка при записі у файл.
     */
    public void saveResultToFile(double result) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("result.txt"))) {
            writer.println("Результат обчислення виразу: " + result);
        }
    }
}