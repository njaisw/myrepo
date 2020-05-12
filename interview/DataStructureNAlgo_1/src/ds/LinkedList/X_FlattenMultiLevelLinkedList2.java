package ds.LinkedList;

//Java program to flatten a multilevel linked list 
public class X_FlattenMultiLevelLinkedList2 { 
	
	

	static ListNode last; 

	// Flattens a multi-level linked list depth wise 
	public static ListNode flattenList(ListNode node) 
	{ 
		if(node==null) 
			return null; 
	
		// To keep track of last visited node 
		// (NOTE: This is static) 
		last = node; 
	
		// Store next pointer 
		ListNode next = node.next; 
	
		// If down list exists, process it first 
		// Add down list as next of current node 
		if(node.down!=null) 
			node.next = flattenList(node.down); 
	
		// If next exists, add it after the next 
		// of last added node 
		if(next!=null) 
			last.next = flattenList(next); 
	
		return node; 
	} 

	// Utility method to print a linked list 
	public static void printFlattenNodes(ListNode head) 
	{ 
		ListNode curr=head; 
		while(curr!=null) 
		{ 
			System.out.print(curr.data+" "); 
			curr = curr.next; 
		} 
		
	} 
	
	// Utility function to create a new node 
	public static ListNode push(int newData) 
	{ 
		ListNode newNode = new ListNode(newData); 
		newNode.next =null; 
		newNode.down = null; 
		return newNode; 
	} 
	
	public static void main(String args[]) { 
		ListNode head=new ListNode(1); 
		head.next = new ListNode(2); 
		head.next.next = new ListNode(3); 
		head.next.next.next = new ListNode(4); 
		head.next.down = new ListNode(7); 
		head.next.down.down = new ListNode(9); 
		head.next.down.down.down = new ListNode(14); 
		head.next.down.down.down.down= new ListNode(15); 
		head.next.down.down.down.down.next= new ListNode(23); 
		head.next.down.down.down.down.next.down = new ListNode(24); 
		head.next.down.next = new ListNode(8); 
		head.next.down.next.down = new ListNode(16); 
		head.next.down.next.down.down= new ListNode(17); 
		head.next.down.next.down.down.next= new ListNode(18); 
		head.next.down.next.down.down.next.next= new ListNode(19); 
		head.next.down.next.down.down.next.next.next 
											= new ListNode(20); 
		head.next.down.next.down.down.next.next.next.down 
											= new ListNode(21); 
		head.next.down.next.next = new ListNode(10); 
		head.next.down.next.next.down = new ListNode(11); 
		head.next.down.next.next.next = new ListNode(12); 

		head = flattenList(head); 
		printFlattenNodes(head); 
	} 
} 

class ListNode 
{ 
	int data; 
	ListNode next,down; 
	ListNode(int data) 
	{ 
		this.data=data; 
		next=null; 
		down=null; 
	} 
} 

//Node of Multi-level Linked List 

//This code is contributed by Gaurav Tiwari 

