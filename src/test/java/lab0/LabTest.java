package lab0;

import static org.testng.Assert.*;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class LabTest {
    @Test
    public void testArithmeticProgression1() {
        int N = 5;
        int A = 1;
        int D = 2;

        int[] expected = {1, 3, 5, 7, 9};

        int[] result = AllFunc.arithmeticProgression1(N, A, D);
        assertEquals(expected, result);
    }

    @Test
    public void testArithmeticProgression2() {
        // Ваші вхідні дані
        int N = 5;
        int A = 1;
        int D = 2;

        int[] expected = {1, 5, 9, 13, 17};

        int[] result = AllFunc.arithmeticProgression2(N, A, D);

        assertEquals(expected, result);
    }

    @Test
    public void testCalculateArea() {
        double a = 5.0;
        double b = 3.0;

        double expected = 15.0;

        double result = AllFunc.calculateArea(a, b);

        assertEquals(expected, result, 0.0001); // Вказуємо точність для порівняння значень double
    }

    @Test
    public void testCalculatePerimeter() {
        double a = 5.0;
        double b = 3.0;

        double expected = 16.0;

        double result = AllFunc.calculatePerimeter(a, b);

        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testIsEvenNumber() {
        // Тест на парне число
        int evenNumber = 4;
        assertTrue(AllFunc.isEvenNumber(evenNumber));

        // Тест на непарне число
        int oddNumber = 7;
        assertFalse(AllFunc.isEvenNumber(oddNumber));
    }

    @Test
    public void testGetSeason() {
        // Тест на зиму (грудень)
        assertEquals("winter", AllFunc.getSeason(12));
        assertEquals("winter", AllFunc.getSeason(1));
        assertEquals("winter", AllFunc.getSeason(2));

        // Тест на весну (квітень)
        assertEquals("spring", AllFunc.getSeason(3));
        assertEquals("spring", AllFunc.getSeason(4));
        assertEquals("spring", AllFunc.getSeason(5));

        // Тест на літо (липень)
        assertEquals("summer", AllFunc.getSeason(6));
        assertEquals("summer", AllFunc.getSeason(7));
        assertEquals("summer", AllFunc.getSeason(8));

        // Тест на осінь (жовтень)
        assertEquals("autumn", AllFunc.getSeason(9));
        assertEquals("autumn", AllFunc.getSeason(10));
        assertEquals("autumn", AllFunc.getSeason(11));

        // Тест на невідомий місяць
        assertEquals("unknown month", AllFunc.getSeason(13));
    }

    @Test
    public void testCalculateSumOfSquares() {
        double num1 = 3.0;
        double num2 = 4.0;

        double expected = 3.0 * 3.0 + 4.0 * 4.0;

        double result = AllFunc.calculateSumOfSquares(num1, num2);

        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculateDifferenceOfSquares() {
        double num1 = 5.0;
        double num2 = 3.0;

        double expected = 5.0 * 5.0 - 3.0 * 3.0;

        double result = AllFunc.calculateDifferenceOfSquares(num1, num2);

        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculateProductOfSquares() {
        double num1 = 3.0;
        double num2 = 4.0;

        double expected = 3.0 * 3.0 * 4.0 * 4.0;

        double result = AllFunc.calculateProductOfSquares(num1, num2);

        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculateQuotientOfSquares() {
        double num1 = 4.0;
        double num2 = 2.0;

        double expected = (4.0 * 4.0) / (2.0 * 2.0);

        double result = AllFunc.calculateQuotientOfSquares(num1, num2);

        assertEquals(expected, result, 0.0001);

        // Тест на випадок, коли num2 = 0
        num2 = 0.0;

        double expectedNaN = Double.NaN;

        double resultNaN = AllFunc.calculateQuotientOfSquares(num1, num2);

        assertTrue(Double.isNaN(resultNaN));
    }

    @Test
    public void testGenerateProgressionFile() {
        String fileName = "test_progression.txt";
        double A = 1.0;
        double D = 2.0;

        // Викликаємо метод для створення файлу
        AllFunc.generateProgressionFile(fileName, A, D);

        // Перевіряємо, чи файл існує
        assertTrue(Files.exists(Paths.get(fileName)));

        // Перевіряємо, чи вміст файлу відповідає прогресії
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            for (int i = 0; i < 10; i++) {
                double term = A + i * D;
                String line = reader.readLine();
                double value = Double.parseDouble(line);
                assertTrue(Math.abs(term - value) < 0.0001);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDescendingNumbersBetween() {
        int A = 5;
        int B = 10;

        int[] expected = {9, 8, 7, 6};

        int[] result = AllFunc.getDescendingNumbersBetween(A, B);
        assertEquals(expected, result);
    }

    @Test
    public void testModifyNumber() {
        int positiveNumber = 5;
        int expectedPositive = positiveNumber + 1;
        assertEquals(expectedPositive, AllFunc.modifyNumber(positiveNumber));

        int negativeNumber = -5;
        int expectedNegative = negativeNumber - 2;
        assertEquals(expectedNegative, AllFunc.modifyNumber(negativeNumber));

        int zeroNumber = 0;
        int expectedZero = 10;
        assertEquals(expectedZero, AllFunc.modifyNumber(zeroNumber));
    }

    @Test
    public void testConvertBytesToKilobytes() {
        long bytes = 1024 * 5; // 5 кілобайт в байтах

        long expectedKilobytes = 5;

        long resultKilobytes = AllFunc.convertBytesToKilobytes(bytes);

        assertEquals(expectedKilobytes, resultKilobytes);
    }

    @Test
    public void testCreateMatrix() {
        int M = 3;
        int N = 4;
        int[] originalNumbers = {1, 2, 3};

        int[][] expectedMatrix = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3}
        };

        int[][] resultMatrix = AllFunc.createMatrix(M, N, originalNumbers);

        assertEquals(expectedMatrix, resultMatrix);
    }

    @Test
    public void testFindMaxPerimeter() {
        int[] perimeters = {10, 20, 15, 25, 30};

        int expectedMaxPerimeter = 30;

        int resultMaxPerimeter = AllFunc.findMaxPerimeter(perimeters);

        assertEquals(expectedMaxPerimeter, resultMaxPerimeter);
    }

    @Test
    public void testCalculatePerimeter2() {
        int length = 5;
        int width = 10;

        int expectedPerimeter = 2 * (length + width);

        int resultPerimeter = AllFunc.calculatePerimeter(length, width);

        assertEquals(expectedPerimeter, resultPerimeter);
    }

    @Test
    public void testAddElementToStackAndGetTopOfStack() {
        Stack<Integer> stack = new Stack<>();

        // Додаємо елемент в стек і отримуємо індекс вершини
        int index1 = AllFunc.addElementToStack(stack, 5);
        int index2 = AllFunc.addElementToStack(stack, 10);
        int index3 = AllFunc.addElementToStack(stack, 15);

        // Перевіряємо індекси вершини стеку
        assertEquals(0, index1); // 0-індексація
        assertEquals(1, index2); // 0-індексація
        assertEquals(2, index3); // 0-індексація

        // Перевіряємо вершину стеку
        assertEquals(15, AllFunc.getTopOfStack(stack));

        // Видаляємо елемент і перевіряємо вершину стеку
        stack.pop();
        assertEquals(10, AllFunc.getTopOfStack(stack));
    }
    @Test
    public void testMean() {
        double X = 4.0;
        double Y = 9.0;

        double expectedArithmetic = (X + Y) / 2;
        double expectedGeometric = Math.sqrt(X * Y);

        double[] result = AllFunc.mean(X, Y);

        assertEquals(new double[]{expectedArithmetic, expectedGeometric}, result, 0.0001);
    }

    @Test
    public void testCalculateAverage() {
        double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};

        double expectedAverage = (1.0 + 2.0 + 3.0 + 4.0 + 5.0) / 5;

        double resultAverage = AllFunc.calculateAverage(numbers);

        assertEquals(expectedAverage, resultAverage, 0.0001);
    }

    @Test
    public void testGetPreviousChar() {
        char inputChar = 'B';

        char expectedPreviousChar = 'A';

        char resultPreviousChar = AllFunc.getPreviousChar(inputChar);

        assertEquals(expectedPreviousChar, resultPreviousChar);
    }

    @Test
    public void testGetNextChar() {
        char inputChar = 'X';

        char expectedNextChar = 'Y';

        char resultNextChar = AllFunc.getNextChar(inputChar);

        assertEquals(expectedNextChar, resultNextChar);
    }
}