package com.rubensgomes.useraccount;

/**
 * The App class is the main entry point of the application.
 * It contains a method to get a greeting message and a main method
 * to print the greeting message to the console.
 */
public class App {
    /**
     * Default constructor for the App class.
     */
    public App() {
        // Default constructor
    }

    /**
     * This method returns a greeting message.
     *
     * @return A string containing the greeting message "Hello World!"
     */
    public String getGreeting() {
        return "Hello World!";
    }

    /**
     * Program entry point.
     * This method creates an instance of the App class and prints
     * the greeting message returned by the getGreeting() method.
     *
     * @param args any required arguments to the program.
     */
    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
