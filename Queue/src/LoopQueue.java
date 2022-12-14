

public class LoopQueue<E> implements Queue<E>{
	private E[] data;
	private int front,tail;
	private int size;
	
	public LoopQueue(int capacity) {
		data = (E[])new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}
	
	public LoopQueue() {
		this(10);
	}
	
	public int getCapacity() {
		return data.length - 1 ;
	}
	
	public boolean isEmpty() {
		return front == tail;
	}
	
	public int getSize() {
		return size;
	}
	
	public void  enqueue(E e) {
		if((tail + 1) % data.length ==front){
			resize(getCapacity()*2);
		}
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
	}
	
	public E dequeue() {
		if(isEmpty())
			throw new IllegalArgumentException("the queue can not be empty");
		E ret = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
			resize(getCapacity() / 2);
		return ret;
		
	}

	private void resize(int capacity) {
		E[] dataNew = (E[]) new Object[capacity + 1];
		for(int i = 0;i < size;i++) {
			dataNew[i] = data[(i + front) % dataNew.length];
		}
		data = dataNew;
		front = 0;
		tail = size;
	}

	@Override
	public E getFront() {
		if(isEmpty())
			throw new IllegalArgumentException("the queue can not be empty");
		return data[front];
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Queue: size=%d,capacity=%d\n", size,getCapacity()));
		res.append('[');
		/*for(int i = front; i < tail; i = (i + 1)%data.length) {
			res.append(data[i]);
			if((i+1) % data.length != tail)
				res.append(",");
		}*/
		
		for (int i = 0; i < size; i++) {
			res.append(data[(i + front) % data.length]);
			if((i + front + 1) % data.length != tail)
				res.append(',');
		}
		res.append(']');
		return res.toString();
	}
	
	public static void main(String[] args) {
		LoopQueue<Integer> queue = new LoopQueue<Integer>();
		for(int i = 0; i < 10; i++) {
			queue.enqueue(i);
			System.out.println(queue);
			
			if(i % 3 == 2) {
				queue.dequeue();
				System.out.println();
			}
		}
	}
}
