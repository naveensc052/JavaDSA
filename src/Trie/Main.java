package Trie;

public class Main {
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
	
    // Deletion in Trie
    public static void delete(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            Node next = current.children[index];
            if (next == null) {
                // Word not found in the Trie, nothing to delete
                return;
            }
            if (i == word.length() - 1) {
                // Mark the last node as not the end of a word
                next.EndOfWord = false;
            }
            current = next;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] = {"the", "a","there", "their","any"};
		
		for(String a : words) {
			insert(a);
		}
		System.out.println(search("their"));
		System.out.println(search("an"));
		System.out.println(search("thor"));
	}

}
