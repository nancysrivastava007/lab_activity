package com.test.nan;

public class SearchElementArray {

	public static void main(String[] args) {

	    int[] numberArray = {1, 2, 3, 4, 5};
	    int numberToFind = 3;
	    boolean found = false;

	    for (int n : numberArray) {
	      if (n == numberToFind) {
	        found = true;
	        break;
	      }
	    }
	    
	    if(found)
	      System.out.println(numberToFind + " is found.");
	    else
	      System.out.println(numberToFind + " is not found.");
	  }
	}
