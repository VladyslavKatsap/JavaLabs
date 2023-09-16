package lab0;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AllFunc {
    //1
    public static int[] arithmeticProgression1(int N, int A, int D) {
        int[] progression = new int[N];
        for (int i = 0; i < N; i++) {
            progression[i] = A + i * D;
        }
        return progression;
    }

    //2
    public static int[] arithmeticProgression2(int N, int A, int D) {
        int[] progression = new int[N];
        for (int i = 0; i < N; i++) {
            progression[i] = A + i * 2 * D;
        }
        return progression;
    }

    //3
    public static double calculateArea(double a, double b) {
        return a * b;
    }

    public static double calculatePerimeter(double a, double b) {
        return 2 * (a + b);
    }

    //4
    public static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    //5
    public static String getSeason(int month) {
        String season;
        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "winter";
                break;
            case 3:
            case 4:
            case 5:
                season = "spring";
                break;
            case 6:
            case 7:
            case 8:
                season = "summer";
                break;
            case 9:
            case 10:
            case 11:
                season = "autumn";
                break;
            default:
                season = "unknown month";
                break;
        }
        return season;
    }

    //6
    public static double calculateSumOfSquares(double num1, double num2) {
        return num1 * num1 + num2 * num2;
    }

    public static double calculateDifferenceOfSquares(double num1, double num2) {
        return num1 * num1 - num2 * num2;
    }

    public static double calculateProductOfSquares(double num1, double num2) {
        return num1 * num1 * num2 * num2;
    }

    public static double calculateQuotientOfSquares(double num1, double num2) {
        if (num2 != 0) {
            return (num1 * num1) / (num2 * num2);
        } else {
            //System.out.println("Друге число не може бути нуль.");
            return Double.NaN;
        }
    }

    //7
    public static void generateProgressionFile(String fileName, double A, double D) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < 10; i++) {
                double term = A + i * D;
                printWriter.println(term);
            }

            printWriter.close();
            //System.out.println("Прогресія була записана в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            //System.err.println("Помилка при роботі з файлом.");
        }
    }

    // 8
    public static int[] getDescendingNumbersBetween(int A, int B) {
        int count = B - A - 1;
        int[] numbers = new int[count];
        int index = 0;

        for (int i = B - 1; i > A; i--) {
            numbers[index] = i;
            index++;
        }

        return numbers;
    }

}
