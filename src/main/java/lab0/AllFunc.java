package lab0;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;


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
            //System.out.println("����� ����� �� ���� ���� ����.");
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
            //System.out.println("�������� ���� �������� � ���� " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            //System.err.println("������� ��� ����� � ������.");
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

    // 9
    public static int modifyNumber(int number) {
        if (number > 0) {
            return number + 1;
        } else if (number < 0) {
            return number - 2;
        } else {
            return 10;
        }
    }

    // 10
    public static long convertBytesToKilobytes(long bytes) {
        return bytes / 1024;
    }

    // 11
    public static int[][] createMatrix(int M, int N, int[] originalNumbers) {
        int[][] matrix = new int[M][N];

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                matrix[i][j] = originalNumbers[i];
            }
        }

        return matrix;
    }

    // 12
    public static int findMaxPerimeter(int[] perimeters) {
        int maxPerimeter = Integer.MIN_VALUE;

        for (int perimeter : perimeters) {
            if (perimeter > maxPerimeter) {
                maxPerimeter = perimeter;
            }
        }

        return maxPerimeter;
    }

    public static int calculatePerimeter(int length, int width) {
        return 2 * (length + width);
    }

    // 13
    public static int addElementToStack(Stack<Integer> stack, int D) {
        stack.push(D); // ������ ������� � ����
        return stack.size() - 1; // ����� ����� - 1 �� ������ �������
    }

    public static int getTopOfStack(Stack<Integer> stack) {
        return stack.isEmpty() ? -1 : stack.peek(); // ��������� -1, ���� ���� ��������
    }

    // 14
    public static double[] mean(double X, double Y) {
        double[] result = new double[2];
        if (X > 0 && Y > 0) {
            result[0] = (X + Y) / 2; // ������� �����������
            result[1] = Math.sqrt(X * Y); // ������� �����������
        } else {
            // System.out.println("X � Y ����� ���� ��������� �������.");
        }
        return result;
    }

    // 15
    public static double calculateAverage(double[] numbers) {
        double sum = 0.0;

        for (double number : numbers) {
            sum += number;
        }

        double average = sum / numbers.length;

        return average;
    }

    // 16
    public static char getPreviousChar(char C) {
        int charCode = (int) C;
        char prevChar = (char) (charCode - 1);
        return prevChar;
    }

    public static char getNextChar(char C) {
        int charCode = (int) C;
        char nextChar = (char) (charCode + 1);
        return nextChar;
    }
}
