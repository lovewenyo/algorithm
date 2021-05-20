package per.jaceding.algorithm.leetcode;

/**
 * @author jaceding
 * @date 2020/9/28
 */

public class Solution160 {

    /**
     * 找到两个单链表相交的起始节点
     * 时间复杂度是 m + n + max(m, n)
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return 相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA > lenB) {
            int count = lenA - lenB;
            while (count-- > 0) {
                headA = headA.next;
            }
        }
        if (lenA < lenB) {
            int count = lenB - lenA;
            while (count-- > 0) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 找到两个单链表相交的起始节点
     * 优化版：时间复杂度是 m + n
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return 相交节点
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb) {
            ha = ha == null ? headB : ha.next;
            hb = hb == null ? headA : hb.next;
        }
        return ha;
    }

    /**
     * 获取链表长度
     *
     * @param node 链表
     * @return 链表长度
     */
    private int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
