package org.example;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = getNumber(scanner, "Enter first number: ");
        char operator = getOperator(scanner);
        double num2 = getNumber(scanner, "Enter second number: ");

        double result = performOperation(num1, num2, operator);

        if (!Double.isNaN(result)) {
            System.out.println("The result is: " + result);
        }
    }

    // Function to get user input for a number
    public static double getNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    // Function to get user input for an operator
    public static char getOperator(Scanner scanner) {
        System.out.print("Enter an operator (+, -, *, /): ");
        return scanner.next().charAt(0);
    }

    // Function to handle the operator and perform the appropriate operation
    public static double performOperation(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return add(num1, num2);
            case '-':
                return subtract(num1, num2);
            case '*':
                return multiply(num1, num2);
            case '/':
                return divide(num1, num2);
            default:
                System.out.println("Invalid operator!");
                return Double.NaN;
        }
    }

    // Function for addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Function for subtraction
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Function for multiplication
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Function for division
// Function for division
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Error! Division by zero.");
        }
        return num1 / num2;
    }

}
