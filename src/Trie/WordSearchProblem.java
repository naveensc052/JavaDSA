package Trie;

import Trie.Main.Node;

/*
 * Given input String and Dictonary of words, find out if the input String
 * can be broken into space-separated sequence of Dictionary words
 * Example:- words[] = {"i", "like", "sam", "samsung", "mobile", "ice" }
 * Key = ilikesamsung
 * Output = true
 * */

public class WordSearchProblem {
	
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
	public static boolean search(String word) {
		Node rootnew = root;
		//System.out.print("Result of Searching the word : " + word + " = ");
		for(int i=0; i<word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if(root.children[index] == null) {
				root = rootnew;
				return false;
			}
			if(i==word.length()-1 && root.children[index].EndOfWord == false) {
				root = rootnew;
				return false;
			}
			root = root.children[index];
		}
		root = rootnew;
		return true;
	}
	
	//WordBreak
	public static boolean wordBreak(String word) {
		if(word.length() == 0) {
			return true;
		}
		for(int i=1; i<=word.length(); i++) {
			String firstpart = word.substring(0, i);
			String secondpart = word.substring(i,word.length());
			if(search(firstpart) && wordBreak(secondpart)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] = {"i", "like", "sam", "samsung", "mobile", "ice" };
		String Key = "ilikesam";
		
		for(String a : words) {
			insert(a);
		}
		
		System.out.println(wordBreak(Key));
		
	}

}
