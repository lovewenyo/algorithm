package per.jaceding.algorithm.leetcode.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jaceding
 * @date 2021/6/9
 */
public class Solution1441 {

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>(n);
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 1;
        int j = 0;
        while (i <= n && j < target.length) {
            stack.push(i);
            list.add("Push");
            i++;
            if (!stack.isEmpty() && stack.peek() != target[j]) {
                stack.pop();
                list.add("Pop");
            } else {
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        int n = 4;
        new Solution1441().buildArray(arr, n).forEach(e -> System.out.println(e));
    }
}
