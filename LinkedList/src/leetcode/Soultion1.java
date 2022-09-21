package leetcode;

public class Soultion1 {
	 public ListNode removeElements(ListNode head, int val) {
		 ListNode dummyhead = new ListNode(0);
		 dummyhead.next = head;

		 ListNode pre = dummyhead;
		 while(pre.next != null) {
			 if(pre.next.val == val) {
				 ListNode delNode = pre.next;
				 pre.next = delNode.next;
				 delNode = null;
			 }
			 else {
				pre.next = pre;
			}
		 }
		 return head;
	 }
	 
	 public static void main(String[] args) {
		 
		 int[] nums = {1,2,3,4,5,6};
	 }
}
