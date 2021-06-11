package per.jaceding.algorithm.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jaceding
 * @date 2021/6/11
 */
public class Solution23 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return lists[0];
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode node = null;
        ListNode head = null;

        while (true) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                ListNode listNode = lists[i];
                if (listNode != null) {
                    lists[i] = listNode.next;
                    listNode.next = null;
                    queue.add(listNode);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        while (!queue.isEmpty()) {
            if (head == null) {
                node = queue.poll();
                head = node;
            } else {
                node.next = queue.poll();
                node = node.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[2];

        ListNode listNode1 = new ListNode(-2);
        lists[0] = listNode1;
        ListNode listNode2 = new ListNode(-1);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(-1);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(-1);
        listNode3.next = listNode4;

        ListNode listNode = new Solution23().mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
