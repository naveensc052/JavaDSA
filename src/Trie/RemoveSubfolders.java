package Trie;

import java.util.*;
public class RemoveSubfolders {

	public static class Node{
		Node[] children;
		boolean eow;
		Node(){
			children = new Node[256];
			for(int i=0; i<256; i++) {
				children[i] = null;
			}
			eow = false;
		}
	}
	
	public static Node root = new Node();
	
	
	public static void insert(String word) {
		Node cur = root;
		for(int i=0; i<word.length(); i++) {
			if(cur.children[(int)word.charAt(i)] == null) {
				cur.children[(int)word.charAt(i)] = new Node();
			}
			if(i==word.length()-1) {
				cur.children[(int)word.charAt(i)].eow = true;
			}
			cur = cur.children[(int)word.charAt(i)];
		}
	}
	
	public static List<String> removesub(Node root, StringBuilder temp){
		List<String> ans = new ArrayList<>();
		for(int i=0; i<256; i++) {
			if(root.children[i] != null) {
				temp.append((char)i);
				if(root.children[i].eow == true) {					
					ans.add(temp.toString());

				}
				else {
					ans.addAll(removesub(root.children[i], temp));
				}
				temp.deleteCharAt(temp.length()-1);
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String folder[] = {"/a","/a/b/c","/a/b/d"};
		for(String a: folder) {
			insert(a);
		}
		List<String> ans = removesub(root, new StringBuilder(""));
		System.out.print(ans);
	}

}
