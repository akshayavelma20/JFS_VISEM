package com.skillnext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int rev = 0;

        while (n != 0) {
            int digit = n % 10; // get last digit
            rev = rev * 10 + digit; // build reversed number
            n /= 10; // remove last digit
        }

        System.out.println("Reversed number: " + rev);
    }
}
