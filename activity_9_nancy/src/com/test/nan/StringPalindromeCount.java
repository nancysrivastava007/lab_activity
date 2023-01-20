package com.test.nan;

public class StringPalindromeCount {

	public boolean checkPalindrome(String word)
	{
		int n = word.length();
		word = word.toLowerCase();
		for (int i=0; i<n; i++,n--)
			if (word.charAt(i) != word.charAt(n - 1))
				return false;      
		return true;
	}

	public int countPalindrome(String str){       
		str = str + " ";

		String word = "";
		int count = 0;
		for (int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);

			if (ch != ' ')
				word = word + ch;
			else {
				if (checkPalindrome(word))
					count++;
				word = "";
			}
		}

		return count;
	}

	public static void main(String args[]){

		StringPalindromeCount sc = new StringPalindromeCount();
		System.out.println(sc.countPalindrome("Madam "
				+ "Arora teaches malayalam"));

		System.out.println(sc.countPalindrome("Nitin "
				+ "speaks malayalam"));
	}
}
