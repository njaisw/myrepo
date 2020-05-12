package ds.hashing;

/*
Input:  ch = "geeksforgeeks"
Output: e e is the first element that repeats

Input:  str = "hello geeks"
Output: l 
l is the first element that repeats

 */
import java.util.*;

public class FirstRepeatedCharacter {
	static char firstRepeating(char str[]) {
		HashSet<Character> h = new HashSet<>();
		// Traverse the input array from left to right
		for (int i = 0; i <= str.length - 1; i++) {
			char c = str[i];
			// If element is already in hash set, update x and then break
			if (h.contains(c))
				return c;
			else
				h.add(c);
		}
		return '\0';
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		char[] arr = str.toCharArray();
		System.out.println(firstRepeating(arr));
	}
}
