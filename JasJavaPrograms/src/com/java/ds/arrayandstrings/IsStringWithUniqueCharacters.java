package com.java.ds.arrayandstrings;

public class IsStringWithUniqueCharacters {

	public boolean checkUniqueness(String inputString) {
		int reference = 0;

		if (inputString.length() > 26)
			return false;

		for (int i = 0; i < inputString.length(); i++) {
			int difference = inputString.charAt(i) - 'a';

			if ((reference & (1 << difference)) > 0)
				return false;
			reference = reference | (1 << difference);

		}

		return true;
	}

	public static void main(String[] args) {
		IsStringWithUniqueCharacters object = new IsStringWithUniqueCharacters();

		String[] inputs = { "apple", "ball", "cat", "computer" };
		for (String x : inputs)
			System.out.println(x + " :: " + object.checkUniqueness(x));
	}

}
