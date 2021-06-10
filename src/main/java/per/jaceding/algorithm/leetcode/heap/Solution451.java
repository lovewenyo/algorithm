package per.jaceding.algorithm.leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jaceding
 * @date 2021/6/10
 */
public class Solution451 {

    public String frequencySort(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Comparator<Map.Entry<Character, Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();
        List<Map.Entry<Character, Integer>> list = map.entrySet().stream().sorted(comparator).collect(Collectors.toList());
        StringBuffer buf = new StringBuffer();
        list.forEach(entry -> {
            for (int i = 0; i < entry.getValue(); i++) {
                buf.append(entry.getKey());
            }
        });
        return buf.toString();
    }

    public static void main(String[] args) {
        String str = "bbAa";
        System.out.println(new Solution451().frequencySort(str));
    }
}
