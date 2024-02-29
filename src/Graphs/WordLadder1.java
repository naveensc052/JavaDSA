package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class WL{
    String word;
    int d;
    WL(String w, int d){
        this.d = d;
        this.word = w;
    }
}
public class WordLadder1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] wordList = new String[n];
        for(int i=0; i<n; i++){
            wordList[i] = scan.next();
        }
        String beginWord = scan.next();
        String endWord = scan.next();
        int smallestLength = solve(n, beginWord, endWord, wordList);
        System.out.println(smallestLength);
        scan.close();
    }

    private static int solve(int n, String beginWord, String endWord, String[] wordList) {
        Queue<WL> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(wordList[i]);
        }
        q.add(new WL(beginWord, 1));

        if(set.contains(beginWord)) set.remove(beginWord);

        while(!q.isEmpty()){
            WL nod = q.poll();
            String s = nod.word;
            int depth = nod.d;

            if(s.equals(endWord)) return depth;

            for(int i=0; i<s.length(); i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    char[] replacedcharArray = s.toCharArray();
                    replacedcharArray[i] = ch;
                    String replacedString = new String(replacedcharArray);
                    if(set.contains(replacedString)){
                        q.add(new WL(replacedString, depth+1));
                        set.remove(replacedString);
                    }
                }
            }
        }
        return 0;
    }
}