package ds.binaryheap;

//Java implementation to merge k sorted linked lists 
import java.util.PriorityQueue;
import java.util.Comparator;

public class MergeKSortedList_IMP_3 {

	// function to merge k sorted linked lists
	public static TNode mergeKSortedLists(TNode arr[], int k) {
		TNode head = null, last = null;

		// priority_queue 'pq' implemeted as min heap with the help of 'compare'
		PriorityQueue<TNode> pq = new PriorityQueue<>(100, new Comparator<TNode>() {
			public int compare(TNode a, TNode b) {
				return a.data - b.data;
			}
		});

		// push the head TNodes of all the k lists in 'pq'
		for (int i = 0; i < k; i++)
			pq.add(arr[i]);

		// loop till 'pq' is not empty
		while (!pq.isEmpty()) {
			// get the top element of 'pq'
			TNode top = pq.peek();
			pq.remove();

			// check if there is a TNode next to the 'top' TNode in the list of which 'top'
			// TNode is a member
			if (top.next != null)
				// push the next TNode in 'pq'
				pq.add(top.next);
			// TODO logic
			// if final merged list is empty
			if (head == null) {
				head = top;
				// points to the last TNode so far of the final merged list
				last = top;
			} else {
				// insert 'top' at the end of the merged list so far
				last.next = top;
				// update the 'last' pointer
				last = top;
			}
		}
		// head TNode of the required merged list
		return head;
	}

	// function to print the singly linked list
	public static void printList(TNode head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	// Utility function to create a new TNode
	public TNode push(int data) {
		TNode newTNode = new TNode(data);
		newTNode.next = null;
		return newTNode;
	}

	public static void main(String args[]) {
		int k = 3; // Number of linked lists
		// an array of pointers storing the head TNodes of the linked lists
		TNode arr[] = new TNode[k];

		arr[0] = new TNode(1);
		arr[0].next = new TNode(3);
		arr[0].next.next = new TNode(5);
		arr[0].next.next.next = new TNode(7);

		arr[1] = new TNode(2);
		arr[1].next = new TNode(4);
		arr[1].next.next = new TNode(6);
		arr[1].next.next.next = new TNode(8);

		arr[2] = new TNode(0);
		arr[2].next = new TNode(9);
		arr[2].next.next = new TNode(10);
		arr[2].next.next.next = new TNode(11);

		// Merge all lists
		TNode head = mergeKSortedLists(arr, k);
		printList(head);
	}
}

class TNode {
	int data;
	TNode next;

	TNode(int data) {
		this.data = data;
		next = null;
	}
}