package _5_com.ds.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/implement-lru-cache/
 * 
 * We use two data structures to implement an LRU Cache.
 * 
 * Queue which is implemented using a doubly linked list. The maximum size of
 * the queue will be equal to the total number of frames available (cache
 * size).The most recently used pages will be near front end and least recently
 * pages will be near rear end. A Hash with page number as key and address of
 * the corresponding queue node as value.
 * 
 * Test cases: MAX_SIZE greater than 1 Delete when empty Delete when full Enter
 * data more than max Delete till cache is empty
 */
public class LRUCache_IMP_3 {

	private Node head;
	private Node tail;
	private Map<Integer, Node> map = new HashMap<Integer, Node>();
	private int MAX_SIZE = 5;
	private int size = 0;

	public LRUCache_IMP_3(int size) {
		MAX_SIZE = size;
	}

	public void get(int data) {
		if (containsInCache(data)) {
			// If the map contains the node then remove the node from the map and place the
			// at the front of the queue Front contains most recently used values
			Node node = map.get(data);
			if (node != head) {
				deleteFromCache(data);
				node.next = head;
				head.before = node;
				head = node;
				map.put(data, node);
			}
		} else {
			addIntoCache(data);
		}
	}

	public void addIntoCache(int data) {
		size++;
		if (head == null) {
			head = Node.newNode(data);
			tail = head;
			return;
		}
		if (size > MAX_SIZE) {
			tail = tail.before;
			Node next = tail.next;
			tail.next = null;
			next.before = null;
			map.remove(next.data);
		}
		Node newNode = Node.newNode(data);
		newNode.next = head;
		if (head != null) {
			head.before = newNode;
		}
		head = newNode;
		map.put(data, newNode);
		return;
	}

	public void printCache() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public boolean containsInCache(int data) {
		return map.containsKey(data);
	}

	public void deleteFromCache(int data) {
		Node node = map.get(data);
		if (node == null) {
			return;
		}
		map.remove(data);
		// Only 1 node
		if (size == 1) {
			head = null;
			tail = null;
		} // if node to be deleted is head
		else if (node == head) {
			head = head.next;
			if (head != null) {
				head.before = null;
			}
			node.next = null;
		} else if (node == tail) {
			tail = tail.before;
			tail.next = null;
		} else {
			Node before = node.before;
			Node next = node.next;
			before.next = next;
			next.before = before;
		}
	}

	public static void main(String args[]) {
		LRUCache_IMP_3 lruCache = new LRUCache_IMP_3(5);
		lruCache.get(4);

		lruCache.get(5);
		lruCache.printCache();
		lruCache.get(6);
		lruCache.printCache();
		lruCache.get(5);
		lruCache.printCache();
		lruCache.get(9);
		lruCache.printCache();
		lruCache.get(10);
		lruCache.printCache();
		lruCache.get(11);
		lruCache.printCache();
		lruCache.get(16);
		lruCache.printCache();
		lruCache.get(10);
		lruCache.printCache();
		lruCache.deleteFromCache(10);
		lruCache.printCache();
		lruCache.deleteFromCache(9);
		lruCache.printCache();
	}
}
