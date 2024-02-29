package Trie;

import Trie.Main.Node;

/*
 * Create a function boolean startWithPrefix(String Prefix) for Trie
 * Return true if there is previously inserted string word that has the prefix and false otherwise*/

public class StartwithPrefix {
	static Node root = new Node();
	
	// Insertion in Trie
	public static void insert(String word) {
		Node current  = root;
		for(int i=0; i<word.length(); i++) {
			int index = word.charAt(i)-'a';
			if(current.children[index] == null) {
				//add new node
				current.children[index] = new Node();
			}
			if(i == word.length()-1) {
				current.children[index].EndOfWord = true;
			}
			
			current = current.children[index];
			
		}
	}
	//Searching in Trie
	public static boolean istherePrefix(String word) {
		if(word.length() == 0) {
			return true;
		}
		Node current = root;
		for(int i=0; i<word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if(current.children[index] == null) {
				return false;
			}
			current = current.children[index];
			
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] = {"apple", "app", "mongo", "man", "woman"};
		for(String a:words) {
			insert(a);
		}
		System.out.println(istherePrefix("app"));
		System.out.println(istherePrefix("hello"));
		
	}

}
