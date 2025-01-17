package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        assertEquals(5, Calculator.add(2, 3), "Addition of 2 and 3 should be 5");
        assertEquals(-1, Calculator.add(2, -3), "Addition of 2 and -3 should be -1");
        assertEquals(0, Calculator.add(0, 0), "Addition of 0 and 0 should be 0");
    }

    @Test
    void subtract() {
        assertEquals(1, Calculator.subtract(3, 2), "Subtraction of 3 and 2 should be 1");
        assertEquals(5, Calculator.subtract(2, -3), "Subtraction of 2 and -3 should be 5");
        assertEquals(0, Calculator.subtract(0, 0), "Subtraction of 0 and 0 should be 0");
    }

    @Test
    void multiply() {
        assertEquals(6, Calculator.multiply(2, 3), "Multiplication of 2 and 3 should be 6");
        assertEquals(-6, Calculator.multiply(2, -3), "Multiplication of 2 and -3 should be -6");
        assertEquals(0, Calculator.multiply(2, 0), "Multiplication of 2 and 0 should be 0");
    }

    @Test
    void divide() {
        assertEquals(2, Calculator.divide(6, 3), "Division of 6 by 3 should be 2");
        assertEquals(-2, Calculator.divide(6, -3), "Division of 6 by -3 should be -2");
        assertThrows(ArithmeticException.class, () -> Calculator.divide(6, 0), "Division by 0 should throw ArithmeticException");
    }


    @Test
    void performOperation() {
        assertEquals(5, Calculator.performOperation(2, 3, '+'), "2 + 3 should be 5");
        assertEquals(1, Calculator.performOperation(3, 2, '-'), "3 - 2 should be 1");
        assertEquals(6, Calculator.performOperation(2, 3, '*'), "2 * 3 should be 6");
        assertEquals(2, Calculator.performOperation(6, 3, '/'), "6 / 3 should be 2");
        assertThrows(ArithmeticException.class, () -> Calculator.performOperation(6, 0, '/'), "Division by zero should throw ArithmeticException");
    }
}
