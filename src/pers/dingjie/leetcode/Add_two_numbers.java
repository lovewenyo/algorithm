package pers.dingjie.leetcode;

/**
 * @author : dingjie
 * @description : 两数相加
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，
 * 它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * @date : 2018年9月2日 下午4:33:28
 */
public class Add_two_numbers {

    /**
     * @description 链表中的数字按逆序存储的
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode node = listNode;
        int flag = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int temp = x + y + flag;
            flag = 0;
            while (temp >= 10) {
                temp -= 10;
                flag++;
            }
            listNode.next = new ListNode(temp);
            listNode = listNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (flag > 0) {
            //最高为进位
            listNode.next = new ListNode(flag);
        }
        return node.next;
    }

    /**
     * @description 链表中的数字按顺序存储的
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode l3 = addTwoNumbers1(reverse1(l1), reverse1(l2));
        return reverse1(l3);
    }

    /**
     * @description 头插法链表逆置
     */
    public static ListNode reverse1(ListNode listNode) {
        ListNode headNode = new ListNode(0);  //构造头节点
        headNode.next = listNode;

        ListNode p, q;
        p = headNode.next;
        headNode.next = null;

        while (p != null) {
            q = p;
            p = p.next;
            q.next = headNode.next;
            headNode.next = q;
        }
        return headNode.next;
    }

    /**
     * @description 就地逆置
     */
    public static ListNode reverse2(ListNode listNode) {
        ListNode p = null, q = null;

        while (listNode != null) {
            p = listNode;
            listNode = listNode.next;
            p.next = q;
            q = p;
        }
        return p;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int x) {
        val = x;
    }

    public void print() {
        ListNode listNode = this;
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}