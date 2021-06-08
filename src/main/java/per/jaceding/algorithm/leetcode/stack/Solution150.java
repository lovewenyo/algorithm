package per.jaceding.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author jaceding
 * @date 2021/6/8
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if (n == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Deque<Integer> stack = new ArrayDeque<>(n);

        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<String, BiFunction<Integer, Integer, Integer>>() {{
            put("+", (t, u) -> t + u);
            put("-", (t, u) -> t - u);
            put("*", (t, u) -> t * u);
            put("/", (t, u) -> t / u);
            put("%", (t, u) -> t % u);
        }};

        for (String str : tokens) {
            if (map.keySet().contains(str)) {
                int q = stack.pop();
                int p = stack.pop();
                stack.push(map.get(str).apply(p, q));
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
