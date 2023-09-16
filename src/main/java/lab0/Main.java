package lab0;

public class Main {
    public static void main(String[] args) {

        int[] progression1 = AllFunc.arithmeticProgression1(5, 2, 3);
        int[] progression2 = AllFunc.arithmeticProgression2(6, 4, 2);

        System.out.println("First method:");
        printArray(progression1);
        System.out.println("Second mathod:");
        printArray(progression2);

        System.out.println("///////////////////:");

        double area = AllFunc.calculateArea(5, 5);
        double perimeter = AllFunc.calculatePerimeter(3, 6);

        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);

        System.out.println("///////////////////:");
        int A = 3;
        boolean isEven = AllFunc.isEvenNumber(A);
        if (isEven) {
            System.out.println(A + " is Even numb.");
        } else {
            System.out.println(A + " not Even numb.");
        }
        System.out.println("///////////////////:");
        int monthNumber = 9;

        String season = AllFunc.getSeason(monthNumber);

        System.out.println("Month " + monthNumber + ": " + season);
        System.out.println("///////////////////:");
        double num1 = 5.0;
        double num2 = 3.0;

        double sumOfSquares = AllFunc.calculateSumOfSquares(num1, num2);
        double differenceOfSquares = AllFunc.calculateDifferenceOfSquares(num1, num2);
        double productOfSquares = AllFunc.calculateProductOfSquares(num1, num2);
        double quotientOfSquares = AllFunc.calculateQuotientOfSquares(num1, num2);

        System.out.println("sum of squares: " + sumOfSquares);
        System.out.println("difference of squares: " + differenceOfSquares);
        System.out.println("product of squares: " + productOfSquares);
        System.out.println("quotient of squares: " + quotientOfSquares);

        System.out.println("///////////////////");

        //AllFunc.generateProgressionFile("progression.txt", 3, 2); Завдання з файлами

        int A1 = 5;
        int B1 = 10;
        int[] numbers = AllFunc.getDescendingNumbersBetween(A1, B1);
        int count = numbers.length;
        System.out.println("Integers in descending order between " + A1 + " and " + B1 + ":");
        printArray(numbers);
        System.out.println("The total number of numbers in the range: " + count);

        System.out.println("///////////////////");
        int number = 5;
        int modifiedNumber = AllFunc.modifyNumber(number);
        System.out.println("Result: " + modifiedNumber);

        System.out.println("///////////////////");
        long fileSizeInBytes = 2048;
        long fileSizeInKilobytes = AllFunc.convertBytesToKilobytes(fileSizeInBytes);
        System.out.println("File size in kilobytes: " + fileSizeInKilobytes + " KB");

        System.out.println("///////////////////");
        int M = 3; // Кількість рядків
        int N = 4; // Кількість стовпців
        int[] originalNumbers = {1, 2, 3};

        int[][] matrix = AllFunc.createMatrix(M, N, originalNumbers);

        System.out.println("The resulting matrix:");

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("///////////////////");
        int N1 = 3; // Кількість прямокутників
        int[] lengths = {3, 5, 4}; // Довжини прямокутників
        int[] widths = {2, 7, 6}; // Ширини прямокутників

        int[] perimeters = new int[N1];

        for (int i = 0; i < N1; i++) {
            perimeters[i] = AllFunc.calculatePerimeter(lengths[i], widths[i]);
        }

        int maxPerimeter = AllFunc.findMaxPerimeter(perimeters);

        System.out.println("The maximum perimeter of a rectangle: " + maxPerimeter);
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.println(value);
        }
    }

    public static void printNumbersInReverseOrder(int[] numbers) {
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
    }
}
