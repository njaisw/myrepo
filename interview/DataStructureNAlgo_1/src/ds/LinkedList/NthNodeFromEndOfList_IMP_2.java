package ds.LinkedList;

//Java program to find n'th node from end using slow and fast pointers 
public class NthNodeFromEndOfList_IMP_2 {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Function to get the nth node from end of list */
	void printNthFromLast(int n) {
		Node main_ptr = head;
		Node ref_ptr = head;

		int count = 0;
		if (head != null) {
			while (count < n) {
				if (ref_ptr == null) {
					System.out.println(n + " is greater than the no " + " of nodes in the list");
					return;
				}
				ref_ptr = ref_ptr.next;
				count++;
			}
			while (ref_ptr != null) {
				main_ptr = main_ptr.next;
				ref_ptr = ref_ptr.next;
			}
			System.out.println("Node no. " + n + " from last is " + main_ptr.data);
		}
	}

	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public static void main(String[] args) {
		NthNodeFromEndOfList_IMP_2 llist = new NthNodeFromEndOfList_IMP_2();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);

		llist.printNthFromLast(4);
	}
}
