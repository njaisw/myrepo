package ds.hashing;

/*
 * Given an array of words, print the count of all anagrams together in sorted order (increasing order of counts).
For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, then grouped anagrams are “(dog, god) (cat, tac, act)”. So the output will be 2 3.

Here, we will sort each word, calculate its hashcode and then put it in a map where the key will be hashcode generated after sorting. 
The value of the map will be a list containing all the words which have same hashcode after sorting.
Lastly, we will print all values from the hashmap where size of values will be greater than 1.

 */
import java.util.*;

public class GroupAnagrams_IMP_1 {

	private static void printAnagrams(String arr[]) {
		HashMap<Integer, List<String>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			String word = arr[i];

			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String newWord = new String(letters);
			// TODO hashcode String after sorting anagram
			// calculate hashcode of string after sorting
			int hadscodeString = newWord.hashCode();
			if (map.containsKey(hadscodeString)) {
				List<String> words = map.get(hadscodeString);
				words.add(word);
				map.put(hadscodeString, words);
			} else {
				// This is the first time we are adding a word for a specific hashcode
				List<String> words = new ArrayList<>();
				words.add(word);
				map.put(hadscodeString, words);
			}
		}

		// print all the values where size is > 1 If you want to print non-anagrams,
		// just print the values having size = 1
		for (Integer i : map.keySet()) {
			List<String> values = map.get(i);
			if (values.size() > 1) {
				System.out.print(values);
			}
		}
	}

	public static void main(String[] args) {
		String arr[] = { "cat", "dog", "tac", "god", "act" };
		printAnagrams(arr);
	}
}
