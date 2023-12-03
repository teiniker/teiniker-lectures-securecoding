package org.se.lab;

public class Main
{
    public static void main(String[] args)
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("password> ");
        String password = scanner.next();

        CheckPassword checker = new CheckPassword();
        if (checker.validate(password))
        {
            System.out.println("Welcome, you have entered a valid password!");
        }
        else
        {
            System.out.println("Login rejected, invalid password!");
        }
        scanner.close();
    }
}
