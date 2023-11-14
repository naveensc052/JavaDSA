package Trie;

import Trie.Main.Node;

/*
 * Finding the longest string in wordssuch that every prefix of it is also in word
 */
public class LongestWordwithallPrefix {
	public static class Node{
		Node[] children;
		boolean EndOfWord;
		Node(){
			children = new Node[26]; //To store a to z character
			for(int i=0; i<26; i++) {
				children[i] = null;
			}
			EndOfWord = false;
		}
	}
	
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
		System.out.print("Result of Searching the word : " + word + " = ");
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
	
	public static String ans = "";
	
	public static void longestword(Node root, StringBuilder temp) {
		if(root == null) {
			return;
		}
		
		for(int i=0; i<26; i++) {
			if(root.children[i] != null && root.children[i].EndOfWord == true) {
				temp.append((char)(i+'a'));
				if(temp.length() > ans.length()) {
					ans = temp.toString();
				}
				longestword(root.children[i], temp);
				temp.deleteCharAt(temp.length() - 1);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] = {"a", "ap","app", "appl","appl","apply","flower"};
		for(String a: words) {
			insert(a);
		}
		longestword(root,new StringBuilder(""));
		System.out.println("Result = "+ans);
	}

}
