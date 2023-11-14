package Trie;

import Trie.Main.Node;

public class LongestSubstring {

	public static class Node{
		Node[] children;
		boolean EndOfWord;
		int count;
		Node(){
			this.children = new Node[26]; //To store a to z character
			for(int i=0; i<26; i++) {
				children[i] = null;
			}
			this.EndOfWord = false;
			this.count = 0;
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
				current.count++;
				current.children[index] = new Node();
			}
			if(i == word.length()-1) {
				current.children[index].EndOfWord = true;
			}
			current = current.children[index];
			
		}
	}
	
	private static int search() {
		// TODO Auto-generated method stub
		int count = 0;
		while(root.EndOfWord == false && root.count == 1) {
			count++;
			for(int i=0; i<26; i++){
				if(root.children[i] !=null) {
					root = root.children[i];
					break;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"","a"};
		boolean out = true;
		for(String a: words) {
			if(a.isEmpty())
				out = false;
			insert(a);
		}
		if(out == true) {
			int  ans = search();
			System.out.print(words[0].substring(0,ans));
		}
	}
}
