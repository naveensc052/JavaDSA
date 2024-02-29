package Recursion;

import java.util.Scanner;

public class KthElementGrammer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter n and k respectively:- " );
		int n = scan.nextInt();
		int k = scan.nextInt();
		int ans  = kthGrammar(n,k);
		System.out.println("Answer is " + ans);
		scan.close();
	}
	public static int kthGrammar(int n, int k) {
        int ans = Recursion(n, k);
        
        return ans;
    }

    public static int Recursion(int n, int k) {
        if (n == 1) {
            return 0;
        }
        if(k<=Math.pow(2,n-1)/2){
            return Recursion(n-1,k);
        }
        else{
            return 1 - Recursion(n-1,k-(int)Math.pow(2,n-1)/2);
        }
    }
}
