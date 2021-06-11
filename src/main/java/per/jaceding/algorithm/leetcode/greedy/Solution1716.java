package per.jaceding.algorithm.leetcode.greedy;

/**
 * @author jaceding
 * @date 2021/6/11
 */
public class Solution1716 {

    public int totalMoney(int n) {
        int sum = 0;
        int num = 0;
        while (n >= 7) {
            n = n - 7;
            sum += 28 + (num * 7);
            num++;
        }
        for (int i = num + 1; i <= num + n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution1716().totalMoney(n));
    }
}
