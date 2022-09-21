
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

	/*public  void add(int index ,E e){
		if(index > size|| index < 0)
			throw new IllegalArgumentException("the value of index is wrong");;
		head = add(index,e,head);
		size++;
	}

	public Node add(int index,E e,Node head){
		if(index == 0){
			return new Node(e,head);
		}else {
			head.next = add(index - 1,e,head.next);
			return head;
		}
	}*/

	
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
		while(cur.next != null) {
			if(e.equals(cur.next.e))
				return true;
			cur = cur.next;
		}
		return false;
	}
	
	public Node reverseLinkedNode(Node head) {
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

	public void removeElement(E e){
		Node cur = dummyhead;
		while (cur.next != null){
			if(e.equals(cur.next.e)){
				Node goal = cur.next;
				cur.next = goal.next;
				goal = null;
				break;
			}else
				cur = cur.next;
		}
	}
/*用递归实现删除节点，前提是不用dummuyhead
	public E removeNode(int index){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("index is not correct");
		head = removeNode(index,head);
		size--;
		return head;
	}

	public Node removeNode(int index,Node head){
		if(index == 0){
			return head.next;
		}
		else{
			head.next = removeNode(index -1 ,head.next);
			return head;
		}

	}
*/

	
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
