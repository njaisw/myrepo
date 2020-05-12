package ds.hashing;

/*
 * Given a string which contains lower alphabetic characters,  we need to remove at most one character from this string in such a way that frequency of each distinct character becomes same in the string.
Input  : str = “xyyz”
Output : Yes
We can remove character ’y’ from above string to make the frequency of each 
character same.

*/
public class IfFreqCanBeMadeEqual_IMP_3 {

	static final int size = 26;

	static int getIdx(char ch) {
		return (ch - 'a');
	}

	static boolean allSame(int freq[], int N) {
		int same = 0;
		int i;
		for (i = 0; i < N; i++) {
			if (freq[i] > 0) {
				same = freq[i];
				break;
			}
		}
		// check equality of each element with variable same
		for (int j = i + 1; j < N; j++)
			if (freq[j] > 0 && freq[j] != same)
				return false;
		return true;
	}

	static boolean possibleSameCharFreqByOneRemoval(String str) {
		int l = str.length();
		int[] freq = new int[size];

		for (int i = 0; i < l; i++)
			freq[getIdx(str.charAt(i))]++;

		// if all frequencies are same, then return true
		if (allSame(freq, size))
			return true;

		// Try decreasing frequency of all character by one and then check all equality
		// of all non-zero frequencies
		// TODO For iteration over character
		for (char c = 'a'; c <= 'z'; c++) {
			int i = getIdx(c);
			if (freq[i] > 0) {
				freq[i]--;
				if (allSame(freq, size))
					return true;
				freq[i]++;
			}
		}

		return false;
	}

	public static void main(String args[]) {
		String str = "xyyzz";
		if (possibleSameCharFreqByOneRemoval(str))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
