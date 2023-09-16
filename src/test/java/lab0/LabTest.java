package lab0;

import static org.testng.Assert.*;

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
}