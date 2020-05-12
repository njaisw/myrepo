package ds.hashing;

/*
 * Given an array of names of candidates in an election. 
 * A candidate name in array represents a vote casted to the candidate. 
 * Print the name of candidates received Max vote. If there is tie, print lexicographically smaller name.
Examples:
Input :  votes[] = {"john", "johnny", "jackie", 
                    "johnny", "john", "jackie", 
                    "jamie", "jamie", "john",
                    "johnny", "jamie", "johnny", 
                    "john"};
Output : John
We have four Candidates with name as 'John', 'Johnny', 'jamie', jackie'. The candidates John and Johny get maximum votes. Since John is alphabetically smaller, we print it.

 */
import java.util.*;

public class WinnerOfAElection_IMP_1 {
	/*
	 * We have four Candidates with name as 'John', 'Johnny', 'jamie', 'jackie'. The
	 * votes in String array are as per the votes casted. Print the name of
	 * candidates received Max vote.
	 */
	public static void findWinner(String votes[]) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : votes) {
			if (map.keySet().contains(str))
				map.put(str, map.get(str) + 1);
			
			else
				map.put(str, 1);
		}

		// Traverse through map to find the candidate with maximum votes.
		int maxValueInMap = 0;
		String winner = "";
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			if (val > maxValueInMap) {
				maxValueInMap = val;
				winner = key;
			} // If there is a tie, pick lexicographically  smaller.
			//TODO remember compareTO
			else if (val == maxValueInMap && winner.compareTo(key) > 0)
				winner = key;
		}
		System.out.println(winner);
	}

	public static void main(String[] args) {
		String[] votes = { "john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny",
				"jamie", "johnny", "john" };

		findWinner(votes);
	}
}
