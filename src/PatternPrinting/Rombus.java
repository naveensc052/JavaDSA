package PatternPrinting;

import java.util.Scanner;

public class Rombus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Enter Size of Square
        int N = scan.nextInt();
        for(int i=1; i<=N; i++){
            for(int j=N-1; j>=i; j--){
                System.out.print(" ");
            }
            for(int j=1; j<=N; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        scan.close();
    }
}
