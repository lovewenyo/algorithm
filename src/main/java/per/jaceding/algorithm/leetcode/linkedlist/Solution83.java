package per.jaceding.algorithm.leetcode.linkedlist;

/**
 * @author jaceding
 * @date 2021/6/15
 */
public class Solution83 {

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head, q;
        while (p.next != null) {
            q = p.next;
            if (p.val >= q.val) {
                p.next = q.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
