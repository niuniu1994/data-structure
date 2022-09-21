
public class arrayStack<E> implements Stack<E>{
	
	Array<E> array;
	
	public arrayStack(int capacity) {
		array = new Array<E>(capacity);
	}
	
	public arrayStack() {
		array = new Array<E>();
	}
	
	@Override
	public Boolean isEmpty() {
		return array.isEmpty();
	}
	
	@Override
	public int getSize() {
		return array.getSize();
	}
	
	@Override
	public void push(E e) {//向栈加一个元素
		array.addLast(e);
	}
	
	public int getCapacity() {
		return array.getCapacity();
	}

	@Override
	public E pop() {//删除栈顶元素
		return array.removeLast();
	}

	@Override
	public E peek() {//看一眼栈顶元素
		return array.getLast();
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Stack");
		res.append("[");
		for(int i = 0;i < array.getSize();i++) {
			res.append(array.get(i));
			if(i != array.getSize() - 1) {
				res.append(",");
			}
		}
		res.append("] top");
		return res.toString();
	}
}
