package per.jaceding.algorithm.leetcode.heap;

import java.util.*;

/**
 * 最小堆 解决TOP K问题
 *
 * @author jaceding
 * @date 2021/6/10
 */
public class Solution692 {

    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> map = new HashMap<>(n);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Comparator<Map.Entry<String, Integer>> comparator = (o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) {
                return o1.getValue() - o2.getValue();
            } else {
                return o2.getKey().compareTo(o1.getKey());
            }
        };

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, comparator);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else if (comparator.compare(entry, queue.peek()) > 0) {
                queue.poll();
                queue.add(entry);
            }
        }
        String[] arr = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            arr[i] = queue.poll().getKey();
        }
        return Arrays.asList(arr);
    }

    public static void main(String[] args) {
        String[] arr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        new Solution692().topKFrequent(arr, k).forEach(System.out::println);
    }
}
