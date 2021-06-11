package per.jaceding.algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 * @author jaceding
 * @date 2021/6/11
 */
public class Solution1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        if (n == 0 || truckSize == 0) {
            return 0;
        }
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int truck = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            while (truck < truckSize && boxTypes[i][0]-- > 0) {
                sum += boxTypes[i][1];
                truck++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 1;
        System.out.println(num--);
        System.out.println(num);
    }
}
