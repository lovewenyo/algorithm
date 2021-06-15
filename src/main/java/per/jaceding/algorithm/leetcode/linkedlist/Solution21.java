package per.jaceding.algorithm.leetcode.linkedlist;

/**
 * @author jaceding
 * @date 2021/6/15
 */
public class Solution21 {

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, node = null, temp;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            } else {
                temp = l2;
                l2 = l2.next;
            }
            if (head == null) {
                head = temp;
                node = temp;
            } else {
                node.next = temp;
                node = node.next;
            }
        }
        if (l1 != null) {
            if (head == null) {
                head = l1;
            } else {
                node.next = l1;
            }
        }
        if (l2 != null) {
            if (head == null) {
                head = l2;
            } else {
                node.next = l2;
            }
        }
        return head;
    }
}
