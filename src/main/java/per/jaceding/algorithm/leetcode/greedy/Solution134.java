package per.jaceding.algorithm.leetcode.greedy;

/**
 * @author jaceding
 * @date 2021/6/7
 */
public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }
        int i = 0, index;
        while (i < n) {
            int num = 0;
            for (int j = i; j < i + n; j++) {
                index = j % n;
                num += gas[index];
                num -= cost[index];
                if (num < 0) {
                    i = j + 1;
                    break;
                }
            }
            if (num >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        System.out.println(new Solution134().canCompleteCircuit(gas, cost));
    }
}
