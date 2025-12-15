package com.akshaya;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int temp = n, rev = 0;

        while (temp > 0) {
            rev = rev * 10 + (temp % 10);
            temp /= 10;
        }

        boolean isPalindrome = (n == rev);

        if (isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
