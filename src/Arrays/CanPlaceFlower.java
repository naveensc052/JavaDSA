package Arrays;
import java.util.*;
class CanPlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int s = flowerbed.length;
        int count = 0;
        
        for (int i = 0; i < s; i++){
            if (flowerbed[i] == 0){
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                int next = (i == s - 1) ? 0 : flowerbed[i + 1];
                
                if (prev == 0 && next == 0){
                    flowerbed[i] = 1; 
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(flowerbed));
        return count >= n;
    }

    public static void main(String[] args) {
        CanPlaceFlower solution = new CanPlaceFlower();

        int[] flowerbed = {1, 0, 0, 0, 1};
        System.out.println(Arrays.toString(flowerbed));
        int n = 1;
        boolean result = solution.canPlaceFlowers(flowerbed, n);
        System.out.println(result);
    }
}
