package SlidingWindowOr2Pointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FruitIntoBaskets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); 
		int[] fruits = new int[n];
		for(int i=0; i<n; i++) {
			fruits[i] = scan.nextInt();
		}
		int len = totalFruit(fruits);
		System.out.println("Maximum Fruits is:- " + len);
		scan.close();
	}
	private static int totalFruit(int[] fruits) {
        int ans = 0;
        int n = fruits.length;
        int l = 0, r =0;
        Map<Integer, Integer> map = new HashMap<>();
        while(r<n){
            int fruit = fruits[r];
            map.put(fruit, map.getOrDefault(fruit,0)+1);
            if(map.size()>2){
                int freq = map.get(fruits[l]);
                map.put(fruits[l], map.getOrDefault(fruits[l],0) - 1);
                if(freq == 1){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size()<2)
                ans = Math.max(ans, r-l+1);
            r = r+1;
        }
        return ans;
	}

}
