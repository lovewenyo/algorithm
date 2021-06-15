package per.jaceding.algorithm.leetcode.linkedlist;

/**
 * @author jaceding
 * @date 2021/6/15
 */
public class Solution141 {

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

    public boolean hasCycle(ListNode head) {
        ListNode p = head, q = head;
        while (q != null) {
            q = q.next;
            if (q == null) {
                return false;
            }
            q = q.next;
            p = p.next;
            if (p == q) {
                return true;
            }
        }
        return false;
    }
}
