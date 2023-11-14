package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subset {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        System.out.print("Enter N: ");
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        System.out.print("Enter the N elements: ");
        for (int i = 0; i < N; i++){
            int x = scan.nextInt();
            list.add(x);
        }
        Subset(list, 0, new ArrayList<>(), ans);
        System.out.println(ans);
    }

    private static void Subset(List<Integer> list, int index, List<Integer> current, List<List<Integer>> ans){
        if (index == list.size()) {
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(list.get(index));
        Subset(list, index + 1, current, ans);
        current.remove(current.size() - 1);
        Subset(list, index + 1, current, ans);
    }
}
