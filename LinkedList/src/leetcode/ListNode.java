package leetcode;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public ListNode(int[] arr) {
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException("the arr can not be empty");
		ListNode cur = this;
		cur.val = arr[0];

		for (int i = 1; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		ListNode cur = this;
		while (cur != null) {
			res.append(cur.val + "->");
			cur = cur.next;
		}
		return res.toString();
	}
}
 
