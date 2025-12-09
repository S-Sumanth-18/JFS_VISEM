package com.skillnext2;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome: ");
        String str = sc.nextLine();

        String reversed = "";

        // Reverse the string manually
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        // Check palindrome
        if (str.equalsIgnoreCase(reversed)) {
            System.out.println("✔ " + str + " is a palindrome!");
        } else {
            System.out.println("✘ " + str + " is NOT a palindrome.");
        }

        sc.close();
    }
}
