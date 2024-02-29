package DynamicProgramming.MatrixChainMultiplication;

import java.util.Scanner;

public class EvaluateExpToTrue {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        String s = scan.next();
        System.out.println(evaluateNumberOfWays(s,0,s.length()-1,true));
        scan.close();
    }

    private static int evaluateNumberOfWays(String s, int i, int j, boolean istrue) {
        if(i>j){
            return 0;
        }
        if(i==j){
            if (istrue){
                if(s.charAt(i) == 'T'){
                    return 1;
                }else{
                    return 0;
                }
            }else{
                if(s.charAt(i) == 'T'){
                    return 0;
                }else{
                    return 1;
                }
            }
        }
        int ans = 0;
        for(int k=i+1; k<j; k+=2){
            int leftT = evaluateNumberOfWays(s, 0, k-1, true);
            int leftF = evaluateNumberOfWays(s, 0, k-1, false);
            int rightT = evaluateNumberOfWays(s, k+1, j, true);
            int rightF = evaluateNumberOfWays(s, k+1, j, false);
            if(s.charAt(k) == '^'){
                if(istrue){
                    ans += leftT*rightF + leftF*rightT;
                }else{
                    ans += leftF*rightF + leftT*rightT;
                }
            }else if(s.charAt(k) == '&'){
                if(istrue){
                    ans += leftT*rightT;
                }else{
                    ans += leftF*rightF + leftF*rightT + leftT*rightF;
                }
            }else{
                if(istrue){
                    ans += leftF*rightT + leftT*rightF + leftT*rightT;
                }else{
                    ans += leftF*rightF;
                }
            }
        }
        return ans;
        // use Memorization for optimising
    }
}
