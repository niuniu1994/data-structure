
public class Array<E> {

	private E[] data;
	private int size;
	
	public Array(int capacity) {
		data = (E[])(new Object[capacity]);//java不支持直接创建泛形的数组，所以用强制转换Object
		size=0;
	}
	
	public Array() {	
		this(10);//因为this(10)调用的当前类（Array类）的包含一个int型参数的构造函数。
	}
	
	public int getSize() {
		return size;}
	
	public int getCapacity() {
		return data.length;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void addFirst(E e) {
		add(0, e);
	}
	
	public void addLast(E e) {
		add(size, e);
	}
	
	public void add(int index, E e) {
		
		if(index<0 ||index>size)
			throw new IllegalArgumentException("index is not correct");
		if(size==data.length) 
			resize(data.length*2);
		for(int i=size-1; index<=i; i--) {
			data[i+1]=data[i];
		}
		data[index]=e;
		size++;
	}
	
	private void resize(int i) {
		// TODO Auto-generated method stub
		E[] newData = (E[])(new Object[i]);
		for(int x = 0 ; x < size; x ++) {
			newData[x] = data[x];
		}
		
		data = newData;
	}

	public E remove(int index) {
		if(index<0 ||index>size)
			throw new IllegalArgumentException("index is not correct");
		
		E retE = data[index];
		for (int i = index; i < size-1; i++) {
			data[i] = data[i + 1];
		}
		
		data[size] = null;//loitering objects游荡的对象
		size--;
		
		if(size <= data.length/4) {//为了避免复杂度震荡我们除于4而不是2 ，我们采用lazy的策略而不是激进的侧罗
			resize(data.length/2);
		}
		
		return retE;
	}
	
	public void removeElment(E e) {
		int x = find(e);
		if(x != -1) {
			remove(x);
		}
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size-1);
	}
	
	//获取index位置元素
	public E get(int index) {
		if(index<0||index>size)
			throw new IllegalArgumentException("get is failed,index is not correct");
		return data[index];
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size - 1);
	}
	
	//修改index位置元素
	public void set(int index,E e) {
		if(index<0 ||index>size)
			throw new IllegalArgumentException("set is failed,index is not correct");
		data[index] = e;
	}
	
	//看是否包含e值
	public boolean contains(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e))
				return true;
		}
		return false;
	}
	//找到对应e值的索引index
	public int find(E e) {
		for(int i = 0;i < size;i++) {
			if(data[i] == e)
				return i;
		}
		return -1;
	}
	
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array：size = %d,Capability = %d\n", size,data.length));
		res.append('[');
		for(int i = 0; i < size; i++) {
			res.append(data[i]);
			if(i!=size-1)
			res.append(',');
		}
		res.append(']');
		return res.toString();
		}
}
