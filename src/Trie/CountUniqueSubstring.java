package Trie;

public class CountUniqueSubstring {
	public static class Node{
		boolean EndOfWord;
		Node[] children;
		Node(){
			children = new Node[26];
			for(int i=0; i<26; i++) {
				children[i] = null;
			}
			EndOfWord = false;
		}
	}
	public static Node root = new Node();
	private static int count = 0;
	public static void insert(String word) {
		Node cur = root;
		for(int i=0; i<word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if(cur.children[index] == null) {
				cur.children[index] = new Node();
				CountUniqueSubstring.count++;
			}
			if(i==word.length()-1) {
				cur.EndOfWord = true;
			}
			cur = cur.children[index];
		}
	}
	public static int countNodes(Node root) {
		if(root == null) {
			return 0;
		}
		int count = 0;
		for(int i=0; i<26; i++) {
			if(root.children[i] != null) {
				count+= countNodes(root.children[i]);
			}
		}
		return 1+count; //extra one for the self node
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words = "apple"; // OUTPUT 15
		for(int i=0; i<words.length(); i++) {
			insert(words.substring(i));
		}
		CountUniqueSubstring.count++;
		System.out.println(CountUniqueSubstring.count);
	}

}
