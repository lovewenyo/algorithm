package per.jaceding.algorithm.leetcode.greedy;

/**
 * @author jaceding
 * @date 2021/6/11
 */
public class Solution1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = 0;
        sum += numBottles;
        while (numBottles >= numExchange) {
            sum += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return sum;
    }

    public static void main(String[] args) {
        int numBottles = 15;
        int numExchange = 4;
        System.out.println(new Solution1518().numWaterBottles(numBottles, numExchange));
    }
}
