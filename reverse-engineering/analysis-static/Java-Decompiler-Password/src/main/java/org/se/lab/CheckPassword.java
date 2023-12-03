package org.se.lab;

public class CheckPassword
{
    private static int constant()
    {
        return 2;
    }

    private static int len()
    {
        return 6 * constant();
    }

    private static String secret()
    {
        return "VvnoWnioi8hjHGzu&56nm;:mkhjghfg";
    }
    private static boolean validate(String password)
    {
        return secret().substring(10, 10 + len()).equals(password);
    }

    public static void main(String[] args)
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("password> ");
        String password = scanner.next();

        if (validate(password))
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
