
public class LinkedList<E> {
	
	private class Node{
		public E e;
		public Node next;
		
		public Node(E e,Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node(E e) {
			this.e = e;
			next = null;
		}
		
		public Node(){
			this(null,null);
		}
		
		public String toString() {
			return e.toString();
		}
	}
	
	private Node dummyhead;//虚拟头节点
	private int size;
	
	public LinkedList() {
		dummyhead = new Node(null,null);
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public Boolean isEmpty(){
		return size == 0;
	}
	
	public void add(int index,E e) {
		if(index < 0 || index > size)
			throw new IllegalArgumentException("index is not correct");
		Node prev = dummyhead;
		for(int i = 0 ; i < index; i++) {
			prev = prev.next;
		}	
		//Node node = new Node(e);
		//node.next = prev.next;
		//prev.next = node;
		prev.next = new Node(e,prev.next);			
		size++;
		
	}
	
	public void addFirst(E e) {
		//Node node = new Node(e);
		//node.next = head;
		//head = node;
		
		//head = new Node(e, head);
		//size++;
		add(0, e);
	}
	
	public void addLast(E e) {
		add(size, e);
	}

	public E get(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("index is not correct");
		
		Node cur = dummyhead.next;
		for(int i = 0; i < index;i++) {
			cur = cur.next;
		}
		return cur.e;
	}
	
	public void set(E e, int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("index is not correct");
		
		Node cur = dummyhead.next;
		for(int i=0; i < index; i++) {
			cur = cur.next;
		}
		cur.e = e;
	}
	
	
	public boolean find(E e) {
		Node cur = dummyhead;
		while(cur != null) {
			cur = cur.next;
			if(cur.e.equals(e))
				return true;
		}
		return false;
	}
	
	public Node reverseLinkedNode(Node head) {
		if(head == null || head.next == null)
			return head;
		else {
			Node newHead;
			newHead = reverseLinkedNode(head);
			head.next.next = head;
			head.next = null;
			return newHead;
				}
	}
	
	public E removeNode(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("index is not correct");
		Node pre = dummyhead;
		Node cur;
		
		for(int i = 0; i < index; i++) {
			pre = pre.next;
		}
		cur = pre.next;
		pre.next = cur.next;
		cur.next = null;
		size--;
		return cur.e;
	}
	
	public E removeFist() {
		return removeNode(0);
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("LinkedList: ");
		Node cur = dummyhead;
		while(cur != null) {
			res.append(cur.next);
			if (cur.next != null) {
				res.append("->");
			}
			cur = cur.next;
		}
		/*res.append("NULL");
		for(Node cur = dummyhead.next; cur != null; cur = cur.next) {
			res.append(cur);
		}
		res.append(""null");*/
		return res.toString();
	}
}
