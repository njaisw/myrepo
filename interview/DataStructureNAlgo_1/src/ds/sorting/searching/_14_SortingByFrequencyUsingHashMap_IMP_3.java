package ds.sorting.searching;

import java.util.*;

public class _14_SortingByFrequencyUsingHashMap_IMP_3 {

	public static void main(String[] args) {

		int[] array = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };

		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> outputArray = new ArrayList<>();

		for (int current : array) {
			int count = 0;
			if (map.containsKey(current)) {
				count = map.get(current);
			}
			map.put(current, count + 1);
			outputArray.add(current);
		}

		SortComparator comp = new SortComparator(map);
		Collections.sort(outputArray, comp);
		for (Integer i : outputArray) {
			System.out.print(i + " ");
		}
	}
}

class SortComparator implements Comparator<Integer> {
	private final Map<Integer, Integer> freqMap;

	SortComparator(Map<Integer, Integer> tFreqMap) {
		this.freqMap = tFreqMap;
	}

	@Override
	// Returns a negative integer,zero, or a positive integer as the first argument
	// is less than, equalto, or greater than the second.
	public int compare(Integer k1, Integer k2) {

		// a value less than 0 if this Integer is numerically less than the argument
		// Integer; and a value greaterthan 0 if this Integer is numerically greater
		// than the argument Integer (signedcomparison).
		int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));

		// If frequency is equal, then just compare by value, otherwise -
		// compare by the frequency.
		if (freqCompare == 0) {
			// Compare value if frequency is equal
			int valueCompare = k1.compareTo(k2);
			return valueCompare;
		} else
			return freqCompare;
	}
}
