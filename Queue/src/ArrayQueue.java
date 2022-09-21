
public class ArrayQueue<E> implements Queue<E>{

	Array<E> array;
	public ArrayQueue() {
		array = new Array<E>();
	}
	
	public ArrayQueue(int capacity) {
		array = new Array<E>(capacity);
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return array.getSize();
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return array.isEmpty();
	}
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		array.addLast(e);
	}
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return array.removeFirst();
	}
	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return array.getFirst();
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Queue: ");
		res.append("front [");
		for (int i = 0; i < array.getSize(); i++) {
			res.append(i);
			if(i != array.getSize() - 1)
				res.append(",");
		}
		res.append("] tail");
		return res.toString();
	}

}
