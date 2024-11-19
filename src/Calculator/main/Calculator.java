package Calculator.main;
import java.util.Scanner;

public class Calculator {
private static double memory = 0; //memory variable to store values

    /**
     * Main method to start the calculator application
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {

        //display message to welcome the user to the calculator
        displayWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("help")) {
            displayMenu(scanner);
        } else if (input.isEmpty()) {
            System.out.println("To continue, enter help to display the main menu");
        } else {
            System.out.println("Invalid input!");
        }

        }
        

    private static void displayWelcomeMessage (){
        
        System.out.println("Welcome to my Calculator Application");
        System.out.println("Enter help to access the features of the Calculator");
        
    }

        private static void displayMenu (Scanner scanner){
            System.out.println("Calculator Menu");
            System.out.println("1. Arithmetic Operations");
            System.out.println("2. Advanced Operations");
            System.out.println("3. Trigonometric Operations");
            System.out.println("4. Memory Operations");
            System.out.println("5. Exit");
            System.out.println("=====================================");
            System.out.println("Enter the number corresponding number of the operation you want to perform");
            String input = scanner.nextLine().toLowerCase();
            processCommand(input, scanner);
        }

        private static void processCommand (String input, Scanner scanner){
            switch (input) {
                case "1":
                    performArithmeticOperations(scanner);
                    break;
                case "2":
                    performAdvancedOperations(scanner);
                    break;
                case "3":
                    performTrigonometricOperations(scanner);
                    break;
                case "4":
                    performMemoryOperations(scanner);
                    break;
                case "5":
                    System.out.println("Exiting... ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command! Please enter number from 1 to 5.");
            }
        }

        /**
         * *Performs arithmetic operations
         */

        private static void performArithmeticOperations (Scanner scanner){
            System.out.println("Enter the first number: ");
            double num1 = scanner.nextDouble();
            System.out.println("Enter operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);
            System.out.println("Enter the second number: ");
            double num2 = scanner.nextDouble();

            double result = performArithmeticOperations(num1, operator, num2);
            System.out.println("Result: " + result);
            memory = result;
        }

        private static double performArithmeticOperations ( double num1, char operator, double num2){
            double result;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Cannot divide by zero!");
                        return Double.NaN; //not a number
                    }
                    break;
                default:
                    System.out.println("Invalid operator!");
                    return Double.NaN;

            }
            return result;
        }



        /**
         * *Performs advanced operations (sin, cos, tan)
         */

        private static void performAdvancedOperations (Scanner scanner){
            System.out.println("Enter operation (sqrt, pow): ");
            String operation = scanner.next();
            System.out.println("Enter a number: ");
            double number = scanner.nextDouble();

            double result = performAdvancedOperations(operation, number, scanner);
            System.out.println("Result: " + result);
        }

        private static double performAdvancedOperations (String operation,double number, Scanner scanner){

            switch (operation) {
                case "sqrt":
                    if (number >= 0) {
                        double result = Math.sqrt(number);
                        System.out.println("Square root: " + result);
                        return result;
                    } else {
                        System.out.println("Cannot calculate square root of a negative number!");
                        return Double.NaN;
                    }

                case "pow":
                    System.out.println("Enter exponent: ");
                    double exponent = scanner.nextDouble();

                    double result = Math.pow(number, exponent);
                    System.out.println("Result: " + result);
                    return result;

                default:
                    System.out.println("Invalid operation");
                    return Double.NaN;
            }

        }



        /**
         * *Performs trigonometric operations (sin, cos, tan)
         */
        private static void performTrigonometricOperations (Scanner scanner){

            System.out.println("Enter operation (sin, cos, tan): ");
            String operation = scanner.next();

            System.out.println("Enter angle in degrees: ");
            double angle = scanner.nextDouble();

            double result = performTrigonometricOperations(operation, angle);
            System.out.println("Result: " + result);


        }

        private static double performTrigonometricOperations (String operation,double angle){
            angle = Math.toRadians(angle);

            switch (operation) {
                case "sin":
                    double sinResult = Math.sin(angle);
                    System.out.println("Sin(" + angle + " degrees): " + sinResult);
                    return sinResult;

                case "cos":
                    double cosResult = Math.cos(angle);
                    System.out.println("Cos(" + angle + " degrees): " + cosResult);
                    return cosResult;

                case "tan":
                    double tanResult = Math.tan(angle);
                    System.out.println("Tan(" + angle + " degrees): " + tanResult);
                    return tanResult;

                default:
                    System.out.println("Invalid operation!");
                    return Double.NaN;

            }

        }


    /**
     * *Performs Memory operations
     */
        private static void performMemoryOperations (Scanner scanner){
            System.out.println("Memory Operations");
            System.out.println("1. Store result to memory.");
            System.out.println("2. Recall memory value.");
            System.out.println("3. Clear memory.");

            int choice = scanner.nextInt();
            switch (choice) {
                case '1':
                    System.out.println("Enter value to store to memory.");
                    memory = scanner.nextDouble();

                    System.out.println("Value stored to memory: " + memory);
                    break;

                case '2':
                    System.out.println("Recalled memory value: " + memory);
                    break;

                case '3':
                    memory = 0.0;
                    System.out.println("Memory Cleared!");
                    break;

                default:
                    System.out.println("Invalid input");


            }
        }
    }
