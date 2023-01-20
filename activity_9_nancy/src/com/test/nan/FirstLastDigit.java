package com.test.nan;

import java.util.Scanner;

public class FirstLastDigit {
	
	public static void main(String[] args) 
	{
		int inputNumber, firstDigit, lastDigit;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" Please Enter any Number : ");
		inputNumber = sc.nextInt();	
		
		firstDigit = inputNumber;
		
		while(firstDigit >= 10)
		{
			firstDigit = firstDigit / 10;
		}	
		
		lastDigit = inputNumber % 10;
		
		System.out.println("First Digit of Given Number " + inputNumber + "  =  " + firstDigit);
		System.out.println("Last Digit of Given Number " + inputNumber + "  =  " + lastDigit);
	}

}
