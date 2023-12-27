package org.example;

import java.io.*;
import java.util.*;


public class Lab1ZgurskyiKI305 {

    public static void main(String[] args) throws FileNotFoundException {

            String inputBinaryFilePath = "D:/kzplabs/Lab5ZgurskyiKI305/output";

        // Читання значення з бінарного файлу, створеного в 5-й лабораторній роботі
        try (DataInputStream binaryReader = new DataInputStream(new FileInputStream(inputBinaryFilePath))) {
            // Зчитування числа з бінарного файлу
            int nRows = binaryReader.readInt();
            System.out.println("Розмір квадратної матриці: " + nRows);


            Scanner in = new Scanner(System.in);

            System.out.print("Введіть символ-заповнювач: ");
            in.nextLine();
            String filler = in.nextLine();
            if (filler.length() != 1) {
                System.out.print("\nСимвол-заповнювач введено невірно.");
                System.exit(0);
            }
            char[][] arr = new char[nRows][];

            PrintWriter wFile = new PrintWriter("MyFile.txt");

            for (int I = 0; I < nRows; I++) {
                for (int K = nRows - 1; K > I; K--) {
                    System.out.print("\t");
                    wFile.write("\t");
                }

                arr[I] = new char[I + 1];
                for (int J = 0; J <= I; J++) {

                    arr[I][J] = (char) filler.codePointAt(0);
                    if (J == I) {
                        arr[I][J] = '1';
                    }
                    System.out.print(arr[I][J] + "\t");
                    wFile.write(arr[I][J] + "\t");

                }
                System.out.print("\n");
                wFile.print("\n");

            }


        wFile.close();
        in.close();
        }catch (IOException e) {
            System.err.println("Помилка при читанні з бінарного файлу: " + e.getMessage());
        }
    }
}