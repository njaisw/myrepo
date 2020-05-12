package ds.trie;

//https://www.geeksforgeeks.org/pattern-searching-using-trie-suffixes/

//Java Program to find the longest common 
//prefix of the given words 
/*
 * Given a set of strings, find the longest common prefix.
Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
Output : "gee"

Input  : {"apple", "ape", "april"}
Output : "ap"
Previous Approaches : Word by Word Matching , Character by Character Matching, Divide and Conquer , Binary Search.
In this article, an approach using Trie date structure is discussed.
Steps:
•	Insert all the words one by one in the trie. After inserting we perform a walk on the trie.
•	In this walk, go deeper until we find a node having more than 1 children(branching occurs) or 0 children (one of the string gets exhausted). 
This is because the characters (nodes in trie) which are present in the longest common prefix must be the single child of its parent, i.e- there should not be a branching in any of these nodes.

 */
public class LongestCommonPrefix {

	static final int ALPHABET_SIZE = 26;

	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];

		// isLeaf is true if the node represents end of a word
		boolean isLeaf;

		public TrieNode() {
			isLeaf = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	};

	static TrieNode root;
	static int indexs;

	// If not present, inserts key into trie If the key is prefix of trie node, just
	// marks leaf node
	static void insert(String key) {
		int length = key.length();
		int index;

		TrieNode pCrawl = root;

		for (int level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();

			pCrawl = pCrawl.children[index];
		}

		// mark last node as leaf
		pCrawl.isLeaf = true;
	}

	// Counts and returns the number of children of the current node
	static int countChildren(TrieNode node) {
		int count = 0;
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			if (node.children[i] != null) {
				count++;
				indexs = i;
			}
		}
		return (count);
	}

	// Peform a walk on the trie and return the longest common prefix string
	static String walkTrie() {
		TrieNode pCrawl = root;
		indexs = 0;
		String prefix = "";

		while (countChildren(pCrawl) == 1 && pCrawl.isLeaf == false) {
			pCrawl = pCrawl.children[indexs];
			prefix += (char) ('a' + indexs);
		}
		return prefix;
	}

	// A Function to construct trie
	static void constructTrie(String arr[], int n) {
		for (int i = 0; i < n; i++)
			insert(arr[i]);
		return;
	}

	static String commonPrefix(String arr[], int n) {
		root = new TrieNode();
		constructTrie(arr, n);
		return walkTrie();
	}

	public static void main(String args[]) {
		String arr[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
		int n = arr.length;

		String ans = commonPrefix(arr, n);

		if (ans.length() != 0)
			System.out.println("The longest common prefix is " + ans);
		else
			System.out.println("There is no common prefix");
	}
}
