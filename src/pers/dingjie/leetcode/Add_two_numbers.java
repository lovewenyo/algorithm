package pers.dingjie.leetcode;

public class Add_two_numbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2); 
		ListNode l11 = new ListNode(4); 
		ListNode l12 = new ListNode(3); 
		l11.setNext(l12);
		l1.setNext(l11);
		
		ListNode l2 = new ListNode(5);
		ListNode l21 = new ListNode(6);
		ListNode l22 = new ListNode(4);
		l21.setNext(l22);
		l2.setNext(l21);
		
		ListNode l3 = addTwoNumbers(l1,l2);
		while(l3!=null) {
			System.out.println(l3.getVal());
			l3 = l3.getNext();
		}
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.getVal() : 0;
            int y = (q != null) ? q.getVal() : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.setNext(new ListNode(sum % 10));
            curr = curr.getNext();
            if (p != null) p = p.getNext();
            if (q != null) q = q.getNext();
        }
        if (carry > 0) {
            curr.setNext(new ListNode(carry));
        }
        return dummyHead.getNext();  
    }

}
class ListNode {
	private int val;
	private ListNode next;
	ListNode(){}
	ListNode(int x) { val = x; }
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
}