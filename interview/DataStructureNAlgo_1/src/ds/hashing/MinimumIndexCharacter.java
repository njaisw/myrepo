package ds.hashing;

/*
Given a string str and another string patt. Find the character in patt that is present at the minimum index in str.
If no character of patt is present in str then print ‘No character present’.:
Input : str = "geeksforgeeks"  patt = "set" utput : e
Both e and s of patt are present in str, but e is present at minimum index, which is 1.

Input : str = "adcffaet"   patt = "onkl"
Output : No character present
 
 */

import java.util.HashMap;

public class MinimumIndexCharacter {
	static void printMinIndexChar(String str, String patt) {
		// map to store the first index of each character of 'str'
		HashMap<Character, Integer> hm = new HashMap<>();

		int minIndex = Integer.MAX_VALUE;
		int m = str.length();
		int n = patt.length();

		// store the first index of each character of 'str'
		for (int i = 0; i < m; i++)
			if (!hm.containsKey(str.charAt(i)))
				hm.put(str.charAt(i), i);

		for (int i = 0; i < n; i++)
			// if patt[i] is found in 'um', check if it has the minimum index or not
			// accordingly update 'minIndex'
			if (hm.containsKey(patt.charAt(i)) && hm.get(patt.charAt(i)) < minIndex)
				minIndex = hm.get(patt.charAt(i));

		// print the minimum index character
		if (minIndex != Integer.MAX_VALUE)
			System.out.println("Minimum Index Character = " + str.charAt(minIndex));
		else
			System.out.println("No character present");
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String patt = "set";
		printMinIndexChar(str, patt);
	}
}
