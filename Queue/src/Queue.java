
public interface Queue<E> {
	int getSize();
	boolean isEmpty();
	void enqueue(E e);//向队未加入
	E dequeue();//从队首取出
	E getFront();//查看队首是谁
}
