package DynamicProgramming.LCS_Variations;

import java.util.Scanner;

public class QAQ894A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int[] ans = new int[1];
        solve(s, 0, '0', ans);
        System.out.println(ans[0]);
        scan.close();
    }

    private static void solve(String s, int i, char prev, int[] ans) {
        if (i == s.length()) {
            return;
        } else {
            if (prev == '0') {
                if (s.charAt(i) == 'Q') {
                    solve(s, i + 1, 'Q', ans);
                }
                solve(s, i + 1, '0', ans); // Updated the 'prev' character
            } else if (prev == 'Q') {
                if (s.charAt(i) == 'A') {
                    solve(s, i + 1, 'A', ans);
                }
                solve(s, i + 1, 'Q', ans); // Updated the 'prev' character
            } else if (prev == 'A') {
                if (s.charAt(i) == 'Q') {
                    ans[0]++;
                    solve(s, i + 1, 'Q', ans);
                }
                solve(s, i + 1, 'A', ans); // Updated the 'prev' character
            }
        }
    }
}