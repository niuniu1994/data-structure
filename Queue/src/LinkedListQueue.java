
public class LinkedListQueue<E> implements Queue<E>{
	
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
	
	private Node head,tail;
	int size;

	public LinkedListQueue() {
		head = null;
		tail = new Node();
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(E e) {
		if(tail == null) {
		tail = new Node(e);
		head = tail;
		}else {
			tail.next = new Node(e);
			tail = tail.next;
		}
		size++;
	}

	@Override
	public E dequeue() {
		if(isEmpty())
			throw new IllegalArgumentException("the queue is empty");
		Node cur = head;
		head = head.next;
		cur = null;
		if(head == null)
			tail = head;
		size--;
		return null;
	}

	@Override
	public E getFront(){
		if(isEmpty())
			throw new IllegalArgumentException("the queue is empty");
		return head.e;
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Queue :head ");
		Node cur = head;
		while(cur != null) {
			res.append(cur + "->");
			cur = cur.next;
		}
		
		res.append("NULL tail");
		/*res.append("NULL");
		for(Node cur = dummyhead.next; cur != null; cur = cur.next) {
			res.append(cur);
		}
		res.append(""null");*/
		return res.toString();
	}
	
	public static void main(String[] args) {
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
		for(int i = 0; i < 10; i++) {
			linkedListQueue.enqueue(i);
			System.out.println(linkedListQueue);
			//if(i % 3 == 2) {
				//linkedListQueue.dequeue();
			//	System.out.println(linkedListQueue);		
			}
		}
	
	}

