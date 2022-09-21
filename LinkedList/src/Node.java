

class Node  {
	public int e;
	public Node next;
	
	public Node(int e) {
		this.e = e;
		next = null;
	}
	
	public String toString() {
		return String.valueOf(e);
	}
	
	public static Node reverseLinkedNode(Node head) {
		if(head == null || head.next == null)
			return head;
		else {
			Node newHead;
			newHead = reverseLinkedNode(head.next);
			head.next.next = head;
			head.next = null;
			return newHead;
				}
	}
	
	
}
