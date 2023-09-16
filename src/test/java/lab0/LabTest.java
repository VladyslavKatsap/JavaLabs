package lab0;

import static org.testng.Assert.*;

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
        // ���� ����� ���
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

        assertEquals(expected, result, 0.0001); // ������� ������� ��� ��������� ������� double
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
        // ���� �� ����� �����
        int evenNumber = 4;
        assertTrue(AllFunc.isEvenNumber(evenNumber));

        // ���� �� ������� �����
        int oddNumber = 7;
        assertFalse(AllFunc.isEvenNumber(oddNumber));
    }

    @Test
    public void testGetSeason() {
        // ���� �� ���� (�������)
        assertEquals("winter", AllFunc.getSeason(12));
        assertEquals("winter", AllFunc.getSeason(1));
        assertEquals("winter", AllFunc.getSeason(2));

        // ���� �� ����� (������)
        assertEquals("spring", AllFunc.getSeason(3));
        assertEquals("spring", AllFunc.getSeason(4));
        assertEquals("spring", AllFunc.getSeason(5));

        // ���� �� ��� (������)
        assertEquals("summer", AllFunc.getSeason(6));
        assertEquals("summer", AllFunc.getSeason(7));
        assertEquals("summer", AllFunc.getSeason(8));

        // ���� �� ���� (�������)
        assertEquals("autumn", AllFunc.getSeason(9));
        assertEquals("autumn", AllFunc.getSeason(10));
        assertEquals("autumn", AllFunc.getSeason(11));

        // ���� �� �������� �����
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

        // ���� �� �������, ���� num2 = 0
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

        // ��������� ����� ��� ��������� �����
        AllFunc.generateProgressionFile(fileName, A, D);

        // ����������, �� ���� ����
        assertTrue(Files.exists(Paths.get(fileName)));

        // ����������, �� ���� ����� ������� �������
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
}