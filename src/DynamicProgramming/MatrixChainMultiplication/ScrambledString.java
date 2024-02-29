package DynamicProgramming.MatrixChainMultiplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScrambledString {
    private static Map<String, Boolean> memo = new HashMap<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        System.out.println(isStringScrambled(s1,s2));
        scan.close();
    }
    

    private static boolean isStringScrambled(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        if(s1.length() != s2.length()) return false;
        String key = s1 + "|" + s2;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        for(int i=0; i<s1.length()-1; i++){
            if(isStringScrambled(s1.substring(0, i+1), s2.substring(0,i+1)) && isStringScrambled(s1.substring(i+1), s2.substring(i+1))){
                return true;
            }
            if(isStringScrambled(s1.substring(0, i+1), s2.substring(i+1)) && isStringScrambled(s1.substring(i+1), s2.substring(0,i+1))){
                return true;
            }
        }
        return false;
    }
}