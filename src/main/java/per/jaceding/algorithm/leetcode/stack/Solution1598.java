package per.jaceding.algorithm.leetcode.stack;

import java.util.LinkedList;

/**
 * @author jaceding
 * @date 2021/6/9
 */
public class Solution1598 {

    public int minOperations(String[] logs) {
        LinkedList<String> stack = new LinkedList<>();
        for (String log : logs) {
            switch (log) {
                case "./":
                    break;
                case "../":
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(log);
                    break;
            }
        }
        return stack.size();
    }
}
