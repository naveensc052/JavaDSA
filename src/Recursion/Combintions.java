package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combintions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size: ");
		int k = scan.nextInt();
		System.out.println("Enter n: ");
		int n = scan.nextInt();
		
		List<List<Integer>> result = new ArrayList<>();
		
		combinationset(1,n,k,new ArrayList<>(),result);
		System.out.println(result);
		scan.close();
	}

	private static void combinationset(int i, int n, int k, List<Integer> list, List<List<Integer>> result) {
		// TODO Auto-generated method stub
		if(list.size() == k) {
			result.add(new ArrayList<>(list));
			return;
		}
		else {
			for(int j = i; j<=n; j++) {
				list.add(j);
				combinationset(j+1,n,k,list,result);
				list.remove(list.size() - 1);
			}
		}
	}

}
