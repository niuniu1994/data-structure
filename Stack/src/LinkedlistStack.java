
public class LinkedlistStack<E> implements Stack<E> {
	
	private LinkedList<E> linkedList;
	
	public LinkedlistStack() {
		linkedList = new LinkedList<E>();
	}

	@Override
	public void push(E e) {
		linkedList.addFirst(e);
	}

	@Override
	public E pop() {
		return linkedList.removeFist();
	}

	@Override
	public E peek() {
		return linkedList.get(0);
	}

	@Override
	public Boolean isEmpty() {
		return linkedList.isEmpty();
	}

	@Override
	public int getSize() {
		return linkedList.getSize();
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("stack : ");
		res.append(linkedList);
		return res.toString();
	}

}
