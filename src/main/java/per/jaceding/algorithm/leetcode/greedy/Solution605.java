package per.jaceding.algorithm.leetcode.greedy;

/**
 * @author jaceding
 * @date 2021/6/11
 */
public class Solution605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < l; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && (i == l - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) {
                        return true;
                    }
                } else if (i == l - 1 && (flowerbed[i - 1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) {
                        return true;
                    }
                } else if (i - 1 >= 0 && i + 1 <= l && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        int n = 1;
        System.out.println(new Solution605().canPlaceFlowers(arr, n));
    }
}
