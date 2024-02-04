package PatternPrinting;

import java.util.Scanner;

public class HollowSqaureDiagonal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Enter Size of Square
        int N = scan.nextInt();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==1 || j==1 || j==N || i==N || i==j || j==(N - i + 1))
                    System.out.print("*");
                else    
                    System.out.print(" ");
            }
            System.out.println();
        }
        scan.close();
    }
}
