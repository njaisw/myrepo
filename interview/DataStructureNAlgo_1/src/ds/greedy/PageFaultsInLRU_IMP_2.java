package ds.greedy;

/*
 In operating systems that use paging for memory management, page replacement algorithm are needed to decide which page needed to be replaced when new page comes in.
  Whenever a new page is referred and not present in memory, page fault occurs and Operating System replaces one of the existing pages with newly needed page. 
  Different page replacement algorithms suggest different ways to decide which page to replace. The target for all algorithms is to reduce number of page faults.

 In Least Recently Used (LRU) algorithm is a Greedy algorithm where the page to be replaced is least recently used. The idea is based on locality of reference, the least recently used page is not likely

 Let say the page reference string 7 0 1 2 0 3 0 4 2 3 0 3 2 . Initially we have 4 page slots empty.
 Initially all slots are empty, so when 7 0 1 2 are allocated to the empty slots —> 4 Page faults
 0 is already their so —> 0 Page fault.
 when 3 came it will take the place of 7 because it is least recently used —>1 Page fault
 0 is already in memory so —> 0 Page fault.
 4 will takes place of 1 —> 1 Page Fault
 Now for the further page reference string —> 0 Page fault because they are already available in the memory.

 */
import java.util.ArrayList;

public class PageFaultsInLRU_IMP_2 {

	public static void main(String[] args) {
		int capacity = 4;
		int arr[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };

		// To represent set of current pages.We use an Arraylist
		ArrayList<Integer> s = new ArrayList<>(capacity);
		int page_faults = 0;
		for (int i : arr) {
			// Insert it into set if not present already which represents page fault
			if (!s.contains(i)) {
				// Check if the set can hold equal pages
				if (s.size() == capacity) {
					s.remove(0);
					s.add(capacity - 1, i);
				} else
					s.add(s.size(), i);
				// Increment page faults
				page_faults++;
			} else {
				// Remove the indexes page
				s.remove((Object) i);
				// insert the current page
				s.add(s.size(), i);
			}

		}
		System.out.println(page_faults);
	}
}
