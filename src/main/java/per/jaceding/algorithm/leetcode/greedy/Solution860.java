package per.jaceding.algorithm.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jaceding
 * @date 2021/6/11
 */
public class Solution860 {

    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        if (n == 0) {
            return true;
        }

        Map<Integer, Integer> map = new HashMap<>(4, 0.75f);
        for (int i = 0; i < n; i++) {
            int bill = bills[i];
            map.put(bill, map.getOrDefault(bill, 0) + 1);
            if (bill == 10) {
                if (map.getOrDefault(5, 0) <= 0) {
                    return false;
                }
                map.put(5, map.getOrDefault(5, 0) - 1);
            } else if (bill == 20) {
                bill = 15;
                if (map.getOrDefault(10, 0) > 0) {
                    map.put(10, map.getOrDefault(10, 0) - 1);
                    bill -= 10;
                }
                while (bill >= 5 && map.getOrDefault(5, 0) > 0) {
                    map.put(5, map.getOrDefault(5, 0) - 1);
                    bill -= 5;
                }
                if (bill > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
