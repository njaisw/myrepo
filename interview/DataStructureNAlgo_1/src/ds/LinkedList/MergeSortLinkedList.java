package ds.LinkedList;

public class MergeSortLinkedList {
	node head = null;

	// node a,b;
	static class node {
		int val;
		node next;

		public node(int val) {
			this.val = val;
		}
	}

	node sortedMerge(node a, node b) {
		node result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.val <= b.val) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;

	}

	node mergeSort(node h) {
		// Base case : if head is null
		if (h == null || h.next == null) {
			return h;
		}
		// get the middle of the list
		node middle = getMiddle(h);
		node nextofmiddle = middle.next;
		// set the next of middle node to null
		middle.next = null;
		// Apply mergeSort on left list
		node left = mergeSort(h);
		// Apply mergeSort on right list
		node right = mergeSort(nextofmiddle);
		// Merge the left and right lists
		node sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	// Utility function to get the middle of the linked list
	node getMiddle(node h) {
		if (h == null)
			return h;
		node fastptr = h.next;
		node slowptr = h;

		// Move fastptr by two and slow ptr by one Finally slowptr will point to middle
		// node
		while (fastptr != null) {
			fastptr = fastptr.next;
			if (fastptr != null) {
				slowptr = slowptr.next;
				fastptr = fastptr.next;
			}
		}
		return slowptr;
	}

	void push(int new_data) {
		node new_node = new node(new_data);
		new_node.next = head;
		head = new_node;
	}

	void printList(node headref) {
		while (headref != null) {
			System.out.print(headref.val + " ");
			headref = headref.next;
		}
	}

	public static void main(String[] args) {
		MergeSortLinkedList li = new MergeSortLinkedList();
		// lists shall be a: 2->3->20->5->10->15
		li.push(15);
		li.push(10);
		li.push(5);
		li.push(20);
		li.push(3);
		li.push(2);
		System.out.println("Linked List without sorting is :");
		li.printList(li.head);

		// Apply merge Sort
		li.head = li.mergeSort(li.head);
		System.out.print("\n Sorted Linked List is: \n");
		li.printList(li.head);
	}
}
